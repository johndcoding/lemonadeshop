package com.johndcoding.lemonadeshop.view.controler;

import com.johndcoding.lemonadeshop.view.RequestConstants;
import com.johndcoding.lemonadeshop.view.SessionConstants;
import com.johndcoding.lemonadeshop.view.dto.ClientDTO;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListerClients extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final List<ClientDTO> listClient = new ArrayList<ClientDTO>();
        //TODO modifier la recuperation apres la creation de la BDD
        final Map<String, ClientDTO> mapClients = (Map<String, ClientDTO>) req.getSession().getAttribute(SessionConstants.MAP_CLIENTS);
        if(mapClients != null){
            listClient.addAll(mapClients.values());
        }

        req.setAttribute(RequestConstants.LIST_CLIENT, listClient);
        req.getRequestDispatcher("jsp/listerClients.jsp").forward(req,resp);
    }
}
