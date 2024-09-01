package com.example.dictionary_app.Models;
import java.util.List;

public class APIResponse
{
    String word = "";
    List<phonetics> phonetics = null;
    List<meanings> meanings = null;


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<com.example.dictionary_app.Models.phonetics> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<com.example.dictionary_app.Models.phonetics> phonetics) {
        this.phonetics = phonetics;
    }

    public List<com.example.dictionary_app.Models.meanings> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<com.example.dictionary_app.Models.meanings> meanings) {
        this.meanings = meanings;
    }
}
