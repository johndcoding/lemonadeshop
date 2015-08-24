package com.johndcoding.lemonadeshop.view.form;


import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractForm implements Serializable {

    private List<ValidationError> errors = new ArrayList<ValidationError>();

    public AbstractForm(HttpServletRequest req) {

    }


    protected String getStringParameter(HttpServletRequest req, String attrName) {
        return (String) req.getParameter(attrName);
    }


    public boolean hasErrors(){
        return !errors.isEmpty();
    }

    public List<ValidationError> getErrors(){
        return errors;
    }

    public void validate(){
        errors = new ArrayList<ValidationError>();
    }

    public void addError(String champ, String message){
        errors.add(new ValidationError(champ, message));
    }

    public void addErrorChampObligatoire(String champ){
        addError(champ, "champ ogligatoire");
    }

}
