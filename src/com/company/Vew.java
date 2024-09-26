package com.company;

public class Vew {

    private Presentation presentation;

    private final Analyse analyse;
    private boolean wantsToQuit;
    private final DictionaryParameter dictionaryParameter;
    private final DictionaryCommand dictionaryCommand;
    private String first_word;
    private String second_word;
    private String[] Full_command;
    private long gameTime;

    public Vew(Presentation presentation)
    {
        this.presentation = presentation;
        dictionaryParameter = new DictionaryParameter();
        dictionaryCommand = new DictionaryCommand();
        analyse = new Analyse();
        wantsToQuit = false;
        first_word = "not found";
        second_word = "not found";
        gameTime = System.currentTimeMillis();
    }

    // While difficulty not choose, game doesn't start
    public void chooseDifficulty(){
        boolean validation = false;
        println("Choisissez votre difficulté. (normal ou difficile)");
        while (!validation) {
            print("Entrer une difficulté > ");
            Full_command = analyse.getAndAnalyzeSentence();

            try {
                first_word = Full_command[0];
            } catch (Exception ignored) {}

            int Index_First_Word = dictionaryCommand.find(first_word);
            String command = dictionaryCommand.correspondence(Index_First_Word);

            switch (command) {
                case "normal":
                    presentation.playNormal();
                    validation = true;
                    break;
                case "difficile":
                    presentation.playHard();
                    validation = true;
                    break;
            }
        }
        play();
    }

    // Split player command in 2 word et start associated action
    public void play() {

        wantsToQuit = false;

        printWelcome();

        while (!wantsToQuit && presentation.playerIsAlive() && !presentation.winCondition()) {
            println(" ");
            print("Entrer une action > ");
            Full_command = analyse.getAndAnalyzeSentence();

            try {
                first_word = Full_command[0];
            }catch (Exception ignored){}

            try {
                second_word = Full_command[1];
            }catch (Exception ignored){}

            int Index_First_Word = dictionaryCommand.find(first_word);
            int Index_Second_Word = dictionaryParameter.find(second_word);

            String command = dictionaryCommand.correspondence(Index_First_Word);
            String parameter = dictionaryParameter.correspondence(Index_Second_Word);

            executeCommand(command,parameter);
        }

        if (!wantsToQuit && presentation.playerIsAlive()) { // If we arrived here, player win or loose
            printWin();
        }else{
            printLoose();
        }

        println("");
        print("Appuyer sur entrée pour quitter... ");
        analyse.endPause();
    }

    private void executeCommand(String command , String parameter) {

        switch (command) {
            case "not found": case "normal": case "difficile":
                println("Commande inconnue.");
                break;
            case "quit":
                wantsToQuit = true;
                break;
            case "help":
                printHelp();
                break;
            case "go":
                if (!parameter.equals("not found")) {
                    if (presentation.playerRoomIsExit(parameter)) {
                        printInfo();
                    }
                    else{
                        println("Tu es face à un mur, il n'y a pas d'issue par ici.");
                    }
                }
                else {
                    println("Direction inconnue.");
                }
                break;
            case "reparer":
                if(presentation.generatorHere()){
                    if (presentation.genAlreadyRepair()){
                        presentation.repairGen();
                        println("Le générateur de la salle " + presentation.getRoomName() + " est réparé de : " + presentation.getGenState() + "/2");
                    }
                    else {
                        println("Le générateur de la salle " + presentation.getRoomName() + " est déjà réparé.");
                    }
                }else{
                    println("Il n'y a pas de générateur ici.");
                }
                break;
            case "prendre":
                if (presentation.takeItem()){
                    println("Vous possédez désormais un/une " + presentation.getItemType() + ".");
                    presentation.removeItemFromRoom();
                }
                else {
                    println("Impossible de récuperer l'objet.");
                }
                break;
            case "heal":
                int possibleUseOfCareKite = presentation.playerCareKit();
                if (possibleUseOfCareKite == 1){
                    println("La trousse de soin a été utilisée. Vous avez "+presentation.getLifePlayer()+" vie.");
                }
                else if(possibleUseOfCareKite == -1){
                    println("Vous avez déjà toutes vos vies.");
                }
                else {
                    println("Vous n'avez pas de trousse de soin.");
                }
                break;
            case "outil":
                if (presentation.generatorHere() && presentation.playerToolCase()){
                    if(presentation.genAlreadyRepair()){
                        for (int i=0; i < 2; i++){
                            presentation.repairGen();
                        }
                        println("Le générateur de la salle " + presentation.getRoomName() + " est réparé de : " + presentation.getGenState() + "/2");
                    }
                    else {
                        println("Le générateur de la salle " + presentation.getRoomName() + " est déjà réparé.");
                    }
                }
                else{
                    println("Impossible d'utiliser de caisse à outils.");
                }
                break;
        }

        int eventJason = presentation.jasonVsPlayer();
        if (eventJason > 0) {
            for (int event = 0; event < eventJason; event++) {
                if(presentation.skillTest()){
                    print("Combien font " + presentation.getA() + " * " + presentation.getB() + " : ");
                    if(!presentation.calculationTest()){
                        presentation.playerLooseLife();
                        println("Vous avez pris un coup et vous saignez. Il ne vous reste que "+presentation.getLifePlayer()+" vie.");
                    }else {
                        println("Vous avez assommé le tueur avec une palette.");
                    }
                }
                else{
                    print("Ecrivez " + presentation.getLetter() + " : ");
                    if(!presentation.letterTest()){
                        presentation.playerLooseLife();
                        println("Vous avez pris un coup et vous saignez. Il ne vous reste que "+presentation.getLifePlayer()+" vie.");
                    }else {
                        println("Vous vous êtes caché dans un casier.");
                    }
                }
            }
        }
    }

    private void printWelcome() {
        println("--------------------------------");
        println("Bienvenu à toi dans AHOME !");
        println("--------------------------------");
        println("Tapez 'Help' pour prendre connaissance des objectifs du jeu.");
        println("Survivez afin d'échapper au tueur qui rôde.");
        println("");
        println("Vous vous trouvez à " + presentation.getMapName());
        printInfo();
    }

    private void printWin() {
        println("");
        println("----------------------------------");
        println("Résultat de la partie : Échappé(e)");
        println("----------------------------------");
        println("Vous avez remporté cette partie.");
        println("Vous êtes un véritable survivant.");
        gameTime = System.currentTimeMillis()- gameTime;
        presentation.saveStat(1, 0, gameTime);
    }

    private void printLoose() {
        println("");
        println("-----------------------------------");
        println("Résultat de la partie : Exécuté(e)");
        println("-----------------------------------");
        println("Le tueur a eu raison de vous.");
        println("Vous avez perdu cette partie.");
        gameTime = System.currentTimeMillis()- gameTime;
        presentation.saveStat(0, 1, gameTime);
    }

    private void printHelp() {
        println("Déplacez-vous et explorez les lieux.");
        println("Réparez les générateurs et rétablissez le courant afin de vous échapper.");
        println("");
        print("Commandes et actions possibles : ");
        helpCommand();
        print("Directions possibles : ");
        helpParameter();
        print("Tapez << go >> suivi de la direction.");
    }

    public void helpCommand(){
        for(int i = 3; i < dictionaryCommand.getNumberOfWords(); i += 1) {
            System.out.print(dictionaryCommand.dic.get(i)+", ");
        }
        System.out.println();
    }

    public void helpParameter(){
        for(int i = 1; i < dictionaryParameter.getNumberOfWords(); i += 1) {
            System.out.print(dictionaryParameter.dic.get(i)+", ");
        }
        System.out.println();
    }

    private void printInfo(){
        showMap();
        print("Vous êtes dans " + presentation.playerRoomDescription());
        if(presentation.generatorHere()){
            print(" (générateur)");
        }
        if (presentation.getItemType() != null){
            print(" ("+presentation.getItemType()+")");
        }
        println("");
        println("Sortie : " + presentation.goalRoomDescription() + " accessible dans : " + presentation.missingGen() + " générateurs.");
        println("Le tueur se trouve à " + presentation.distanceBetween() + " mètres.");
    }

    // Show map plan in console
    public void showMap(){
        for (int x = 0; x < presentation.getXMaxRoom()+1; x++){
            for (int y = 0; y < presentation.getYMaxRoom()+1; y++){
                if (checkExistingRoom(x,y)){
                    if (presentation.checkXYPlayerRoom(x,y)){
                        print("[*]");
                    }
                    else{
                        print("[ ]");
                    }
                }
                else {
                    print("   ");
                }
            }
            println("");
        }
    }

    // Verify existing room with position of "showMap"
    public boolean checkExistingRoom(int x, int y){
        for (int index = 0; index < presentation.getTabRoomSize(); index++){
            if (getXRoom(index) == x && getYRoom(index) == y && getZRoom(index) == 0){
                return true;
            }
        }
        return false;
    }

    public int getXRoom(int index){
        return presentation.getXRoom(index);
    }

    public int getYRoom(int index){
        return presentation.getYRoom(index);
    }

    public int getZRoom(int index){
        return presentation.getZRoom(index);
    }

    public void println(String text){
        System.out.println(text);
    }

    public void print(String text){
        System.out.print(text);
    }
}
