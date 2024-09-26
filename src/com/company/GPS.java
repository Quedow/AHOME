package com.company;

public class GPS {

    public GPS(){

    }

    // Calculate distance between player and jason
    public int distanceBetween(int x1, int y1, int x2, int y2, int z1, int z2){
        int distance = 0;
        distance = square(x2-x1)+square(y2-y1)+square(z2-z1);
        distance = squareRoot(distance);
        return distance;
    }

    // Square function
    public int square(int value){
        value *= value;
        return value;
    }

    // Sqrt function
    public int squareRoot(int value){
        value = value*10;
        value = (int) Math.sqrt(value);
        return value;
    }
}
