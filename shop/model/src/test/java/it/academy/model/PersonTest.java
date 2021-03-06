package it.academy.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.io.Serializable;
import java.sql.Date;

import static org.junit.Assert.*;

@FixMethodOrder
public class PersonTest {

    private SessionFactory sessionFactory;

    @org.junit.Before
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
            Person person = new Person();
            person.setName("Natalia");
            person.setSecondName("Ivanova");
            person.setDateOfBirth(Date.valueOf("1980-01-01"));
            person.setStatus(Status.NEW);
            person.setComments(new String[]{"Comment1", "Comment2"});

            ShopUser shopUser= new ShopUser();
            shopUser.setUserName("n_ivanova");
            shopUser.setPassword("secret");

            person.setShopUser(shopUser);

            //When
            Session session = sessionFactory.openSession();
            Transaction tx = null;
            Serializable id = null;
            try {
                tx = session.beginTransaction();
                //do some work
                id = session.save(person);
                session.save(shopUser);

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

    @Test
    public void delete() {
        //given
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, "4028abed773a6d4601773a6d48d30000");

        //When
        Transaction tx = null;
        Serializable id = null;
        try {
            tx = session.beginTransaction();
            //do some work
            session.delete(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        //Then
        assertNull(session.get(Person.class, "4028abed773a6d4601773a6d48d30000"));

        session.close();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        sessionFactory.close();
    }
}