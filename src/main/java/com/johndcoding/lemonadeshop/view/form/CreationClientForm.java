package com.johndcoding.lemonadeshop.view.form;


import com.johndcoding.lemonadeshop.core.util.CheckFormatUtil;
import com.johndcoding.lemonadeshop.view.lang.LangUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.regex.Pattern;

public class CreationClientForm extends AbstractForm {


    private static final int NOM_MIN_LENGHT = 2;
    private static final int PRENOM_MIN_LENGHT = 2;
    private static final int TELEPHONE_MIN_LENGHT = 4;
    private static final int ADRESSE_MIN_LENGHT = 10;

    private String nomClient;
    private String prenomClient;
    private String telephoneClient;
    private String adresseClient;
    private String emailClient;

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getTelephoneClient() {
        return telephoneClient;
    }

    public void setTelephoneClient(String telephoneClient) {
        this.telephoneClient = telephoneClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }


    public CreationClientForm(HttpServletRequest req) {
        super(req);


        nomClient = getStringParameter(req, "nomClient");
        prenomClient = getStringParameter(req, "prenomClient");
        telephoneClient = getStringParameter(req, "telephoneClient");
        adresseClient = getStringParameter(req, "adresseClient");
        emailClient = getStringParameter(req, "emailClient");
    }


    public void validate() {
        validateNomClient();
        validatePrenomClient();
        validateTelephoneClient();
        validateAdresseClient();
        validateEmailClient();
    }

    private void validateEmailClient() {
        if (StringUtils.isEmpty(emailClient)) {
            addErrorChampObligatoire("emailClient");
        }else if(!CheckFormatUtil.isEmail(emailClient)){
            addError("emailClient", LangUtil.getMessage(currentLocale, "error.format.email"));
        }
    }

    private void validateAdresseClient() {
        if (StringUtils.isEmpty(adresseClient)) {
            addErrorChampObligatoire("adresseClient");
        }else if(adresseClient.length() < ADRESSE_MIN_LENGHT){
            addError("adresseClient", LangUtil.getMessage(currentLocale, "error.longueur.min", ADRESSE_MIN_LENGHT));
        }
    }

    private void validateTelephoneClient() {
        if (StringUtils.isEmpty(telephoneClient)) {
            addErrorChampObligatoire("telephoneClient");
        }else if(telephoneClient.length() < TELEPHONE_MIN_LENGHT){
            addError("telephoneClient", LangUtil.getMessage(currentLocale, "error.longueur.min", TELEPHONE_MIN_LENGHT));
        }else if(!StringUtils.isNumeric(telephoneClient)){
            addError("telephoneClient", LangUtil.getMessage(currentLocale, "error.format.nombre.entier"));
        }
    }

    private void validatePrenomClient() {
        if (StringUtils.isEmpty(prenomClient)) {
            addErrorChampObligatoire("prenomClient");
        }else if(prenomClient.length() < PRENOM_MIN_LENGHT){
            addError("prenomClient",  LangUtil.getMessage(currentLocale, "error.longueur.min", PRENOM_MIN_LENGHT));
        }
    }

    private void validateNomClient() {
        if (StringUtils.isEmpty(nomClient)) {
            addErrorChampObligatoire("nomClient");
        }else if(nomClient.length() < NOM_MIN_LENGHT){
            addError("nomClient",  LangUtil.getMessage(currentLocale, "error.longueur.min", NOM_MIN_LENGHT));
        }
    }

}
