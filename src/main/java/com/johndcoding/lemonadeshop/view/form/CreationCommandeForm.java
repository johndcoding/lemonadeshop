package com.johndcoding.lemonadeshop.view.form;

import com.johndcoding.lemonadeshop.core.util.CheckFormatUtil;
import com.johndcoding.lemonadeshop.entity.ModeLivraisonEnum;
import com.johndcoding.lemonadeshop.entity.ModePaiementEnum;
import com.johndcoding.lemonadeshop.view.lang.LangUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CreationCommandeForm extends AbstractForm {

    private static final int STATUT_LIVRAISON_MIN_LENGTH = 2;
    private static final int STATUT_PAIEMENT_MIN_LENGTH = 2;
    private List<SelectItem> listModeLivraisonCommande = new ArrayList<SelectItem>();
    private List<SelectItem> listModePaiementCommande = new ArrayList<SelectItem>();
    private List<SelectItem> listClientExistant = new ArrayList<SelectItem>();


    private String dateCommande;
    private String montantCommande;
    private ModePaiementEnum modePaiementCommande;
    private String statutPaiementCommande;
    private ModeLivraisonEnum modeLivraisonCommande;
    private String statutLivraisonCommande;

    private Boolean creerNouveauClient;
    private String idClientSelected;//TODO changer le type d'identifiant du client selectionne une fois la BDD traitee.
    private CreationClientForm creationClientForm;


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

    public ModePaiementEnum getModePaiementCommande() {
        return modePaiementCommande;
    }

    public void setModePaiementCommande(ModePaiementEnum modePaiementCommande) {
        this.modePaiementCommande = modePaiementCommande;
    }

    public String getStatutPaiementCommande() {
        return statutPaiementCommande;
    }

    public void setStatutPaiementCommande(String statutPaiementCommande) {
        this.statutPaiementCommande = statutPaiementCommande;
    }

    public ModeLivraisonEnum getModeLivraisonCommande() {
        return modeLivraisonCommande;
    }

    public void setModeLivraisonCommande(ModeLivraisonEnum modeLivraisonCommande) {
        this.modeLivraisonCommande = modeLivraisonCommande;
    }

    public String getStatutLivraisonCommande() {
        return statutLivraisonCommande;
    }

    public void setStatutLivraisonCommande(String statutLivraisonCommande) {
        this.statutLivraisonCommande = statutLivraisonCommande;
    }

    public List<SelectItem> getListModeLivraisonCommande() {
        return listModeLivraisonCommande;
    }

    public void setListModeLivraisonCommande(List<SelectItem> listModeLivraisonCommande) {
        this.listModeLivraisonCommande = listModeLivraisonCommande;
    }

    public void setListModePaiementCommande(List<SelectItem> listModePaiementCommande) {
        this.listModePaiementCommande = listModePaiementCommande;
    }

    public List<SelectItem> getListModePaiementCommande() {
        return listModePaiementCommande;
    }

    public Boolean getCreerNouveauClient() {
        return creerNouveauClient;
    }

    public void setCreerNouveauClient(Boolean creerNouveauClient) {
        this.creerNouveauClient = creerNouveauClient;
    }

    public String getIdClientSelected() {
        return idClientSelected;
    }

    public void setIdClientSelected(String idClientSelected) {
        this.idClientSelected = idClientSelected;
    }

    public List<SelectItem> getListClientExistant() {
        return listClientExistant;
    }

    public void setListClientExistant(List<SelectItem> listClientExistant) {
        this.listClientExistant = listClientExistant;
    }

    public CreationClientForm getCreationClientForm() {
        return creationClientForm;
    }

    public void setCreationClientForm(CreationClientForm creationClientForm) {
        this.creationClientForm = creationClientForm;
    }

    public CreationCommandeForm() {
        super();
    }

    public CreationCommandeForm(HttpServletRequest req) {
        super(req);
        dateCommande = getStringParameter(req, "dateCommande");
        montantCommande = getStringParameter(req, "montantCommande");
        final String strModePaiement = getStringParameter(req, "modePaiementCommande");
        if(!StringUtils.isEmpty(strModePaiement)){
            modePaiementCommande = ModePaiementEnum.valueOf(strModePaiement);
        }
        statutPaiementCommande = getStringParameter(req, "statutPaiementCommande");
        final String strModeLivraison = getStringParameter(req, "modeLivraisonCommande");
        if(!StringUtils.isEmpty(strModeLivraison)){
            modeLivraisonCommande = ModeLivraisonEnum.valueOf(strModeLivraison);
        }
        statutLivraisonCommande = getStringParameter(req, "statutLivraisonCommande");
        idClientSelected = getStringParameter(req, "clientExistant");
        creerNouveauClient = getRadioTrueFalse(req, "creerNouveauClient");

        creationClientForm = new CreationClientForm(req);
    }

    @Override
    public void validate() {
        super.validate();

        if (modeLivraisonCommande != null) {
            for (SelectItem modeLivraison : listModeLivraisonCommande) {
                modeLivraison.setSelected(modeLivraisonCommande.equals(modeLivraison.getValue()));
            }
        }

        if (modePaiementCommande != null) {
            for (SelectItem modePaiement : listModePaiementCommande) {
                modePaiement.setSelected(modePaiementCommande.equals(modePaiement.getValue()));
            }
        }

        if(idClientSelected != null){
            for(SelectItem client : listClientExistant){
                client.setSelected(idClientSelected.equals(client.getValue()));
            }
        }

        validateMontantCommande();
        validateModePaiement();
        validateModeLivraison();

        validateStatutPaiementCommande();
        validateStatutLivraisonCommande();

        creationClientForm.validate();

        validateClient();
    }

    private void validateStatutLivraisonCommande() {
        if (!StringUtils.isEmpty(statutLivraisonCommande) && statutLivraisonCommande.length() < STATUT_LIVRAISON_MIN_LENGTH) {
            addError("statutLivraisonCommande", LangUtil.getMessage(currentLocale, "error.longueur.min", STATUT_LIVRAISON_MIN_LENGTH));
        }
    }

    private void validateStatutPaiementCommande() {
        if (!StringUtils.isEmpty(statutPaiementCommande) && statutPaiementCommande.length() < STATUT_PAIEMENT_MIN_LENGTH) {
            addError("statutPaiementCommande", LangUtil.getMessage(currentLocale, "error.longueur.min", STATUT_PAIEMENT_MIN_LENGTH));
        }
    }

    private void validateModeLivraison() {
        if (modeLivraisonCommande== null) {
            addErrorChampObligatoire("modeLivraisonCommande");
        }
    }

    private void validateModePaiement() {
        if (modePaiementCommande == null) {
            addErrorChampObligatoire("modePaiementCommande");
        }
    }

    private void validateMontantCommande() {
        if (StringUtils.isEmpty(montantCommande)) {
            addErrorChampObligatoire("montantCommande");
        } else if (!CheckFormatUtil.isDecimalNumber(montantCommande)) {
            addError("montantCommande", LangUtil.getMessage(currentLocale, "error.format.nombre.decimal"));
        }
    }

    private void validateClient(){
        if(StringUtils.isEmpty(idClientSelected) && creerNouveauClient == false){
            addError("creerNouveauClient", LangUtil.getMessage(currentLocale, "error.creation.commande.client.obligatoire"));
        }else if(creerNouveauClient == true && creationClientForm.hasErrors()){
            addError("creerNouveauClient", LangUtil.getMessage(currentLocale, "error.creation.commande.client.invalide"));
        }
    }
}
