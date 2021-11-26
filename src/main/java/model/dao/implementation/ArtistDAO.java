package model.dao.implementation;

import model.dao.GenericDAO;
import Hibernate.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Artist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


@SuppressWarnings({"unchecked"})
public class ArtistDAO implements GenericDAO<Artist> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Artist> findAll() throws SQLException {
        List<Artist> artists = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            artists = session.createQuery("from Artist").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artists;
    }

    @Override
    public Artist findById(Integer id) throws SQLException {
        Artist artist = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            artist = session.get(Artist.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artist;
    }

    @Override
    public void create(Artist entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Artist entity) throws SQLException {
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
            Artist artist = session.get(Artist.class, id);
            if (artist != null) {
                session.delete(artist);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
