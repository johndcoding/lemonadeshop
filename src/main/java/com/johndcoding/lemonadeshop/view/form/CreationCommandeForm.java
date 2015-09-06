package com.johndcoding.lemonadeshop.view.form;

import com.johndcoding.lemonadeshop.core.util.CheckFormatUtil;
import com.johndcoding.lemonadeshop.view.lang.LangUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CreationCommandeForm extends AbstractForm {

    private static final int STATUT_LIVRAISON_MIN_LENGTH = 2;
    private static final int STATUT_PAIEMENT_MIN_LENGTH = 2;
    private List<SelectItem> listModeLivraisonCommande = new ArrayList<SelectItem>();
    private List<SelectItem> listModePaiementCommande = new ArrayList<SelectItem>();

    private String dateCommande;
    private String montantCommande;
    private String modePaiementCommande;
    private String statutPaiementCommande;
    private String modeLivraisonCommande;
    private String statutLivraisonCommande;



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

    public CreationCommandeForm() {
        super();
    }

    public CreationCommandeForm(HttpServletRequest req) {
        super(req);
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

        if(modeLivraisonCommande != null) {
            for (SelectItem modeLivraison : listModeLivraisonCommande) {
                modeLivraison.setSelected(modeLivraisonCommande.equals(modeLivraison.getValue()));
            }
        }

        if(modePaiementCommande != null){
            for(SelectItem modePaiement: listModePaiementCommande){
                modePaiement.setSelected(modePaiementCommande.equals(modePaiement.getValue()));
            }
        }

        validateMontantCommande();
        validateModePaiement();
        validateModeLivraison();

        validateStatutPaiementCommande();
        validateStatutLivraisonCommande();

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
        if (StringUtils.isEmpty(modeLivraisonCommande)) {
            addErrorChampObligatoire("modeLivraisonCommande");
        }
    }

    private void validateModePaiement() {
        if (StringUtils.isEmpty(modePaiementCommande)) {
            addErrorChampObligatoire("modePaiementCommande");
        }
    }

    private void validateMontantCommande() {
        if (StringUtils.isEmpty(montantCommande)) {
            addErrorChampObligatoire("montantCommande");
        }else if(!CheckFormatUtil.isDecimalNumber(modeLivraisonCommande)){
            addError("montantCommande", LangUtil.getMessage(currentLocale, "error.format.nombre.decimal"));
        }
    }

}
