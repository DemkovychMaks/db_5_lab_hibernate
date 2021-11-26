package model.dao.implementation;


import model.dao.GenericDAO;
import Hibernate.HibernateUtil;

import model.entity.Playlist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"unchecked"})
public class PlaylistDAO implements GenericDAO<Playlist> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Playlist> findAll() throws SQLException {
        List<Playlist> playlists = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            playlists = session.createQuery("from Playlist ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playlists;
    }

    @Override
    public Playlist findById(Integer id) throws SQLException {
        Playlist playlist = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            playlist = session.get(Playlist.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playlist;
    }

    @Override
    public void create(Playlist entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Playlist entity) throws SQLException {
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
            Playlist playlist = session.get(Playlist.class, id);
            if (playlist != null) {
                session.delete(playlist);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}