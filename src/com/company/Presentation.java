package com.company;

public class Presentation {

    private Game game;
    private Vew vew;

    public Presentation(Game game) {
        this.game = game;
    }

    public void associatedVew(Vew vew){
        this.vew = vew;
    }

    public void playNormal(){
        game.createRoomsNormal();
    }

    public void playHard(){
        game.createRoomsHard();
    }

    // ------------------------------ Generator part ------------------------------

    public boolean generatorHere(){
        return game.generatorHere();
    }

    public boolean genAlreadyRepair(){
        return !game.genAlreadyRepair();
    }

    public void repairGen() { game.repairGen(); }

    public int getGenState(){
        return game.getGenState();
    }

    public int missingGen() {
        return game.missingGen();
    }

    // ------------------------------ Item part ------------------------------

    public boolean takeItem(){
        return game.takeItem();
    }

    public String getItemType() {
        return game.getItemType();
    }

    public void removeItemFromRoom(){
        game.removeItemFromRoom();
    }

    // ------------------------------ Player part ------------------------------

    public boolean playerIsAlive(){
        return game.playerIsAlive();
    }

    public boolean winCondition(){
        return game.winCondition();
    }

    public boolean playerRoomIsExit(String parameter){
        return game.playerIsExit(parameter);
    }

    public int playerCareKit(){
        return game.playerCareKit();
    }

    public String playerRoomDescription() {
        return game.playerRoomDescription();
    }

    public int getLifePlayer(){
        return game.getLifePlayer();
    }

    public boolean playerToolCase(){
        return game.playerToolCase();
    }

    public void playerLooseLife(){
        game.playerLooseLife();
    }

    // ------------------------------ Jason part ------------------------------

    public int jasonVsPlayer(){
        return game.jasonVsPlayer();
    }

    public boolean skillTest() {
        return game.skillTest();
    }

    public boolean calculationTest() {
        return game.calculationTest();
    }

    public boolean letterTest() {
        return game.letterTest();
    }

    public int getA() {
        return game.getA();
    }

    public int getB() {
        return game.getB();
    }

    public char getLetter(){
        return game.getLetter();
    }

    // ------------------------------ GPS part ------------------------------

    public int distanceBetween(){
        return game.distanceBetween();
    }

    // ------------------------------ Room part ------------------------------

    public String goalRoomDescription() {
        return game.goalRoomDescription();
    }

    public String getRoomName() {
        return game.getRoomName();
    }

    public String getMapName(){
        return game.getMapName();
    }

    public int getXRoom(int index) {
        return game.getXRoom(index);
    }

    public int getYRoom(int index) {
        return game.getYRoom(index);
    }

    public int getTabRoomSize(){
        return game.getTabRoomSize();
    }

    public int getXMaxRoom(){
        return game.getXMaxRoom();
    }

    public int getYMaxRoom(){
        return game.getYMaxRoom();
    }

    public int getZRoom(int index) {
        return game.getZRoom(index);
    }

    public boolean checkXYPlayerRoom(int x, int y) {
        return game.checkXYPlayerRoom(x,y);
    }

    // ------------------------------ Data part ------------------------------

    public void saveStat(int nbrWin, int nbrLoose, long gameTime) {
        game.saveStat(nbrWin, nbrLoose, gameTime);
    }
}
