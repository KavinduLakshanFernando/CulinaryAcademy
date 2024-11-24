package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.dao.custom.RegistretionDAO;
import lk.ijse.entity.Registration;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class RegistretionDAOImpl implements RegistretionDAO {

    @Override
    public boolean save(Registration entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Registration entity) {
        return false;
    }

    @Override
    public List<Registration> getAll() {
        return null;
    }

    @Override
    public Student search(String id) {
        return null;
    }

    @Override
    public String generateNewId() {
        Session session = SessionFactoryConfiguration.getInstance().getSession();

        try {
            Query<Integer> query = session.createQuery("SELECT r.regId FROM Registration r ORDER BY r.regId DESC", Integer.class);
            query.setMaxResults(1);

            Integer lastId = query.uniqueResult();

            if (lastId == null) {
                return String.valueOf(1);
            } else {
                return String.valueOf(lastId + 1);
            }
        } finally {
            session.close();
        }
    }

    @Override
    public boolean saveRegistration(Registration registration, Session session) {
        session.save(registration);

        return true;
    }
}
