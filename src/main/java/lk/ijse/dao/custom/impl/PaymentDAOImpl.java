package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.dao.custom.PaymentDAO;
import lk.ijse.entity.Payment;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(Payment entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Payment entity) {
        return false;
    }

    @Override
    public List<Payment> getAll() {
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
            Query<Integer> query = session.createQuery("SELECT p.paymentId FROM Payment p ORDER BY p.paymentId DESC", Integer.class);
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
    public boolean SavePayment(Payment payment, Session session) {
        session.save(payment);

        return true;
    }

}
