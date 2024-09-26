package com.company;

public class Room
{
    private String description;
    private boolean[] exits;
    private Room[] connectedRooms;
    private DictionaryParameter dictionaryParameter;
    private int numberOfDirections;
    private int x;
    private int y;
    private int z;

    public Room(String descriptionText, DictionaryParameter directions, int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        description = descriptionText;
        dictionaryParameter = directions;
        numberOfDirections = dictionaryParameter.getNumberOfWords();
        exits = new boolean[numberOfDirections];
        connectedRooms = new Room[numberOfDirections];

        int i;
        // Start by i=1 because the first dictionary parameter is not a valid direction or action
        for (i = 1; i < numberOfDirections; i = i + 1) {
            exits[i] = false;
        }
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getZ() { return z; }

    public void setExit(String direction, Room nextRoom) {
        int dirIndex = dictionaryParameter.find(direction);
        exits[dirIndex] = true;
        connectedRooms[dirIndex] = nextRoom;
    }

    public String getShortDescription() {
        return description;
    }

    // Verify if there is an exit in written direction
    public boolean isExit(String direction) {
        int directionCode = dictionaryParameter.find(direction);
        if (directionCode == 0) {
            return false;
        } else {
            return exits[directionCode];
        }
    }

    // Change and return the new room after entity move
    public Room nextRoom(String direction) {
        int directionCode;

        directionCode = dictionaryParameter.find(direction);
        return connectedRooms[directionCode];
    }
}