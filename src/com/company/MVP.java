package com.company;

public class MVP {

    public static void main(String[] strings) {

        Game game = new Game();
        Presentation presentation = new Presentation(game);
        Vew vew = new Vew(presentation);

        presentation.associatedVew(vew);
        vew.chooseDifficulty();
    }
}
