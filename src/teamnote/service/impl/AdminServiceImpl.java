package teamnote.service.impl;

import teamnote.dao.DocDao;
import teamnote.dao.MenuDao;
import teamnote.dao.UserDao;
import teamnote.dao.UserGroupDao;
import teamnote.dao.impl.DocDaoHibernate;
import teamnote.dao.impl.MenuDaoHibernate;
import teamnote.dao.impl.UserDaoHibernate;
import teamnote.dao.impl.UserGroupDaoHibernate;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.service.AdminService;

public class AdminServiceImpl implements AdminService
{
	

	private static final String defaultMenuP = "rwxrwxrwx";
	
	// ///////////////for RCP
	private DocDao docDao = new DocDaoHibernate();
	private MenuDao menuDao = new MenuDaoHibernate();
	private UserDao userDao = new UserDaoHibernate();
	private UserGroupDao userGroupDao = new UserGroupDaoHibernate();

	// ///////////////for SSH
	public UserDao getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	public DocDao getDocDao()
	{
		return docDao;
	}

	public void setDocDao(DocDao docDao)
	{
		this.docDao = docDao;
	}

	public MenuDao getMenuDao()
	{
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao)
	{
		this.menuDao = menuDao;
	}

	public UserGroupDao getUserGroupDao()
	{
		return userGroupDao;
	}

	public void setUserGroupDao(UserGroupDao userGroupDao)
	{
		this.userGroupDao = userGroupDao;
	}

	// //////////////////////////////

	@Override
	public long createMenu(String userName, String menuName)
	{
		User user = userDao.findByName(userName);
		if (user.isUserIsAdmin())
		{
			Menu menu = new Menu();
			menu.setMenuName(menuName);
			menu.setMenuOwner(user);
			menu.setMenuP(defaultMenuP);
			return menuDao.save(menu);
		}
		return 0;
	}

}
