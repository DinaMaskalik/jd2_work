package it.academy.servlet;

import it.academy.data.ProductSpec;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "languageServlet", urlPatterns = "/languages")
public class LanguageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("attr1", "value_atr1");
        req.setAttribute("attr2", new ProductSpec());
        req.getServletContext().setAttribute("attr3", "value_atr3");

        List languages = List.of("RU", "BY", "EN");
        req.setAttribute("languages", languages);
        req.getRequestDispatcher("/jsp/language.jsp").forward(req,resp);
    }
}
