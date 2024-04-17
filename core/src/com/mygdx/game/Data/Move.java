package com.mygdx.game.Data;

public class Move {
    int currentPP;
    int maxPP;
    String name;
    String details;
    Type type;
    int damage;
    Status status;
    int accuracy;

    public Move(int currentPP, int maxPP, String name, String details, Type type, int damage, Status status, int accuracy){
        this.currentPP = currentPP;
        this.maxPP = maxPP;
        this.name = name;
        this.details = details;
        this.type = type;
        this.damage = damage;
        this.status = status;
        this.accuracy = accuracy;
    }

    public void useMove(){
        if(currentPP > 0){
            currentPP--;
        }
    }



    public boolean isUsable(){
        return currentPP > 0;
    }

    public int getCurrentPP() {
        return currentPP;
    }

    public void setCurrentPP(int currentPP) {
        this.currentPP = currentPP;
    }

    public int getMaxPP() {
        return maxPP;
    }

    public void setMaxPP(int maxPP) {
        this.maxPP = maxPP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String toString(){
        return name;
    }


}
