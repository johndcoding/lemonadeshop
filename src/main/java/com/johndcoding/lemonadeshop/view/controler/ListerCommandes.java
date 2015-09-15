package com.johndcoding.lemonadeshop.view.controler;


import com.johndcoding.lemonadeshop.view.RequestConstants;
import com.johndcoding.lemonadeshop.view.SessionConstants;
import com.johndcoding.lemonadeshop.view.dto.ClientDTO;
import com.johndcoding.lemonadeshop.view.dto.CommandeDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListerCommandes extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<CommandeDTO> listCommandes = new ArrayList<CommandeDTO>();
        //TODO modifier la recuperation apres la creation de la BDD
        final Map<String, CommandeDTO> mapCommandes = (Map<String, CommandeDTO>) req.getSession().getAttribute(SessionConstants.MAP_COMMANDES);
        if(mapCommandes != null){
            listCommandes.addAll(mapCommandes.values());
        }

        req.setAttribute(RequestConstants.LIST_COMMANDE, listCommandes);

        req.getRequestDispatcher("jsp/listerCommandes.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
