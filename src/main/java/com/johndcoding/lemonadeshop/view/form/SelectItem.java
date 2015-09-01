package com.johndcoding.lemonadeshop.view.form;


import java.io.Serializable;

public class SelectItem implements Serializable{

    private String value;
    private String libelle;
    private boolean selected;

    public SelectItem(String value, String libelle) {
        this.value = value;
        this.libelle = libelle;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
