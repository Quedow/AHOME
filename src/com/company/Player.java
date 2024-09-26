package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Player
{
    private int x;
    private int y;
    private int z;
    private int life;
    private final int nbrItemMax;
    private HashMap<String, Integer> inventory;
    protected ArrayList<String> itemType;

    public  Player(){
        inventory = new HashMap<String, Integer>();
        itemType = new ArrayList<String>();
        nbrItemMax = 1;
        life = 2;
        x = 0;
        y = 0;
        z = 0;
        initializeItemType();
    }

    public void initializeItemType(){
        itemType.add("careKit");
        itemType.add("toolCase");
    }

    public void looseLife(){
        life--;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public int getLife(){
        return life;
    }

    // Return true if player alive (lives > 0)
    public boolean isAlive(){
        return life > 0;
    }

    // If player use careKit return true, get all lives et remove item
    public  int careKit(){
        if (inventory.containsKey(itemType.get(0))){
            if(life < 2) {
                life = 2;
                inventory.remove(itemType.get(0));
                return 1;
            }
            else {
                return -1;
            }
        }
        return 0;
    }

    // If player use toolCase then return true and remove item from inventory
    public boolean toolCase() {
        if (inventory.containsKey(itemType.get(1))){
            inventory.remove(itemType.get(1));
            return true;
        }
        else {
            return false;
        }
    }

    // If inventory empty then add item taken
    public boolean getItem(String itemHere){
        if (itemHere == null || inventory.size() > nbrItemMax-1){
            return false;
        }else{
            inventory.put(itemHere, 1);
            return true;
        }
    }

    public void setXYZ(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Update player position
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
}

