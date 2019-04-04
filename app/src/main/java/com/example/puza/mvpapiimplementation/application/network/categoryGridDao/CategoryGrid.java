package com.example.puza.mvpapiimplementation.application.network.categoryGridDao;

public class CategoryGrid {

    private String name;
    private  int thumbnail;
    private String categoryGridDes;

    public CategoryGrid(String name, int thumbnail, String categoryGridDes) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.categoryGridDes = categoryGridDes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCategoryGridDes() {
        return categoryGridDes;
    }

    public void setCategoryGridDes(String categoryGridDes) {
        this.categoryGridDes = categoryGridDes;
    }
}
