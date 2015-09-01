package com.johndcoding.lemonadeshop.view.form;


import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractForm implements Serializable {


    /**
     * Map des erreurs de validations. La le correspond a l'identifiant du champ et la value a l'erreur
     */
    private Map<String,ValidationError> errors = new HashMap<String, ValidationError>();

    public AbstractForm(HttpServletRequest req) {

    }

    public AbstractForm(){

    }

    protected String getStringParameter(HttpServletRequest req, String attrName) {
        return (String) req.getParameter(attrName);
    }


    public boolean isValidated() {
        return errors.isEmpty();
    }

    public Map<String, ValidationError> getErrors() {
        return errors;
    }

    public void validate() {
        errors = new HashMap<String, ValidationError>();
    }

    public void addError(String champ, String message) {
        errors.put(champ, new ValidationError(champ, message));
    }

    public void addErrorChampObligatoire(String champ) {
        addError(champ, "champ ogligatoire");
    }

    public boolean hasErrors(){ return !errors.isEmpty();}

}
