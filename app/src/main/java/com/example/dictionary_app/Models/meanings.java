package com.example.dictionary_app.Models;
import java.util.List;

public class meanings
{
    public String partOfSpeech="";
    public List<definitions> definitions = null;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<com.example.dictionary_app.Models.definitions> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<com.example.dictionary_app.Models.definitions> definitions) {
        this.definitions = definitions;
    }
}
