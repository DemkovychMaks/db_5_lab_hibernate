package model.dao.implementation;
import Hibernate.HibernateUtil;
import model.dao.GenericDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


@SuppressWarnings({"unchecked"})
public class CountryDAO implements GenericDAO<Country> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            countries = session.createQuery("from Country ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public Country findById(Integer id) throws SQLException {
        Country country = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            country = session.get(Country.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void create(Country entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Country entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Country country = session.get(Country.class, id);
            if (country != null) {
                session.delete(country);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
