package api.pojos;

public class SupportData {
    private String url;
    private String text;

    public SupportData(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public SupportData () {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
