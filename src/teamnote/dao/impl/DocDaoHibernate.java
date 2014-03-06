package teamnote.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import teamnote.dao.DocDao;
import teamnote.domain.Doc;
import teamnote.utils.HibernateUtil;

public class DocDaoHibernate implements DocDao
{
	@Override
	public long save(Doc doc)
	{
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		Object result = sess.save(doc);
		sess.flush();
		tx.commit();
		return (long) result;
	}

	@Override
	public Doc findById(long id)
	{

		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		List<Doc> docs = sess.createQuery("from Doc where docId=:id").setLong("id", id).list();
		tx.commit();
		// HibernateUtil.closeSession();
		if (docs.size() > 0)
		{
			return (Doc) docs.get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public Doc findByName(String name)
	{
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		List<Doc> docs = sess.createQuery("from Doc where docName=:name").setString("name", name).list();
		tx.commit();
		// HibernateUtil.closeSession();
		if (docs.size() > 0)
		{
			return (Doc) docs.get(0);
		}
		else
			return null;
	}

	@Override
	public void delete(Doc doc)
	{
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(doc);
		sess.flush();
		tx.commit();
	}

	@Override
	public void update(Doc doc)
	{
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		sess.update(doc);
		sess.flush();
		tx.commit();
	}

	/*
	 * @Override public Doc findById(long id) {
	 * 
	 * return getHibernateTemplate().get(Doc.class, id); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Override public List<Doc> findAll() { return (List<Doc>)
	 * getHibernateTemplate().find("from Doc"); }
	 * 
	 * @Override public List<Doc> findByMenu(Menu menu) { return (List<Doc>)
	 * getHibernateTemplate().find("from Doc as d where " + "d.docMenu = ?",
	 * menu); }
	 * 
	 * @Override public List<Doc> findByOwner(User owner) { return (List<Doc>)
	 * getHibernateTemplate().find("from Doc as d where " + "d.docOwner = ?",
	 * owner); }
	 * 
	 * @Override public List<Doc> findByGroup(UserGroup userGroup) { return
	 * (List<Doc>) getHibernateTemplate().find("from Doc as d where " +
	 * "d.docGroup = ?", userGroup); }
	 * 
	 * @Override public List<Doc> findByReader(User reader) { return (List<Doc>)
	 * getHibernateTemplate().find("from Doc as d where " +
	 * "? in elements(d.docReadUsers)", reader); }
	 * 
	 * @Override public List<Doc> findByWriter(User writer) { return (List<Doc>)
	 * getHibernateTemplate().find("from Doc as d where " + "d.docEditor = ?",
	 * writer); }
	 * 
	 * @Override public List<Doc> findByModifier(User modifier) { return
	 * (List<Doc>) getHibernateTemplate().find("from Doc as d where " +
	 * "d.docModifier = ?", modifier); }
	 */

}
