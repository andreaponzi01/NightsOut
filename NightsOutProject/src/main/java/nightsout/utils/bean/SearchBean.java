package nightsout.utils.bean;

public class SearchBean {
    private String searchText;

    public SearchBean(String input) {
        this.searchText = input;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
