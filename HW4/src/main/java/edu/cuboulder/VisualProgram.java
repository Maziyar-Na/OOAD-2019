package edu.cuboulder;

public class VisualProgram extends Item {
    private String director;
    private String genre;
    private Integer length;
    private String rating;
    private String star;
    private String coStar;
    private String category;


    public Integer getLength() {
        return length;
    }

    public String getCoStar() {
        return coStar;
    }

    public String getDirector() {
        return director;
    }


    public String getGenre() {
        return genre;
    }

    public String getCategory() {
        return category;
    }

    public String getRating() {
        return rating;
    }

    public String getStar() {
        return star;
    }

    public void setCoStar(String coStar) {
        this.coStar = coStar;
    }


    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setStar(String star) {
        this.star = star;
    }

}
