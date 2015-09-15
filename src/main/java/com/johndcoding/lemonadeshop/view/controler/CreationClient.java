package com.johndcoding.lemonadeshop.view.controler;


import com.johndcoding.lemonadeshop.view.RequestConstants;
import com.johndcoding.lemonadeshop.view.SessionConstants;
import com.johndcoding.lemonadeshop.view.converter.ClientFormConverter;
import com.johndcoding.lemonadeshop.view.converter.ConverterFactory;
import com.johndcoding.lemonadeshop.view.dto.ClientDTO;
import com.johndcoding.lemonadeshop.view.form.CreationClientForm;
import com.johndcoding.lemonadeshop.view.lang.LangUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreationClient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/creerClient.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final CreationClientForm form = new CreationClientForm(req);
        req.setAttribute(RequestConstants.FORM_CREATION_CLIENT, form);
        form.validate();

        if (form.hasErrors()) {
            req.setAttribute("msgError", LangUtil.getMessage(req.getLocale(), "error.form"));
            req.getRequestDispatcher("jsp/creerClient.jsp").forward(req, resp);
        } else {
            final ClientDTO client = (ClientDTO) ConverterFactory.getInstance().getFormConverter(ClientFormConverter.class.getName()).convertToDTO(form);

            //TODO revoir avec les BDD
            final String idClient = client.getNom();
            Map<String, ClientDTO> mapClients = (Map<String, ClientDTO>) req.getSession().getAttribute(SessionConstants.MAP_CLIENTS);
            if (mapClients == null) {
                mapClients = new HashMap<String, ClientDTO>();
                req.getSession().setAttribute(SessionConstants.MAP_CLIENTS, mapClients);
            }
            mapClients.put(idClient, client);

            req.setAttribute(RequestConstants.CURRENT_CLIENT, client);

            req.getRequestDispatcher("jsp/afficherClient.jsp").forward(req, resp);
        }
    }
}
