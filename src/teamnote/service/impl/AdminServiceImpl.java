package teamnote.service.impl;

import java.util.Set;

import teamnote.dao.DocDao;
import teamnote.dao.MenuDao;
import teamnote.dao.UserDao;
import teamnote.dao.UserGroupDao;
import teamnote.dao.impl.DocDaoHibernate;
import teamnote.dao.impl.MenuDaoHibernate;
import teamnote.dao.impl.UserDaoHibernate;
import teamnote.dao.impl.UserGroupDaoHibernate;
import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;
import teamnote.service.AdminService;

public class AdminServiceImpl extends UserServiceImpl implements AdminService
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
		Menu menu = menuDao.findByName(menuName);
		if (user == null || menu != null)
		{
			return -1;
		}

		menu = new Menu();
		menu.setMenuName(menuName);
		menu.setMenuOwner(user);
		menu.setMenuP(defaultMenuP);
		return menuDao.save(menu);

	}

	@Override
	public int deleteMenu(String userName, String menuName)
	{
		User user = userDao.findByName(userName);
		Menu menu = menuDao.findByName(menuName);
		if (user == null || menu == null||menu.getMenuName().equals("temp"))
		{
			return -1;
		}
		if (menu.getMenuUnfoldUsers().size()==0)
		{
			menu.setMenuP("---------");
			if(menu.getMenuUnfoldUsers()==null)
			{
				Set<Doc> docs=menu.getMenuDocs();
				for(Doc doc : docs)
				{
					docDao.delete(doc);
				}
				menuDao.delete(menu);
				return 1;
			}
		}
		//有人打开了目录
		Set<Doc> docs=menu.getMenuDocs();
		for(Doc doc:docs)
		{
			if(doc.getDocEditor()==null&&doc.getDocEditor()==null&&doc.getDocReadUsers().size()==0)
			{
				docDao.delete(doc);
			}
			else
			{
				Menu tempMenu=menuDao.findByName("temp");
				doc.setDocMenu(tempMenu);
				docDao.save(doc);
			}
		}
		menuDao.delete(menu);
		return 1;
		
		
	}

	@Override
	public int modifyMenu(String userName, String menuName, String menuNewName, String menuP, String menuOwnerName, String menuGroupName)
	{
		User user = userDao.findByName(userName);
		Menu menu = menuDao.findByName(menuName);
		User menuOwner= userDao.findByName(menuOwnerName);
		UserGroup menuGroup=userGroupDao.findByName(menuGroupName);
		
		if (user == null || menu == null||menu.getMenuName().equals("temp"))
		{
			return -1;
		}
		
		if(!menuName.equals(menuNewName)&&menuDao.findByName(menuNewName)!=null)
		{
			return -2;
		}
		if(menu.getMenuModifier()==null)
		{
			menu.setMenuModifier(user);
			menuDao.save(menu);
			if(menu.getMenuModifier()==user)
			{
				if(user.isUserIsAdmin()||judgeMenuP(user, menu, 'x'))
				{
					if(!menuName.equals(menuNewName))
					{
						menu.setMenuName(menuNewName);
					}
					if(!menu.getMenuP().equals(menuP))
					{
						menu.setMenuP(menuP);
					}
					if(menu.getMenuOwner()!=menuOwner)
					{
						menu.setMenuOwner(menuOwner);
					}
					if(menu.getMenuGroup()!=menuGroup)
					{
						menu.setMenuGroup(menuGroup);
					}
					menu.setMenuModifier(null);
					menuDao.save(menu);
					user.getUserModifiedMenus().remove(menu);
					return 1;
				}
				return -4;
			}
			return -3;
		}
		return -3;
		
		
	}

}
