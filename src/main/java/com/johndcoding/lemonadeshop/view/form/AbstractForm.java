package com.johndcoding.lemonadeshop.view.form;


import com.johndcoding.lemonadeshop.view.lang.LangUtil;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class AbstractForm implements Serializable {

    protected Locale currentLocale;

    /**
     * Map des erreurs de validations. La le correspond a l'identifiant du champ et la value a l'erreur
     */
    protected Map<String,ValidationError> errors = new HashMap<String, ValidationError>();

    public AbstractForm(HttpServletRequest req) {
        currentLocale = req.getLocale();
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

    protected Boolean getRadioTrueFalse(HttpServletRequest req, String attrName) {
        Boolean result = null;
        final String str = (String) req.getParameter(attrName);

        if(str != null){
           result= Boolean.parseBoolean(str);
        }

        return result;
    }

    public void validate() {
        errors = new HashMap<String, ValidationError>();
    }

    public void addError(String champ, String message) {
        errors.put(champ, new ValidationError(champ, message));
    }

    public void addErrorChampObligatoire(String champ) {
        addError(champ, LangUtil.getMessage(currentLocale, "error.champ.obligatoire"));
    }

    public boolean hasErrors(){ return !errors.isEmpty();}

}
