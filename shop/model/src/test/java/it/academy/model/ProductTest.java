package it.academy.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductTest {

    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.test.xml")
                        .build();

        sessionFactory =
                new MetadataSources(registry)
                        .buildMetadata()
                        .buildSessionFactory();
    }

    @Test
    public void create() {
        //Given
        Product product = new Product();
        product.setProductName("Apple IPhone");
        product.setDescription("iPhone 12 512GB");

        ProductPrice productPrice1 = new ProductPrice();
        productPrice1.setProduct(product);
        productPrice1.setPriceValue(BigDecimal.valueOf(5990.99));
        productPrice1.setCurrency(Currency.BYN);

        ProductPrice productPrice2 = new ProductPrice();
        productPrice2.setProduct(product);
        productPrice2.setPriceValue(BigDecimal.valueOf(2200.22));
        productPrice2.setCurrency(Currency.EUR);

        List<ProductPrice> prices = new ArrayList<>();
        prices.add(productPrice1);
        prices.add(productPrice2);
        product.setProductPrice(prices);

        //When
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Serializable id = null;
        try {
            tx = session.beginTransaction();
            //do some work
            id = session.save(product);
            session.save(productPrice1);
            session.save(productPrice2);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        //Then
        assertNotNull(id);
    }

    @After
    public void tearDown() throws Exception {
        sessionFactory.close();
    }
}