package com.company;

import java.util.HashMap;

public class Elements extends Player
{
    private HashMap<Integer, String> itemList;
    private int nbrItemTotal;
    private HashMap<Integer, Integer> generatorList;
    private int nbrGenTotal;
    private int nbrGenDone;

    public Elements(){
        itemList = new HashMap<Integer, String>();
        nbrItemTotal = 2;
        generatorList = new HashMap<Integer, Integer>();
        nbrGenTotal = 3;
        nbrGenDone = 0;
    }

    public void setNbrGenTotal(Integer nbrGenTotal) {
        this.nbrGenTotal = nbrGenTotal;
    }

    public void setNbrItemTotal(Integer nbrItemTotal) {
        this.nbrItemTotal = nbrItemTotal;
    }

    public int getGenState(int numRoom){
        return generatorList.get(numRoom);
    }

    // Verify if generator is already repaired
    public boolean genAlreadyRepair(int numRoom){
        Integer state = generatorList.get(numRoom);
        return state == 2;
    }

    // Repair generator of the room numRoom by incrementing its state by 1
    public void repairGen(int numRoom){
        Integer state = generatorList.get(numRoom);
        generatorList.put(numRoom,state+1);
    }

    // Verify if all state of all gen are equal to 2
    public boolean allGenDone(){
        int nbrGenDoneInter = 0;
        for (Integer i : generatorList.keySet()) {
            if(generatorList.get(i) == 2){
                nbrGenDoneInter++;
                nbrGenDone = nbrGenDoneInter;
            }
        }
        return nbrGenDone >= nbrGenTotal;
    }

    public int nbrGenDone(){
        return nbrGenDone;
    }

    public int nbrGenTotal(){
        return nbrGenTotal;
    }

    // Manage the apparition of gen in random rooms
    public void genSpawn(int nbrOfRoom){
        if (nbrGenTotal > nbrOfRoom){
            nbrGenTotal = nbrOfRoom;
        }
        while (generatorList.size() < nbrGenTotal){
            int roomSpawn = randomValue(0,nbrOfRoom);
            generatorList.put(roomSpawn,0);
        }
    }

    // Remove the item of associated room
    public void removeItem(int numRoom){
        itemList.remove(numRoom);
    }

    // Manage the apparition of items in random rooms
    public void itemSpawn(int nbrOfRoom){
        if (nbrItemTotal > nbrOfRoom){
            nbrItemTotal = nbrOfRoom;
        }
        while (itemList.size() < nbrItemTotal){
            int roomSpawn = randomValue(0,nbrOfRoom);
            int itemType = randomValue(0, this.itemType.size()-1);
            itemList.put(roomSpawn, this.itemType.get(itemType));
        }
    }

    // Verify the existing gen in room of index i
    public boolean genKeyExist(int i){
        return generatorList.containsKey(i);
    }

    // Verify the existing item in room of index i
    public boolean itemKeyExist(int i){
        return itemList.containsKey(i);
    }

    public int randomValue(int borneInf, int borneSup){
        return (int)(Math.random() * ((borneSup - borneInf) + 1)) + borneInf;
    }

    // Send item type of associated room
    public String itemType(int numRoom) {
        return itemList.get(numRoom);
    }
}
