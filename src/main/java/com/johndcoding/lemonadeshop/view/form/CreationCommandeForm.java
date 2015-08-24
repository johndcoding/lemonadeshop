package com.johndcoding.lemonadeshop.view.form;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class CreationCommandeForm extends AbstractForm {

    private String nomClient;
    private String prenomClient;
    private String telephoneClient;
    private String adresseClient;
    private String emailClient;

    private String dateCommande;
    private String montantCommande;
    private String modePaiementCommande;
    private String statutPaiementCommande;
    private String modeLivraisonCommande;
    private String statutLivraisonCommande;


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

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(String montantCommande) {
        this.montantCommande = montantCommande;
    }

    public String getModePaiementCommande() {
        return modePaiementCommande;
    }

    public void setModePaiementCommande(String modePaiementCommande) {
        this.modePaiementCommande = modePaiementCommande;
    }

    public String getStatutPaiementCommande() {
        return statutPaiementCommande;
    }

    public void setStatutPaiementCommande(String statutPaiementCommande) {
        this.statutPaiementCommande = statutPaiementCommande;
    }

    public String getModeLivraisonCommande() {
        return modeLivraisonCommande;
    }

    public void setModeLivraisonCommande(String modeLivraisonCommande) {
        this.modeLivraisonCommande = modeLivraisonCommande;
    }

    public String getStatutLivraisonCommande() {
        return statutLivraisonCommande;
    }

    public void setStatutLivraisonCommande(String statutLivraisonCommande) {
        this.statutLivraisonCommande = statutLivraisonCommande;
    }

    public CreationCommandeForm(HttpServletRequest req) {
        super(req);

        nomClient = getStringParameter(req, "nomClient");
        prenomClient = getStringParameter(req, "prenomClient");
        telephoneClient = getStringParameter(req, "telephoneClient");
        adresseClient = getStringParameter(req, "adresseClient");
        emailClient = getStringParameter(req, "emailClient");


        dateCommande = getStringParameter(req, "dateCommande");
        montantCommande = getStringParameter(req, "montantCommande");
        modePaiementCommande = getStringParameter(req, "modePaiementCommande");
        statutPaiementCommande = getStringParameter(req, "statutPaiementCommande");
        modeLivraisonCommande = getStringParameter(req, "modeLivraisonCommande");
        statutLivraisonCommande = getStringParameter(req, "statutLivraisonCommande");
    }

    @Override
    public void validate() {
        super.validate();

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


        if (StringUtils.isEmpty(montantCommande)) {
            addErrorChampObligatoire("montantCommande");
        }
        if (StringUtils.isEmpty(modePaiementCommande)) {
            addErrorChampObligatoire("modePaiementCommande");
        }
        if (StringUtils.isEmpty(modeLivraisonCommande)) {
            addErrorChampObligatoire("modeLivraisonCommande");
        }

    }
}
