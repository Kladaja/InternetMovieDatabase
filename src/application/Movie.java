package application;

public class Movie {
    private int movie_id;
    private String movie_title;
    private String movie_genre;
    private int movie_length;

    public Movie() {}
    public Movie(int movie_id, String movie_title, String movie_genre, int movie_length) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.movie_genre = movie_genre;
        this.movie_length = movie_length;
    }
    public int getMovie_id() { return movie_id; }
    public void setMovie_id(int movie_id) { this.movie_id = movie_id; }
    public String getMovie_title() { return movie_title; }
    public void setMovie_title(String movie_title) { this.movie_title = movie_title; }
    public String getMovie_genre() { return movie_genre; }
    public void setMovie_genre(String movie_genre) { this.movie_genre = movie_genre; }
    public int getMovie_length() { return movie_length; }
    public void setMovie_length(int movie_length) { this.movie_length = movie_length; }
}
