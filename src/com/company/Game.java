package com.company;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Game
{
    private final DictionaryParameter dictionaryParameter;
    private Room playerRoom, goalRoom, jasonRoom;
    private Player player;
    private Jason jason;
    private int playerRoomIndex;
    private int jasonRoomIndex;
    private int goalRoomIndex;
    private Elements elements;
    private ArrayList<Room> tabRooms;
    private int numRoom;
    private List<String> listRoom;
    private GPS gps;
    private int doAction;
    private String mapName;

    public Game(){
        dictionaryParameter = new DictionaryParameter();
        tabRooms = new ArrayList<Room>();
        elements = new Elements();
        player = new Player();
        jason = new Jason();
        gps = new GPS();
        doAction = 0;
        mapName = "";
    }

    // ------------------------------ Room part ------------------------------

    public void createRoomsNormal() {
        mapName = "l'ÉCOLE EN RUINE DE WHITECHAPEL";

        Room room0, room1, room2, room3, room4, room5, room6, room7, room8, room9, room10, room11, room12;

        listRoom = Arrays.asList("la SALLE DE CLASSE 0", "la RECEPTION", "la RESERVE", "le COULOIR 3", "le COULOIR 4",
                "la SALLE DE CLASSE 5", "le LABO", "le COULOIR 7", "la SALLE DE CLASSE 8", "la CAVE", "la BIBLIOTHEQUE",
                "l'ADMIN", "un JARDIN");

        // Create all different rooms
        room0 = new Room(listRoom.get(0), dictionaryParameter, 0, 0, 0);
        room1 = new Room(listRoom.get(1), dictionaryParameter, 0, 1, 0);
        room2 = new Room(listRoom.get(2), dictionaryParameter, 0, 2, 0);
        room3 = new Room(listRoom.get(3), dictionaryParameter, 1, 0, 0);
        room4 = new Room(listRoom.get(4), dictionaryParameter, 1, 1, 0);
        room5 = new Room(listRoom.get(5), dictionaryParameter, 1, 2, 0);
        room6 = new Room(listRoom.get(6), dictionaryParameter, 2, 0, 0);
        room7 = new Room(listRoom.get(7), dictionaryParameter, 2, 1, 0);
        room8 = new Room(listRoom.get(8), dictionaryParameter, 2, 2, 0);
        room9 = new Room(listRoom.get(9), dictionaryParameter, 0, 0, -1);
        room10 = new Room(listRoom.get(10), dictionaryParameter, 2, 0, 1);
        room11 = new Room(listRoom.get(11), dictionaryParameter, 2, 1, 1);
        room12 = new Room(listRoom.get(12), dictionaryParameter, 1, 1, 1);


        // Initiate room exits
        room0.setExit("bas", room3); room0.setExit("down", room9);
        room1.setExit("bas", room4); room1.setExit("droite", room2);
        room2.setExit("bas", room5); room2.setExit("gauche", room1);
        room3.setExit("droite", room4); room3.setExit("bas", room6); room3.setExit("haut", room0);
        room4.setExit("gauche", room3); room4.setExit("droite", room5); room4.setExit("bas", room7); room4.setExit("haut", room1);
        room5.setExit("gauche", room4); room5.setExit("bas", room8); room5.setExit("haut", room2);
        room6.setExit("haut", room3); room6.setExit("droite", room7); room6.setExit("up",room10);
        room7.setExit("haut", room4); room7.setExit("gauche", room6); room7.setExit("droite", room8);
        room8.setExit("haut", room5); room8.setExit("gauche", room7);
        room9.setExit("up", room0);
        room10.setExit("down", room6); room10.setExit("droite", room11);
        room11.setExit("gauche", room10); room11.setExit("haut", room12);
        room12.setExit("bas", room11);

        // Initiate la exit room, la player and jason spawn room
        tabRooms.add(room0); tabRooms.add(room1); tabRooms.add(room2); tabRooms.add(room3); tabRooms.add(room4);
        tabRooms.add(room5); tabRooms.add(room6); tabRooms.add(room7); tabRooms.add(room8); tabRooms.add(room9);
        tabRooms.add(room10); tabRooms.add(room11); tabRooms.add(room12);

        setAndTransmitValue();

        createAllPosition();
    }

    public void createRoomsHard() {
        mapName = "l'HOPITAL HANTÉ DE CHANGI";

        Room room0, room1, room2, room3, room4, room5, room6, room7, room8, room9, room10;

        listRoom = Arrays.asList("la SALLE NEUROLOGIQUE", "la SALLE DE REANIMATION", "l'IMAGERIE MEDICAL", "le BLOC OPERATOIRE",
                "le COULOIR", "la RESERVE", "le LABORATOIRE", "la SALLE D'ATTENTE", "la RECEPTION", "la CAVE","l'ADMINISTRATION");

        room0 = new Room(listRoom.get(0), dictionaryParameter, 0, 1, 0);
        room1 = new Room(listRoom.get(1), dictionaryParameter, 0, 2, 0);
        room2 = new Room(listRoom.get(2), dictionaryParameter, 1, 2, 0);
        room3 = new Room(listRoom.get(3), dictionaryParameter, 1, 1, 0);
        room4 = new Room(listRoom.get(4), dictionaryParameter, 2, 1, 0);
        room5 = new Room(listRoom.get(5), dictionaryParameter, 3, 1, 0);
        room6 = new Room(listRoom.get(6), dictionaryParameter, 3, 2, 0);
        room7 = new Room(listRoom.get(7), dictionaryParameter, 4, 2, 0);
        room8 = new Room(listRoom.get(8), dictionaryParameter, 4, 1, 0);
        room9 = new Room(listRoom.get(9), dictionaryParameter, 0, 1, 1);
        room10 = new Room(listRoom.get(10), dictionaryParameter, 4, 0, 0);

        room0.setExit("bas", room3); room0.setExit("droite", room1); room0.setExit("up", room9);
        room1.setExit("bas", room2); room1.setExit("gauche", room0);
        room2.setExit("haut", room1); room2.setExit("gauche", room3);
        room3.setExit("haut", room0); room3.setExit("droite", room2); room3.setExit("bas", room4);
        room4.setExit("haut", room3); room4.setExit("bas", room5);
        room5.setExit("haut", room4); room5.setExit("bas", room8); room5.setExit("droite", room6);
        room6.setExit("gauche", room5);
        room7.setExit("gauche", room8);
        room8.setExit("haut", room5); room8.setExit("droite", room7); room8.setExit("gauche", room10);
        room9.setExit("down", room0);
        room10.setExit("droite", room8);

        tabRooms.add(room0); tabRooms.add(room1); tabRooms.add(room2); tabRooms.add(room3); tabRooms.add(room4);
        tabRooms.add(room5); tabRooms.add(room6); tabRooms.add(room7); tabRooms.add(room8); tabRooms.add(room9);
        tabRooms.add(room10);

        setAndTransmitValue();

        createAllPosition();
    }

    public int getTabRoomSize(){
        return tabRooms.size();
    }

    // Get x size of the map
    public int getXMaxRoom(){
        int Xmax = 0;
        for (Room tabRoom : tabRooms) {
            if (tabRoom.getX() > Xmax && tabRoom.getZ() == 0) {
                Xmax = tabRoom.getX();
            }
        }
        return Xmax;
    }

    // Get y size of the map
    public int getYMaxRoom(){
        int Ymax = 0;
        for (Room tabRoom : tabRooms) {
            if (tabRoom.getY() > Ymax && tabRoom.getZ() == 0) {
                Ymax = tabRoom.getY();
            }
        }
        return Ymax;
    }

    public int getXRoom(int index){
        return tabRooms.get(index).getX();
    }

    public int getYRoom(int index){
        return tabRooms.get(index).getY();
    }

    public int getZRoom(int index) {
        return tabRooms.get(index).getZ();
    }

    /* Verify if player is in the position room return by "showMap" from the "Vew" class to show a star *
    corresponding to the player */
    public boolean checkXYPlayerRoom(int x, int y) {
        return (playerRoom.getX() == x && playerRoom.getY() == y);
    }

    public String getMapName() {
        return mapName;
    }

    private void createAllPosition(){
        playerRoomIndex = randomValue(0, tabRooms.size()-1);
        do{
            jasonRoomIndex = randomValue(0, tabRooms.size()-1);
        } while (jasonRoomIndex == playerRoomIndex);
        goalRoomIndex = randomValue(0, tabRooms.size()-1);

        playerRoom = tabRooms.get(playerRoomIndex);
        jasonRoom = tabRooms.get(jasonRoomIndex);
        goalRoom = tabRooms.get(goalRoomIndex);

        // Initiate entities positions
        findEntities();

        // Initiate apparition of gen and items
        elements.genSpawn(tabRooms.size()-1);
        elements.itemSpawn(tabRooms.size()-1);
    }

    public String playerRoomDescription() {
        return playerRoom.getShortDescription();
    }

    public String goalRoomDescription() {
        return goalRoom.getShortDescription();
    }

    public String getRoomName() {
        return playerRoom.getShortDescription();
    }

    // ------------------------------ Player part ------------------------------

    public boolean playerIsAlive(){
        return player.isAlive();
    }

    // If direction written have exit, player move in that way
    // Increment by 1 the number of Jason movements
    public boolean playerIsExit(String parameter) {
        if(playerRoom.isExit(parameter)){
            playerRoom = playerRoom.nextRoom(parameter);
            player.setPosition(parameter);
            this.doAction = 1;
            return true;
        }
        return false;
    }

    // If it's possible to use a medKit, use it
    // Increment by 1 the number of Jason movements
    public int playerCareKit() {
        int possibleUseOfCareKite = player.careKit();
        if (possibleUseOfCareKite == 1){
            doAction = 1;
        }
        return possibleUseOfCareKite;
    }

    // If it's possible to use a toolbox, use it
    // Increment by 1 the number of Jason movements
    public boolean playerToolCase() {
        this.doAction = 1;
        return player.toolCase();
    }

    public int getLifePlayer(){
        return player.getLife();
    }

    // Player lose one 1 life
    public void playerLooseLife(){
        player.looseLife();
    }

    // ------------------------------ Item part ------------------------------

    public void removeItemFromRoom(){
        elements.removeItem(numRoom);
    }

    // Verify existing item in the current "playerRoom"
    public String itemHere(){
        numRoom = 0;
        for(int i=0;i< tabRooms.size();i++){
            if(playerRoom == tabRooms.get(i) && elements.itemKeyExist(i)){
                numRoom = i;
                return elements.itemType(numRoom);
            }
        }
        return null;
    }

    public boolean takeItem(){
        if (player.getItem(itemHere())){
            doAction = 1;
            return true;
        }
        return false;
    }

    public String getItemType(){
        return itemHere();
    }

    // ------------------------------ Generator part ------------------------------


    // Repair the gen of the room number "numRoom"
    // Increment by 2 the number of Jason movements
    public void repairGen() {
        elements.repairGen(this.numRoom);
        this.doAction = 2;
    }

    // Verify existing gen in the current "playerRoom"
    public boolean generatorHere(){
        numRoom = 0;
        boolean generatorHere = false;
        for(int i=0;i< tabRooms.size();i++){
            if(playerRoom == tabRooms.get(i) && elements.genKeyExist(i)){
                numRoom = i;
                generatorHere = true;
            }
        }
        return generatorHere;
    }

    public boolean genAlreadyRepair(){
        return elements.genAlreadyRepair(this.numRoom);
    }

    // Return the number of non repair gen
    public int missingGen() {
        return elements.nbrGenTotal()- elements.nbrGenDone();
    }

    public int getGenState(){
        return elements.getGenState(numRoom);
    }

    // ------------------------------ Jason part ------------------------------

    public int jasonVsPlayer(){
        // If action is valid (not useless) then jason move except if his position est the player room
        int nbrOfTest = 0;
        if (doAction > 0){
            for(int mvt = 0; mvt < doAction; mvt++) {
                jasonRoom = jason.moveJason(jasonRoom, playerRoom);
                if (jasonRoom == playerRoom) {
                    nbrOfTest++;
                }
            }
            doAction = 0;
            return nbrOfTest;
        }
        return 0;
    }

    public boolean skillTest() {
        return jason.skillTest();
    }

    public boolean calculationTest() {
        return jason.calculationTest();
    }

    public boolean letterTest() {
        return jason.letterTest();
    }

    // Initiate number a for the skill test
    public int getA() {
        return jason.initializeA();
    }

    // Initiate number b for the skill test
    public int getB() {
        return jason.initializeB();
    }

    // Initiate letter for the skill test
    public char getLetter(){
        return jason.initializeLetter();
    }

    // Update jason and player  position by using "jasonRoom" and "playerRoom" position
    public void findEntities(){
        player.setXYZ(playerRoom.getX(),playerRoom.getY(),playerRoom.getZ());
        jason.setXYZ(jasonRoom.getX(),jasonRoom.getY(),jasonRoom.getZ());
    }

    // ------------------------------ GPS part ------------------------------

    public int distanceBetween(){
        return gps.distanceBetween(player.getX(), player.getY(), jason.getX(), jason.getY(), player.getZ(), jason.getZ());
    }

    public int randomValue(int borneInf, int borneSup){
        return (int)(Math.random() * ((borneSup - borneInf) + 1)) + borneInf;
    }

    // Verify player victory conditions : all gen done and player in "goalRoom"
    public boolean winCondition(){
        return elements.allGenDone() && playerRoom == goalRoom;
    }

    // ------------------------------ Data part ------------------------------

    /* Transmit and attribute variables values from "customPreset" (which itself transmit its values to "defaultPreset")
    to variables present in Jason, Elements and PLayer class */
    public void setAndTransmitValue() {
        transmitValue(replaceCouple(readCouple("defaultPreset.txt"), readCouple("customPreset.txt")));
    }

    public HashMap<String, Integer> readCouple(String path){
        HashMap<String, Integer> file = new HashMap<String, Integer>();
        try {
            Scanner scanner = new Scanner(new File(path));
            while(scanner.hasNextLine())
            {
                String[] couple = scanner.nextLine().split(":");
                try{
                    String test = couple[1];
                    file.put(couple[0], Integer.valueOf(couple[1]));
                }catch (Exception ignored){}
            }
        } catch (Exception ignored) {}
        return file;
    }

    // Replace values (value) in "defaultPreset.text" by values in "customPreset.txt" with same name (key)
    public HashMap<String, Integer> replaceCouple(HashMap<String, Integer> defaultPreset, HashMap<String, Integer> customPreset){
        for(String keyDefault : defaultPreset.keySet()){
            for(String keyCustom : customPreset.keySet()){
                if(keyDefault.equals(keyCustom)){
                    defaultPreset.put(keyDefault, customPreset.get(keyDefault));
                }
            }
        }
        return defaultPreset;
    }

    /* Add values (value) of HashMap "currentSaveData" in values of HashMap "saveData"
    (already saved in the previous game) with the same nam (key) */
    public HashMap<String, Integer> additionCouple(HashMap<String, Integer> saveData, HashMap<String, Integer> currentSaveData){
        for(String keyDefault : currentSaveData.keySet()){
            for(String keyCustom : saveData.keySet()){
                if(keyDefault.equals(keyCustom)){
                    currentSaveData.put(keyDefault, saveData.get(keyDefault) + currentSaveData.get(keyDefault));
                }
            }
        }
        return currentSaveData;
    }

    /* Transmit and attribute variables values from "customPreset" (which itself transmit its values to "defaultPreset")
    to variables present in Jason, Elements and PLayer class */
    public void transmitValue(HashMap<String, Integer> file){
        for (String key : file.keySet()){
            switch (key){
                case "calculTestTimeNormal":
                    if (mapName.equals("l'ÉCOLE EN RUINE DE WHITECHAPEL")){
                        jason.setValueTestTime(file.get(key));
                    }
                    break;
                case "lettreTestTimeNormal":
                    if (mapName.equals("l'ÉCOLE EN RUINE DE WHITECHAPEL")){
                        jason.setLetterTestTime(file.get(key));
                    }
                    break;
                case "calculTestTimeHard":
                    if (mapName.equals("l'HOPITAL HANTÉ DE CHANGI")){
                        jason.setValueTestTime(file.get(key));
                    }
                    break;
                case "lettreTestTimeHard":
                    if (mapName.equals("l'HOPITAL HANTÉ DE CHANGI")){
                        jason.setLetterTestTime(file.get(key));
                    }
                    break;
                case "calculTestMax":
                    jason.setValueTestMax(file.get(key));
                    break;
                case "calculTestMin":
                    jason.setValueTestMin(file.get(key));
                    break;
                case "nbrGenTotal":
                    elements.setNbrGenTotal(file.get(key));
                    break;
                case "nbrItemTotal":
                    elements.setNbrItemTotal(file.get(key));
                    break;
                case "life":
                    player.setLife(file.get(key));
                    break;
            }
        }
    }

    // Save in txt file (firstly created) different player stats
    public void saveStat(int win, int loose, long gameTime){
        String path = "saveData.txt";
        HashMap<String,Integer> saveData = readCouple(path);
        HashMap<String,Integer> currentData = new HashMap<String, Integer>();

        try {
            currentData.put("Nombre total de victoires", win);
            currentData.put("Nombre total de défaites", loose);
            currentData.put("Nombre de secondes en jeu", (int) (gameTime /1000));
            saveData = additionCouple(saveData,currentData);
            saveData.put("Durée de la dernière partie", (int) (gameTime/1000));

            ArrayList<String> lines = new ArrayList<String>();
            lines.add("---- STATISTIQUES DU JOUEUR ----");
            lines.add("");
            for (String key : saveData.keySet()) {
                String line = key+":"+saveData.get(key);
                lines.add(line);
            }
            Files.write(Paths.get(path), lines);
        } catch (Exception ignored) {}
    }
}