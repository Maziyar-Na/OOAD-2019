package edu.cuboulder;

import java.util.Date;

public class Publication extends Item {
    private String isbn_10;
    private String author;
    private String url;
    private String isbn_13;
    private String language;
    private String format;
    private Date publishDate;
    private String publisher;
    private String subTitle;
    private String category;
    private Integer pageCount;
    private String minorSubject;
    private String SecondarySubject;


    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }


    public Integer getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getFormat() {
        return format;
    }

    public String getIsbn_10() {
        return isbn_10;
    }

    public String getIsbn_13() {
        return isbn_13;
    }

    public String getLanguage() {
        return language;
    }

    public String getMinorSubject() {
        return minorSubject;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getSecondarySubject() {
        return SecondarySubject;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setIsbn_10(String isbn_10) {
        this.isbn_10 = isbn_10;
    }

    public void setIsbn_13(String isbn_13) {
        this.isbn_13 = isbn_13;
    }


    public void setLanguage(String language) {
        this.language = language;
    }

    public void setMinorSubject(String minorSubject) {
        this.minorSubject = minorSubject;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setSecondarySubject(String secondarySubject) {
        SecondarySubject = secondarySubject;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
