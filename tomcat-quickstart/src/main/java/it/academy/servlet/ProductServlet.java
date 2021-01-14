package it.academy.servlet;

import it.academy.data.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    DAOFactory daoFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        final String databaseName = config.getServletContext().getInitParameter("database.name");
        try {
            daoFactory = DAOFactory.getInstance(DatabaseName.valueOf(databaseName));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String id = req.getParameter("id");
            final List<ProductSpec> productSpecs;
            ProductSpecDAO productSpecDAO = daoFactory.getProductSpecDao();
            if (id == null) {
                productSpecs = productSpecDAO.readAll();
            } else {
                ProductSpec productSpec =null;
                try {
                    productSpec = productSpecDAO.read(Integer.parseInt(id));
                } catch (NumberFormatException e){
                    e.printStackTrace();
                }
                productSpecs = productSpec != null ? List.of(productSpec) : Collections.emptyList();
            }

            PrintWriter writer = resp.getWriter();

            for (ProductSpec productSpec : productSpecs) {

                System.out.println("id=" + productSpec.getId() + " name=" + productSpec.getProductName() + " details=" + productSpec.getProductDetails());
                writer.println("id=" + productSpec.getId() + " name=" + productSpec.getProductName() + " details=" + productSpec.getProductDetails());
            }
//            while (resultSet.next()){
//
//                 int id = resultSet.getInt(1);
//                 String name = resultSet.getString(2);
//                 float price = resultSet.getFloat(3);
//
//                System.out.println("id="+id+" name="+name+" price="+price);
//                writer.println("id="+id+" name="+name+" price="+price);
//            }

//            resp.setContentType("text/html");
//            PrintWriter writer1 = resp.getWriter();
//            String name = req.getParameter("name");
//            writer1.println("<h2>Id:" + name + "</h2>");

//            if(name_2!=null) {
//                final ResultSet resultSet1 = statement.executeQuery(
//                        "select product_spec.id, product_spec.product_name, product_spec_price.product_spec_price " +
//                                "from product_spec, product_spec_price " +
//                                "where product_spec.id=product_spec_price.product_spec_id AND product_spec.product_name LIKE '%" + name_2 + "%'");
//
//                while (resultSet1.next()) {
//
//                    int id1 = resultSet.getInt(1);
//                    String name1 = resultSet.getString(2);
//                    float price1 = resultSet.getFloat(3);
//
//                    System.out.println("id=" + id1 + " name=" + name1 + " price=" + price1);
//                    writer.println("id=" + id1 + " name=" + name1 + " price=" + price1);
//                }
//                resultSet1.close();
//            }

//            resultSet.close();
//
//            statement.close();
//            connection.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }
}
