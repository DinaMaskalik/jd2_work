package it.academy.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

    private static DAOFactory daoFactory;

    public DAOFactory() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public ProductSpecDAO getProductSpecDao() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/product?serverTimezone=UTC",
                "root",
                "Dina05082001");
    return new ProductSpecDAOImpl(connection);
    }

    public static DAOFactory getInstance(DatabaseName databaseName) throws ClassNotFoundException {
        switch (databaseName){
            case MYSQL:{
                if(daoFactory==null){
                    daoFactory=new DAOFactory();
                }
                return daoFactory;
            }
            case ORACLE:{
                //TODO: Not implemented
                return null;
            }
        }
        throw new IllegalArgumentException("Database name is unknown");
    }
}

