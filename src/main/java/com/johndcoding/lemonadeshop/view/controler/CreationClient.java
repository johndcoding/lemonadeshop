package com.johndcoding.lemonadeshop.view.controler;


import com.johndcoding.lemonadeshop.view.form.CreationClientForm;
import com.johndcoding.lemonadeshop.view.lang.LangUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreationClient extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/creerClient.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final CreationClientForm form = new CreationClientForm(req);
        req.setAttribute("clientForm", form);
        form.validate();

        if (form.hasErrors()) {
            req.setAttribute("msgError", LangUtil.getMessage(req.getLocale(), "error.form"));
            req.getRequestDispatcher("jsp/creerClient.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("jsp/afficherClient.jsp").forward(req, resp);
        }
    }
}
