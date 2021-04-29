package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Album {

    String id;
    String title;
    String singer;

    static int lastId;

    public Album() {
        this.id = RandomUtils.getId();//se genera random la 1a vez
    }

    public Album(String title, String singer) {
        this();
        this.setSinger(singer);
        this.setTitle(title);
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id=id;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Album [id="+id+", title=" + title + ", pwd=" + singer +"]";
    }

}