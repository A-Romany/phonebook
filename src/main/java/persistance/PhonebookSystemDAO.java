package persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
public class PhonebookSystemDAO {

    private SessionFactory sessionFactory;

    public PhonebookSystemDAO() {
        sessionFactory = buildSessionFactory();

    }

    public void addPerson(Person person){
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {

            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }

    public List<Person> getPersons(){
        try (Session session= sessionFactory.openSession()) {
            List<Person> personList = session.createQuery("SELECT a FROM Person a").getResultList();
            System.out.println(personList);
            return personList;
        }catch (RuntimeException e) {
            throw  e;
        }
    }



    private static SessionFactory buildSessionFactory(){
        return  new Configuration()
                .configure()
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
    }
}
