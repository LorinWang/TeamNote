package teamnote.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import teamnote.dao.UserGroupDao;
import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;
import teamnote.utils.HibernateUtil;

public class UserGroupDaoHibernate implements UserGroupDao
{

	@Override
	public UserGroup findByName(String name)
	{
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		List userGroups = sess.createQuery("from UserGroup where groupName=:name").setString("name", name).list();
		tx.commit();
		// HibernateUtil.closeSession();
		if (userGroups.size() >= 0)
		{
			return (UserGroup) userGroups.get(0);
		}
		else
			return null;

	}
	/*
	 * @Override public UserGroup findById(long id) { return
	 * getHibernateTemplate().get(UserGroup.class, id); }
	 * 
	 * @Override public UserGroup findByName(String name) { List<UserGroup>
	 * userGroups = (List<UserGroup>)
	 * getHibernateTemplate().find("from UserGroup where groupName = ?", name);
	 * if (userGroups != null && userGroups.size() >= 1) { return
	 * userGroups.get(0); } return null; }
	 * 
	 * @Override public UserGroup findByMenuOwner(Menu menu) { List<UserGroup>
	 * userGroups = (List<UserGroup>)
	 * getHibernateTemplate().find("from UserGroup as ug where " +
	 * "? in elements(ug.groupOwnedMenus)", menu); if (userGroups != null &&
	 * userGroups.size() >= 1) { return userGroups.get(0); } return null; }
	 * 
	 * @Override public UserGroup findByDocOwner(Doc doc) { List<UserGroup>
	 * userGroups = (List<UserGroup>)
	 * getHibernateTemplate().find("from UserGroup as ug where " +
	 * "? in elements(ug.groupOwnedDocs)", doc); if (userGroups != null &&
	 * userGroups.size() >= 1) { return userGroups.get(0); } return null; }
	 * 
	 * @Override public List<UserGroup> findByGroupOwner(User user) { return
	 * (List<UserGroup>)
	 * getHibernateTemplate().find("from UserGroup where groupOwner = ?", user);
	 * }
	 * 
	 * @Override public long save(UserGroup userGroup) { return (Long)
	 * getHibernateTemplate().save(userGroup); }
	 * 
	 * @Override public void update(UserGroup userGroup) {
	 * getHibernateTemplate().update(userGroup); }
	 * 
	 * @Override public void delete(UserGroup userGroup) {
	 * getHibernateTemplate().delete(userGroup); }
	 * 
	 * @Override public List<UserGroup> findAll() { return (List<UserGroup>)
	 * getHibernateTemplate().find("from UserGroup"); }
	 * 
	 * @Override public List<UserGroup> findByUser(User user) { return
	 * (List<UserGroup>)
	 * getHibernateTemplate().find("from UserGroup as ug where " +
	 * "? in elements(ug.groupUsers)", user); }
	 */
}
