package beta.sam.gov.controller;

import beta.sam.gov.entites.Prospect;
import beta.sam.gov.entites.ResultsWrapper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class Executioner {

    @Autowired
    RestTemplate restTemplate;

    @PostConstruct
    public void pullRecords() throws IOException {
        ResultsWrapper results = restTemplate.getForObject(
                "https://beta.sam.gov/api/prod/sgs/v1/search/?index=opp&q=dla&page=0&sort=-relevance&mode=search&is_active=true&naics=51,54,55&notice_type=r,p,o&set_aside=SBA,SDVOSBC", ResultsWrapper.class);
        String[] columns = {
                "isCanceled",
                "_rScore",
                "_type",
                "publishDate",
                "isActive",
                "title",
                "type",
                "descriptions",
                "solicitationNumber",
                "responseDate",
                "parentNoticeId",
                "award",
                "modifiedDate",
                "organizationHierarchy",
                "_id",
                "modifications"};

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("data");

        Font headerFont = workbook.createFont();
        headerFont.setBoldweight((short) 2);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowNum = 1;
        for (Prospect prospect : results.getEmbedded().getResults()) {
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

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("prospects.xls");
        workbook.write(fileOut);
        fileOut.close();
    }
}
