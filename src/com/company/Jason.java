package com.company;

import java.util.Random;
import java.util.Scanner;

public class Jason
{
    private int x;
    private int y;
    private int z;
    private int a;
    private int b;
    private char letter;
    private int valueTestTime;
    private int letterTestTime;
    private int valueTestMax;
    private int valueTestMin;

    public Jason(){
        valueTestTime = 3000;
        letterTestTime = 2500;
        valueTestMax = 11;
        valueTestMin = 0;
        x = 0;
        y = 0;
        z = 0;
        a = 0;
        b = 0;
        letter = 'a';
    }

    // Start random skill test
    public boolean skillTest(){
        int kindTest = randomValue(1,2);
        return kindTest == 1;
    }

    public int initializeA() {
        this.a = randomValue(valueTestMin, valueTestMax);
        return a;
    }

    public int initializeB() {
        this.b = randomValue(valueTestMin, valueTestMax);
        return b;
    }

    public char initializeLetter(){
        Random rand = new Random();
        this.letter = (char) (rand.nextInt(26) + 97);
        return letter;
    }

    // Return if player win the test in giving time
    public boolean calculationTest(){
        long startTest = System.currentTimeMillis();
        int result = -1;

        try {
            result = new Scanner(System.in).nextInt();
        }catch (Exception ignored){}

        long timeTest = System.currentTimeMillis()-startTest;
        return result == a * b && timeTest <= valueTestTime;
    }


    // Return if player win the letter test in giving time
    public boolean letterTest(){
        long startTest = System.currentTimeMillis();
        String result = new Scanner(System.in).next();
        long timeTest = System.currentTimeMillis()-startTest;

        return result.toLowerCase().equals(String.valueOf(letter)) && timeTest <= letterTestTime;
    }

    public void setValueTestTime(Integer valueTestTime) {
        this.valueTestTime = valueTestTime;
    }

    public void setLetterTestTime(Integer letterTestTime) {
        this.letterTestTime = letterTestTime;
    }

    public void setValueTestMax(Integer valueTestMax) {
        this.valueTestMax = valueTestMax;
    }

    public void setValueTestMin(Integer valueTestMin) {
        this.valueTestMin = valueTestMin;
    }

    // jason choose a random direction to move
    public String randomDirection(){
        String[] tabDirection = {"haut", "bas", "droite", "gauche", "up", "down"};
        int randomIndex = randomValue(0, tabDirection.length-1);
        return tabDirection[randomIndex];
    }

    // Verify that the choose direction is validated and change room if json is in the same room of the player
    public Room moveJason(Room jasonRoom, Room currentRoom){
        if(jasonRoom != currentRoom) {
            String randomDirection;
            int counter = 100;
            do {
                randomDirection = randomDirection();
                counter--;
            } while (!jasonRoom.isExit(randomDirection) && counter >= 0);

            if (counter > 0) {
                jasonRoom = jasonRoom.nextRoom(randomDirection);

                setPosition(randomDirection);
                return jasonRoom;
            } else {
                System.exit(1); //Means that jason is blocked
            }
        }
        return currentRoom;
    }

    public void setXYZ(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Update jason position
    public void setPosition(String direction){
        if (direction.equals("haut")) {
            moinsX();
        }
        if (direction.equals("bas")) {
            plusX();
        }
        if (direction.equals("droite")) {
            plusY();
        }
        if (direction.equals("gauche")) {
            moinsY();
        }
        if (direction.equals("up")){
            plusZ();
        }
        if (direction.equals("down")){
            moinsZ();
        }
    }

    public void plusX(){ this.x += 1; }

    public void moinsX(){ this.x -= 1; }

    public void plusY(){ this.y += 1; }

    public void moinsY(){ this.y -= 1; }

    public void plusZ() { this.z += 1; }

    public void moinsZ() { this.z -= 1; }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getZ() { return z; }

    public int randomValue(int borneInf, int borneSup){
        return (int)(Math.random() * ((borneSup - borneInf) + 1)) + borneInf;
    }
}
