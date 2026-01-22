package com.example.jalgibook;

import java.io.Serializable;

public class Jalgi implements Serializable {
    private String name;
    private int weight;
    private String description;
    private int aura;
    private int girth;
    private int imageResId;
    private boolean active;

    public Jalgi(String name, int weight, String description, int aura, int girth, int imageResId) {
        this.name = name;
        this.weight = weight;
        this.description = description;
        this.aura = aura;
        this.girth = girth;
        this.imageResId = imageResId;
        this.active = false;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public int getAura() {
        return aura;
    }

    public int getGirth() {
        return girth;
    }

    public int getImageResId() {
        return imageResId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
