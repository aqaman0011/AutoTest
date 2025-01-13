package api.pojos;

public class PostCreateNewUserOrderReq {
    private String name;
    private String job;

    public PostCreateNewUserOrderReq(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public PostCreateNewUserOrderReq () {

    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
