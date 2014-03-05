package teamnote.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil
{
	public static final SessionFactory sessionFactory;
	
	static
	{
		try
		{
			//����Ĭ�ϵ�hibernate.cfg.xml������һ��Configuration��ʵ��
			Configuration configuration = new Configuration()
				.configure();
			//��Configuration��ʵ��������һ��SessionFactoryʵ��
			sessionFactory = configuration.buildSessionFactory();
		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	//ThreadLocal���Ը������̵߳����ݹ�����˲�����Ҫ���߳�ͬ��	
	public static final ThreadLocal<Session> session
		= new ThreadLocal<Session>();
	
	public static Session currentSession()
		throws HibernateException
	{
		Session s = session.get();
		//������̻߳�û��Session,�򴴽�һ���µ�Session
		if (s == null)
		{
			s = sessionFactory.openSession();
			//����õ�Session�����洢��ThreadLocal����session��
			session.set(s);
		}
		return s;
	}
	
	public static void closeSession()
		throws HibernateException 
	{
		Session s = session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
}