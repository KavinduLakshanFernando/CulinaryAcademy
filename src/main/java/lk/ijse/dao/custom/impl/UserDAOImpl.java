package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class UserDAOImpl implements UserDAO {


    @Override
    public boolean haveAdmin() {
        boolean haveadmin = false;
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        String hql = "from User where role = 'admin'";
        try{
            haveadmin = session.createQuery(hql).list().size()>0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return haveadmin;
    }

    @Override
    public User getdata(String uName) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        User user = null;

        try {
            String hql = "FROM User WHERE u_name = :username";
            user = session.createQuery(hql, User.class)
                    .setParameter("username", uName)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return user;
    }

    @Override
    public boolean save(User user) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String pid) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("delete from Program where p_id = ?1");
        query.setParameter(1, pid);
        query.executeUpdate();

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

}
