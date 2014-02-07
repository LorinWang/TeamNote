package teamnote.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import teamnote.domain.UserGroup;

public class HibernateTest1
{
	private static SessionFactory sessionFactory;
	public static void main(String[] args)
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new UserGroup());
		session.getTransaction().commit();
		session.close();

	}

}
