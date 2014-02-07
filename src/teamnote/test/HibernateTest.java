package teamnote.test;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import teamnote.domain.UserGroup;

public class HibernateTest extends TestCase
{
	private SessionFactory sessionFactory;

	@Override
	protected void setUp() throws Exception
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	/*@Override
	protected void tearDown() throws Exception
	{
		if (sessionFactory != null)
		{
			sessionFactory.close();
		}
	}
*/
	public void testBasicUsage()
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new UserGroup());
		// session.save( new Event( "Œ“ «À≠", new Date() ) );
		// session.save( new Event( "A follow up event", new Date() ) );
		session.getTransaction().commit();
		session.close();

	}
}
