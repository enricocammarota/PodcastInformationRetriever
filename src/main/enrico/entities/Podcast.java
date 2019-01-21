package enrico.entities;

import java.util.List;

public class Podcast {

    private String wrapperType;
    private String kind;
    private Integer artistId;
    private Integer collectionId;
    private Integer trackId;
    private String artistName;
    private String collectionName;
    private String trackName;
    private String collectionCensoredName;
    private String trackCensoredName;
    private String artistViewUrl;
    private String collectionViewUrl;
    private String feedUrl;
    private String trackViewUrl;
    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;
    private String artworkUrl600;
    private String releaseDate;
    private String country;
    private String primaryGenreName;
    private List<String> genres;

    private String title;
    private String description;

    public Podcast() {

    }

    public Podcast (String wrapperType, String kind, Integer artistId, Integer collectionId, Integer trackId, String artistName, String collectionName, String trackName, String collectionCensoredName, String trackCensoredName,
                    String artistViewUrl, String collectionViewUrl, String feedUrl, String trackViewUrl, String artworkUrl30, String artworkUrl60, String artworkUrl100, String artworkUrl600, String releaseDate, String country,
                        String primaryGenreName, List<String> genres) {
        this.wrapperType = wrapperType;
        this.kind = kind;
        this.artistId = artistId;
        this.collectionId = collectionId;
        this.trackId = trackId;
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.trackName = trackName;
        this.collectionCensoredName = collectionCensoredName;
        this.trackCensoredName = trackCensoredName;
        this.artistViewUrl = artistViewUrl;
        this.collectionViewUrl = collectionViewUrl;
        this.feedUrl = feedUrl;
        this.trackViewUrl = trackViewUrl;
        this.artworkUrl30 = artworkUrl30;
        this.artworkUrl60 = artworkUrl60;
        this.artworkUrl100 = artworkUrl100;
        this.artworkUrl600 = artworkUrl600;
        this.releaseDate = releaseDate;
        this.country = country;
        this.primaryGenreName = primaryGenreName;
        this.genres = genres;
    }

    public Podcast (String wrapperType, String kind, Integer artistId, Integer collectionId, Integer trackId, String artistName, String collectionName, String trackName, String collectionCensoredName, String trackCensoredName,
                    String artistViewUrl, String collectionViewUrl, String feedUrl, String trackViewUrl, String artworkUrl30, String artworkUrl60, String artworkUrl100, String artworkUrl600, String releaseDate, String country,
                    String primaryGenreName, List<String> genres, String title, String description) {
        this.wrapperType = wrapperType;
        this.kind = kind;
        this.artistId = artistId;
        this.collectionId = collectionId;
        this.trackId = trackId;
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.trackName = trackName;
        this.collectionCensoredName = collectionCensoredName;
        this.trackCensoredName = trackCensoredName;
        this.artistViewUrl = artistViewUrl;
        this.collectionViewUrl = collectionViewUrl;
        this.feedUrl = feedUrl;
        this.trackViewUrl = trackViewUrl;
        this.artworkUrl30 = artworkUrl30;
        this.artworkUrl60 = artworkUrl60;
        this.artworkUrl100 = artworkUrl100;
        this.artworkUrl600 = artworkUrl600;
        this.releaseDate = releaseDate;
        this.country = country;
        this.primaryGenreName = primaryGenreName;
        this.genres = genres;
        this.title = title;
        this.description = description;
    }


    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public String getArtworkUrl600() {
        return artworkUrl600;
    }

    public void setArtworkUrl600(String artworkUrl600) {
        this.artworkUrl600 = artworkUrl600;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
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

    public void print() {
        System.out.println("\n");
        System.out.println("Podcast Information");
        System.out.println("Title:  " + this.getTitle());
        System.out.println("Description:  " + this.getDescription());
        System.out.println("ArtistName:  " + this.getArtistName());
        System.out.println("FeedURL:  " + this.getFeedUrl());
        System.out.println("PrimaryGenreName:  " + this.getPrimaryGenreName());
        System.out.println("PrimaryGenreName:  " + this.getGenres());
        System.out.println("ReleaseDate:  " + this.getReleaseDate());
        System.out.println("\n");
        System.out.println("\n");
    }

}
