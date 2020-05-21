package beta.sam.gov.entites;

import com.opencsv.bean.CsvBindByName;

public class QueryParams {
    private static final long serialVersionUID = 1L;
    @CsvBindByName
    private String index;
    @CsvBindByName
    private String q;
    @CsvBindByName
    private String page;
    @CsvBindByName
    private String sort;
    @CsvBindByName
    private String mode;
    @CsvBindByName
    private String is_active;
    @CsvBindByName
    private String naics;
    @CsvBindByName
    private String notice_type;
    @CsvBindByName
    private String set_aside;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getNaics() {
        return naics;
    }

    public void setNaics(String naics) {
        this.naics = naics;
    }

    public String getNotice_type() {
        return notice_type;
    }

    public void setNotice_type(String notice_type) {
        this.notice_type = notice_type;
    }

    public String getSet_aside() {
        return set_aside;
    }

    public void setSet_aside(String set_aside) {
        this.set_aside = set_aside;
    }

    @Override
    public String toString() {
        return "index " + index +
                "q " + q +
                "page " + page +
                "sort " + sort +
                "mode " + mode +
                "is_active " + is_active +
                "naics " + naics +
                "notice_type " + notice_type +
                "set_aside " + set_aside;
    }
}
