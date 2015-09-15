package com.johndcoding.lemonadeshop.view.controler;


import com.johndcoding.lemonadeshop.view.RequestConstants;
import com.johndcoding.lemonadeshop.view.SessionConstants;
import com.johndcoding.lemonadeshop.view.converter.ClientFormConverter;
import com.johndcoding.lemonadeshop.view.converter.CommandeFormConverter;
import com.johndcoding.lemonadeshop.view.converter.ConverterFactory;
import com.johndcoding.lemonadeshop.view.dto.ClientDTO;
import com.johndcoding.lemonadeshop.view.dto.CommandeDTO;
import com.johndcoding.lemonadeshop.view.form.CreationCommandeForm;
import com.johndcoding.lemonadeshop.view.form.SelectItem;
import com.johndcoding.lemonadeshop.view.lang.LangUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class CreationCommande extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getAttribute(RequestConstants.FORM_CREATION_COMMANDE) == null){
            final CreationCommandeForm commandeForm = new CreationCommandeForm();
            initCommandeForm(commandeForm, req);

            req.setAttribute(RequestConstants.FORM_CREATION_COMMANDE, commandeForm);
        }

        req.getRequestDispatcher("jsp/creerCommande.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final CreationCommandeForm commandeForm = new CreationCommandeForm(req);
        req.setAttribute(RequestConstants.FORM_CREATION_COMMANDE, commandeForm);
        req.setAttribute(RequestConstants.FORM_CREATION_CLIENT, commandeForm.getCreationClientForm());


        initCommandeForm(commandeForm, req);

        commandeForm.validate();

        if(commandeForm.hasErrors()){
            req.setAttribute(RequestConstants.ERROR_MSG,  LangUtil.getMessage(req.getLocale(), "error.form"));
            req.getRequestDispatcher("jsp/creerCommande.jsp").forward(req, resp);
        }else{

            final CommandeDTO commande = (CommandeDTO) ConverterFactory.getInstance().getFormConverter(CommandeFormConverter.class.getName()).convertToDTO(commandeForm);

            commande.setDateCreation(new Date());

            //TODO revoir avec les BDD
            final String idCommande = commande.getDateCreation().toString();
            Map<String, CommandeDTO> mapCommandes = (Map<String, CommandeDTO>) req.getSession().getAttribute(SessionConstants.MAP_COMMANDES);
            if (mapCommandes == null) {
                mapCommandes = new HashMap<String, CommandeDTO>();
                req.getSession().setAttribute(SessionConstants.MAP_COMMANDES, mapCommandes);
            }
            if(commandeForm.getCreerNouveauClient() != null && commandeForm.getCreerNouveauClient().equals(Boolean.TRUE)){
                final ClientDTO client = commande.getClient();
                final String idClient = client.getNom();
                Map<String, ClientDTO> mapClients = (Map<String, ClientDTO>) req.getSession().getAttribute(SessionConstants.MAP_CLIENTS);
                if (mapClients == null) {
                    mapClients = new HashMap<String, ClientDTO>();
                    req.getSession().setAttribute(SessionConstants.MAP_CLIENTS, mapClients);
                }
                mapClients.put(idClient, client);
            }
            mapCommandes.put(idCommande, commande);
            req.setAttribute(RequestConstants.CURENT_COMMANDE, commande);
            req.getRequestDispatcher("jsp/afficherCommande.jsp").forward(req, resp);
        }
    }


    /**
     * Initialise les listes du formulaire.
     * @param commandeForm : le formulaire dont les liste sont a initialiser.
     * @param req
     */
    private void initCommandeForm(CreationCommandeForm commandeForm, HttpServletRequest req) {
        final List<SelectItem> listModePaiement = new ArrayList<SelectItem>();
        listModePaiement.add(new SelectItem("CB", "Carte bancare"));
        listModePaiement.add(new SelectItem("CHEQUE", "Cheque"));
        listModePaiement.add(new SelectItem("PAYPAL", "Paypal"));
        commandeForm.setListModePaiementCommande(listModePaiement);


        final List<SelectItem> listModeLivraison = new ArrayList<SelectItem>();
        listModeLivraison.add(new SelectItem("RAPIDE", "rapide"));
        listModeLivraison.add(new SelectItem("NORMAL", "normal"));
        commandeForm.setListModeLivraisonCommande(listModeLivraison);

         commandeForm.setListClientExistant(getListClientsExistants(req));
    }


    private List<SelectItem> getListClientsExistants(HttpServletRequest req) {
        //TODO revoir la recuperation une fois la BDD realisee.
        final List<SelectItem> result = new ArrayList<SelectItem>();
        final Map<String, ClientDTO> mapClients = (Map<String, ClientDTO>) req.getSession().getAttribute(SessionConstants.MAP_CLIENTS);
        if(mapClients != null){
            for(ClientDTO client :mapClients.values()){
                result.add(new SelectItem(client.getNom(), String.format("%s %s", client.getNom(), client.getPrenom())));
            }
        }

        return result;
    }

}
