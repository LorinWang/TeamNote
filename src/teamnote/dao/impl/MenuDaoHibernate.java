package teamnote.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import teamnote.dao.MenuDao;
import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;
import teamnote.utils.HibernateUtil;

public class MenuDaoHibernate  implements MenuDao
{
	@Override
	public List<Menu> findAll()
	{
		Session sess =HibernateUtil.currentSession();
		Transaction tx=sess.beginTransaction();
		List menus=sess.createQuery("from Menu").list();
		tx.commit();
		//HibernateUtil.closeSession();
		if(menus.size()>=0)
		{
			return menus;
		}
		else
		{ 
			return null;
		}
	}
	
	@Override
	public Menu findByName(String name)
	{
		Session sess =HibernateUtil.currentSession();
		Transaction tx=sess.beginTransaction();
		List<Menu> menus=sess.createQuery("from Menu where menuName=:name").setString("name", name).list();
		tx.commit();
		//HibernateUtil.closeSession();
		if(menus.size()>=0)
		{
			return (Menu) menus.get(0);
		}
		else return null;
	}
	
	@Override
	public long save(Menu menu)
	{
		Session sess =HibernateUtil.currentSession();
		Transaction tx=sess.beginTransaction();
		Object result=sess.save(menu);
		sess.flush();		
		tx.commit();
		return (long) result;
	}
	
	/*@Override
	public Menu findById(long id)
	{
		return getHibernateTemplate().get(Menu.class, id);
	}

	

	@Override
	public Menu findByDoc(Doc doc)
	{
		List<Menu> menus = (List<Menu>) getHibernateTemplate().find("from Menu as m where " + "? in elements(m.menuDocs)", doc);
		if (menus != null && menus.size() >= 1)
		{
			return menus.get(0);
		}
		return null;
	}

	

	@Override
	public void update(Menu menu)
	{
		getHibernateTemplate().update(menu);
	}

	@Override
	public void delete(Menu menu)
	{
		getHibernateTemplate().delete(menu);
	}

	

	@Override
	public List<Menu> findByUnfoldUser(User user)
	{
		return (List<Menu>) getHibernateTemplate().find("from Menu as m where " + "? in elements(m.menuUnfoldUsers)", user);
	}

	@Override
	public List<Menu> findByModifier(User modifier)
	{
		return (List<Menu>) getHibernateTemplate().find("from Menu as m where " + "m.menuModifier = ?", modifier);
	}

	@Override
	public List<Menu> findByOwner(User owner)
	{
		return (List<Menu>) getHibernateTemplate().find("from Menu as m where " + "m.menuOwner = ?", owner);
	}

	@Override
	public List<Menu> findByGroup(UserGroup userGroup)
	{
		return (List<Menu>) getHibernateTemplate().find("from Menu as m where " + "m.menuGroup = ?", userGroup);
	}*/

}
