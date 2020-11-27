package application;

public class Series {
    private int series_id;
    private String series_title;
    private String series_genre;
    private int series_seasons;

    public Series() {}
    public Series(int series_id, String series_title, String series_genre, int series_seasons) {
        this.series_id = series_id;
        this.series_title = series_title;
        this.series_genre = series_genre;
        this.series_seasons = series_seasons;
    }
    public int getSeries_id() { return series_id; }
    public void setSeries_id(int series_id) { this.series_id = series_id; }
    public String getSeries_title() { return series_title; }
    public void setSeries_title(String series_title) { this.series_title = series_title; }
    public String getSeries_genre() { return series_genre; }
    public void setSeries_genre(String series_genre) { this.series_genre = series_genre; }
    public int getSeries_seasons() { return series_seasons; }
    public void setSeries_seasons(int series_seasons) { this.series_seasons = series_seasons; }
}
