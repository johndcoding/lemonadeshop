package com.johndcoding.lemonadeshop.view.controler;


import com.johndcoding.lemonadeshop.view.form.CreationClientForm;
import com.johndcoding.lemonadeshop.view.form.CreationCommandeForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreationCommande extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/creerCommande.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final CreationCommandeForm form = new CreationCommandeForm(req);
        form.validate();
        req.setAttribute("commandeForm", form);
        req.getRequestDispatcher("jsp/afficherCommande.jsp").forward(req, resp);
    }

}
