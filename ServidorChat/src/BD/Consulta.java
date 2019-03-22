package BD;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Cliente.Persona;

public class Consulta {

	private static SessionFactory factory;
	private static Session session;

	public static boolean insertar(Object obj) {

		Persona persona = (Persona) obj;
		String consulta = "select p.email from Persona p ";
		consulta += "where p.email=" + "'" + persona.getEmail() + "'";
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
	
	public static boolean verificarEmail(String email) {

		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher verificador = pattern.matcher(email);

		if (verificador.find() == false) {
			return false;

		}
		return true;

	}

	public static Transaction iniciarTransaccion() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		factory = cfg.buildSessionFactory();
		session = factory.openSession();

		Transaction tx = session.beginTransaction();

		return tx;
	}

}
