package application;

public class Studio {
    private int studio_id;
    private String studio_name;
    private String studio_country;
    private String studio_owner;
    private int studio_founded;

    public Studio() {}
    public Studio(int studio_id, String studio_name, String studio_country, String studio_owner, int studio_founded) {
        this.studio_id = studio_id;
        this.studio_name = studio_name;
        this.studio_country = studio_country;
        this.studio_owner = studio_owner;
        this.studio_founded = studio_founded;
    }
    public int getStudio_id() { return studio_id; }
    public void setStudio_id(int studio_id) { this.studio_id = studio_id; }
    public String getStudio_name() { return studio_name; }
    public void setStudio_name(String studio_name) { this.studio_name = studio_name; }
    public String getStudio_country() { return studio_country; }
    public void setStudio_country(String studio_country) { this.studio_country = studio_country; }
    public String getStudio_owner() { return studio_owner; }
    public void setStudio_owner(String studio_owner) { this.studio_owner = studio_owner; }
    public int getStudio_founded() { return studio_founded; }
    public void setStudio_founded(int studio_founded) { this.studio_founded = studio_founded; }
}
