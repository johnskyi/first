import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "SELECT s.id as student_id, c.id as course_id, s.name as student_name, c.name as course_name" +
                " FROM PurchaseList p, Students s, Courses c" +
                " WHERE p.student_name = s.name and p.course_name = c.name";
        Query query = session.createSQLQuery(sql).addEntity(LinkedPurchaseList.class);
        List<LinkedPurchaseList> result = (List<LinkedPurchaseList>) query.getResultList();

        result.forEach(session::save);

        transaction.commit();
        sessionFactory.close();
    }
}
