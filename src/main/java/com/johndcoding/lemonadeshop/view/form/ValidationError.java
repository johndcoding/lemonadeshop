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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValidationError that = (ValidationError) o;

        if (champ != null ? !champ.equals(that.champ) : that.champ != null) return false;
        return !(message != null ? !message.equals(that.message) : that.message != null);

    }

    @Override
    public int hashCode() {
        int result = champ != null ? champ.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
