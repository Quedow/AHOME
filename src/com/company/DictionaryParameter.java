package com.company;

class DictionaryParameter extends Dictionary {

    public DictionaryParameter() {
        dic.add("not found");
        dic.add("haut");
        dic.add("bas");
        dic.add("droite");
        dic.add("gauche");
        dic.add("up");
        dic.add("down");
        this.numberOfWords = dic.size();
    }
}
