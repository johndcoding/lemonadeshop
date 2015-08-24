package com.johndcoding.lemonadeshop.view.form;


import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class CreationClientForm extends AbstractForm {


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

        if (StringUtils.isEmpty(nomClient)) {
            addErrorChampObligatoire("nomClient");
        }
        if (StringUtils.isEmpty(prenomClient)) {
            addErrorChampObligatoire("prenomClient");
        }
        if (StringUtils.isEmpty(emailClient)) {
            addErrorChampObligatoire("emailClient");
        }
        if (StringUtils.isEmpty(adresseClient)) {
            addErrorChampObligatoire("adresseClient");
        }

    }

}
