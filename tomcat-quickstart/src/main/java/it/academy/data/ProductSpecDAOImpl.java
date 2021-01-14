package it.academy.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecDAOImpl implements ProductSpecDAO {


    private final Connection connection;

    public ProductSpecDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(ProductSpec productSpec) {
        try(PreparedStatement preparedStatement= connection.prepareStatement(
                "insert into product.product_spec " +
                        "(id, product_name, product_details, product_date)\n" +
                "            values (?, ?, ?, ?)")) {
            preparedStatement.setInt(1, productSpec.getId());
            preparedStatement.setString(2, productSpec.getProductName());
            preparedStatement.setString(3, productSpec.getProductDetails());
            preparedStatement.setDate(4, (Date) productSpec.getProductDate());
            System.out.println("create="+preparedStatement.executeUpdate());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public ProductSpec read(int id) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from product_spec where id=" + id)) {
            resultSet.next();

            ProductSpec productSpec = new ProductSpec();
            productSpec.setId(resultSet.getInt("id"));
            productSpec.setProductDate(resultSet.getDate("product_date"));
            productSpec.setProductName(resultSet.getString("product_name"));
            productSpec.setProductDetails(resultSet.getString("product_details"));
            return productSpec;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProductSpec> readAll() {

        List<ProductSpec> productSpecs = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from product_spec")) {
            while (resultSet.next()) {
                ProductSpec productSpec = new ProductSpec();
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
