package com.example.self.UsersClasses;

public class StartBMIData {
    int physical,mental,social,weight,height;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public StartBMIData() {
    }

    public int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public int getMental() {
        return mental;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public StartBMIData(int physical, int mental, int social,int weight,int height) {
        this.physical = physical;
        this.mental = mental;
        this.social = social;
        this.weight=weight;
        this.height=height;
    }
}
