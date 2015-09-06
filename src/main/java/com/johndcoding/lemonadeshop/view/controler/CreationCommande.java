package com.johndcoding.lemonadeshop.view.controler;


import com.johndcoding.lemonadeshop.view.form.CreationClientForm;
import com.johndcoding.lemonadeshop.view.form.CreationCommandeForm;
import com.johndcoding.lemonadeshop.view.form.SelectItem;
import com.johndcoding.lemonadeshop.view.lang.LangUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreationCommande extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getAttribute("commandeForm") == null){
            final CreationCommandeForm commandeForm = new CreationCommandeForm();
            initCommandeForm(commandeForm);
            req.setAttribute("commandeForm", commandeForm);
        }

        req.getRequestDispatcher("jsp/creerCommande.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final CreationClientForm clientForm = new CreationClientForm(req);
        final CreationCommandeForm commandeForm = new CreationCommandeForm(req);
        req.setAttribute("clientForm", clientForm);
        req.setAttribute("commandeForm", commandeForm);


        initCommandeForm(commandeForm);
        clientForm.validate();
        commandeForm.validate();

        if(clientForm.hasErrors() || commandeForm.hasErrors()){
            req.setAttribute("msgError",  LangUtil.getMessage(req.getLocale(), "error.form"));
            req.getRequestDispatcher("jsp/creerCommande.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("jsp/afficherCommande.jsp").forward(req, resp);
        }


    }


    /**
     * Initialise les listes du formulaire.
     * @param commandeForm: le formulaire dont les liste sont a initialiser.
     */
    private void initCommandeForm(CreationCommandeForm commandeForm) {
        final List<SelectItem> listModePaiement = new ArrayList<SelectItem>();
        listModePaiement.add(new SelectItem("CB", "Carte bancare"));
        listModePaiement.add(new SelectItem("CHEQUE", "Cheque"));
        listModePaiement.add(new SelectItem("PAYPAL", "Paypal"));
        commandeForm.setListModePaiementCommande(listModePaiement);


        final List<SelectItem> listModeLivraison = new ArrayList<SelectItem>();
        listModeLivraison.add(new SelectItem("RAPIDE", "rapide"));
        listModeLivraison.add(new SelectItem("NORMAL", "normal"));
        commandeForm.setListModeLivraisonCommande(listModeLivraison);
    }


}
