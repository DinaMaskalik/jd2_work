package it.academy.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecDAOImpl implements ProductSpecDAO{


    private final Connection connection;

    public ProductSpecDAOImpl(Connection connection) {
        this.connection=connection;
    }

    @Override
    public void create(ProductSpec productSpec) {

    }

    @Override
    public ProductSpec read(int id) {
        return null;
    }

    @Override
    public List<ProductSpec> readAll() {

        List<ProductSpec> productSpecs = new ArrayList<>();
        try(Statement statement= connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product_spec")){
            while (resultSet.next()){
                ProductSpec productSpec= new ProductSpec();
                productSpec.setId(resultSet.getInt("id"));
                productSpec.setProductDate(resultSet.getDate("product_date"));
                productSpec.setProductName(resultSet.getString("product_name"));
                productSpec.setProductDetails(resultSet.getString("product_details"));

                productSpecs.add(productSpec);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return productSpecs;
    }

    @Override
    public void update(ProductSpec productSpec) {

    }

    @Override
    public void delete(ProductSpec productSpec) {

    }
}
