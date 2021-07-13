package com.example.birds_gridview;

public class Bird {
    private int image;
    private String name;

    public Bird(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
