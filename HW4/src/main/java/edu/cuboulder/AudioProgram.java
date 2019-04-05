package edu.cuboulder;
import java.util.List;

public class AudioProgram extends  Item {
    private String artist;
    private String genre;
    private String audioFormat;
    private List songs;
    private String releaseDate;


    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public List getSongs() {
        return songs;
    }

    public String getArtist() {
        return artist;
    }

    public String getAudioFormat() {
        return audioFormat;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAudioFormat(String audioFormat) {
        this.audioFormat = audioFormat;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setSongs(List songs) {
        this.songs = songs;
    }

    public void showInfo(){
        System.out.println("showInfo place holder");

    }




}
