package BD;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Consulta {

	private static SessionFactory factory;
	private static Session session;

	public static boolean insertar(Object obj) {

		Transaction tx = iniciarTransaccion();

		try {
			session.save(obj);// guardo el registro en la base de datos
			tx.commit();
		} catch (Exception e) {

			if (tx != null)
				tx.rollback();

			e.printStackTrace();
			return false;
		} finally {
			session.close();
			factory.close();
		}
		return true;

	}

	public static List<Object[]> consultar(String consulta) {

		Transaction tx = iniciarTransaccion();

		List<Object[]> lista_de_cosas = null;

		try {
			
			Query q = session.createQuery(consulta); // envio la consulta a la base de datos
			lista_de_cosas = q.getResultList();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();

			e.printStackTrace();

		} finally {
			session.close();
			factory.close();
		}

		return lista_de_cosas;

	}

	public static org.hibernate.Transaction iniciarTransaccion() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		factory = cfg.buildSessionFactory();
		session = factory.openSession();

		Transaction tx = session.beginTransaction();

		return tx;
	}

}
