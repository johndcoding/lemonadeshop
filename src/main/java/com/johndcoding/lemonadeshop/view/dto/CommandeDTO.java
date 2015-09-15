package com.johndcoding.lemonadeshop.view.dto;

import com.johndcoding.lemonadeshop.entity.Client;
import com.johndcoding.lemonadeshop.entity.ModeLivraisonEnum;
import com.johndcoding.lemonadeshop.entity.ModePaiementEnum;

import java.io.Serializable;
import java.util.Date;

public class CommandeDTO implements Serializable {

    private ClientDTO client;

    private Double montant;

    private ModePaiementEnum modePaiement;

    private String statutPaiement;

    private ModeLivraisonEnum modeLivraison;

    private String statutLivraison;

    private Date dateCreation;

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }


    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(String statut) {
        this.statutPaiement = statut;
    }

    public String getStatutLivraison() {
        return statutLivraison;
    }

    public void setStatutLivraison(String statutLivraison) {
        this.statutLivraison = statutLivraison;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public ModePaiementEnum getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(ModePaiementEnum modePaiement) {
        this.modePaiement = modePaiement;
    }

    public ModeLivraisonEnum getModeLivraison() {
        return modeLivraison;
    }

    public void setModeLivraison(ModeLivraisonEnum modeLivraison) {
        this.modeLivraison = modeLivraison;
    }
}
