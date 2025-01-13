package api.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetListUsersResponse {

    @JsonProperty("page")
    private int page;
    @JsonProperty("per_page")
    private int perPage;
    @JsonProperty("total")
    private int total;
    @JsonProperty("total_pages")
    private int totalPages;
    private List<UserData> data;

    @JsonProperty("support")
    private SupportData support;

    public GetListUsersResponse (int page, int perPage, int total, int totalPages, List<UserData> data, SupportData support) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
        this.support = support;
    }

    public GetListUsersResponse () {

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<UserData> getData() {
        return data;
    }

    public void setData(List<UserData> data) {
        this.data = data;
    }

    public SupportData getSupport() {
        return support;
    }

    public void setSupport(SupportData support) {
        this.support = support;
    }
}
