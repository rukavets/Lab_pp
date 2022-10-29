package com.Records.InfoTrack;
public class AddInfoTrack extends Track{
    private String author;
    private String dateOfAdd;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateOfAdd() {
        return dateOfAdd;
    }

    public void setDateOfAdd(String dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }
    public String findNameByAuthor(String author){
        return toString();
    }
    public String findNameByTime(String time1, String Time2){
        return toString();
    }
}
