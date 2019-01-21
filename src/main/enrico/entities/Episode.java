package enrico.entities;

public class Episode {

    private String title;
    private String description;
    private String duration;
    private String publicationDate;
    private String guid;

    public Episode() {

    }

    public Episode(String title, String description, String duration, String publicationDate, String guid) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.publicationDate = publicationDate;
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void print() {
        System.out.println("Title: " + this.getTitle());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Duration: " + this.getDuration());
        System.out.println("GuID: " + this.getGuid());
        System.out.println("Publication Date: " + this.getPublicationDate());
        System.out.println("****************");
        System.out.println("\n");
    }
}
