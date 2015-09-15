package com.johndcoding.lemonadeshop.view.controler;


import com.johndcoding.lemonadeshop.view.RequestConstants;
import com.johndcoding.lemonadeshop.view.SessionConstants;
import com.johndcoding.lemonadeshop.view.dto.ClientDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class SupprimerClient extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //TODO revoir la gestion de l'ID
        final String idClient = (String) req.getParameter(RequestConstants.ID_CLIENT_TO_DELETE);

        //TODO revoir la suppression une fois la BDD geree
        final Map<String, ClientDTO> mapClients= (Map<String, ClientDTO>) req.getSession().getAttribute(SessionConstants.MAP_CLIENTS);
        mapClients.remove(idClient);

        resp.sendRedirect("/listerClients");
    }
}
