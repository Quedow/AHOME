package com.company;

class DictionaryCommand extends Dictionary {

    public DictionaryCommand() {
        dic.add("not found");
        dic.add("normal");
        dic.add("difficile");
        dic.add("quit");
        dic.add("help");
        dic.add("go");
        dic.add("reparer");
        dic.add("prendre");
        dic.add("heal");
        dic.add("outil");
        this.numberOfWords = dic.size();
    }
}
