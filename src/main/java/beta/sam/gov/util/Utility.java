package beta.sam.gov.util;

import beta.sam.gov.entites.Prospect;
import beta.sam.gov.entites.QueryParams;
import beta.sam.gov.entites.ResultsWrapper;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class Utility {

	@Autowired
	RestTemplate restTemplate;

	@Value("${directory}")
	String filepath;

	public List<QueryParams> getQueryParams() throws FileNotFoundException {
		return (List<QueryParams>) new CsvToBeanBuilder(new FileReader(filepath + "QueryParams.csv"))
				.withType(QueryParams.class).build().parse();
	}

	public ResultsWrapper getResultsWrapper(QueryParams queryParam) {
		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("beta.sam.gov")
				.path("api/prod/sgs/v1/search").queryParam("index", queryParam.getIndex())
				.queryParam("q", queryParam.getQ()).queryParam("page", queryParam.getPage())
				.queryParam("sort", queryParam.getSort()).queryParam("mode", queryParam.getMode())
				.queryParam("is_active", queryParam.getIs_active()).queryParam("naics", queryParam.getNaics())
				.queryParam("notice_type", queryParam.getNotice_type())
				.queryParam("set_aside", queryParam.getSet_aside()).build().encode();
		System.out.println(uri.toString());
		return restTemplate.getForObject(uri.toString(), ResultsWrapper.class);
	}

	public void generateSpreadSheet(ResultsWrapper results, QueryParams queryParams) {
		String[] columns = { "isCanceled", "_rScore", "_type", "publishDate", "isActive", "title", "type",
				"descriptions", "solicitationNumber", "responseDate", "parentNoticeId", "award", "modifiedDate",
				"organizationHierarchy", "_id", "modifications" };

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("data");
		Font headerFont = workbook.createFont();
		headerFont.setBoldweight((short) 2);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.SKY_BLUE.getIndex());
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		int rowNum = 1;
		for (Prospect prospect : Objects.requireNonNull(results).getEmbedded().getResults()) {
			Row row = sheet.createRow(rowNum++);
			int colNum = 0;
			row.createCell(colNum++).setCellValue(prospect.getIsCanceled().toString());
			row.createCell(colNum++).setCellValue(prospect.getRScore());
			row.createCell(colNum++).setCellValue(prospect.getOppertunityType());
			row.createCell(colNum++).setCellValue(prospect.getPublishDate());
			row.createCell(colNum++).setCellValue(prospect.getIsActive());
			row.createCell(colNum++).setCellValue(prospect.getTitle());
			row.createCell(colNum++).setCellValue(prospect.getType().getValue());
			row.createCell(colNum++).setCellValue(prospect.getDescriptions().get(0).getContent());
			row.createCell(colNum++).setCellValue(prospect.getSolicitationNumber());
			row.createCell(colNum++).setCellValue(prospect.getResponseDate());
			row.createCell(colNum++).setCellValue(prospect.getParentNoticeId());
			row.createCell(colNum++).setCellValue(prospect.getAward().getAwardee().getName());
			row.createCell(colNum++).setCellValue(prospect.getModifiedDate());
			row.createCell(colNum++).setCellValue(prospect.getModifications().getCount());
			row.createCell(colNum++).setCellValue(prospect.getId());
			row.createCell(colNum++).setCellValue(prospect.getOrganizationHierarchy().size());
		}
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		try (FileOutputStream fileOut = new FileOutputStream(new File(filepath + queryParams.toString()
				+ String.format("-%1$tY-%1$tm-%1$td-%1$tk-%1$tS-%1$tp", new Date()) + "-.xls"))) {
			workbook.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
