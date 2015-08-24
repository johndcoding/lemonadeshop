package com.johndcoding.lemonadeshop.view.form;

public class ValidationError {
    private String champ;
    private String message;

    public ValidationError(String champ, String message) {
        this.champ = champ;
        this.message = message;
    }

    public String getChamp() {
        return champ;
    }

    public void setChamp(String champ) {
        this.champ = champ;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return champ + " : " + message;
    }
}
