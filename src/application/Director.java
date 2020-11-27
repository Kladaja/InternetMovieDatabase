package application;

import java.util.Date;

public class Director {
    private int director_id;
    private String director_first_name;
    private String director_last_name;
    private Date director_birth_date;

    public Director() {}

    public Director(int director_id, String director_first_name, String director_last_name, Date director_birth_date) {
        this.director_id = director_id;
        this.director_first_name = director_first_name;
        this.director_last_name = director_last_name;
        this.director_birth_date = director_birth_date;
    }
    public int getDirector_id() { return director_id; }
    public void setDirector_id(int director_id) { this.director_id = director_id; }
    public String getDirector_first_name() { return director_first_name; }
    public void setDirector_first_name(String director_first_name) { this.director_first_name = director_first_name; }
    public String getDirector_last_name() { return director_last_name; }
    public void setDirector_last_name(String director_last_name) { this.director_last_name = director_last_name; }
    public Date getDirector_birth_date() { return director_birth_date; }
    public void setDirector_birth_date(Date director_birth_date) { this.director_birth_date = director_birth_date; }
}
