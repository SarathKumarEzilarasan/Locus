package models;

import java.util.ArrayList;

public class GetBooks {
    ArrayList<Book> docs;

    public ArrayList<Book> getDocs() {
        return docs;
    }

    public void setDocs(ArrayList<Book> docs) {
        this.docs = docs;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    String total;
    String limit;
    String offset;
    String page;
    String pages;


}
