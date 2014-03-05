package teamnote.service.impl;

import java.util.ArrayList;
import java.util.List;
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
import teamnote.service.UserService;

public class UserServiceImpl implements UserService
{

	private DocDao docDao = new DocDaoHibernate();
	private MenuDao menuDao = new MenuDaoHibernate();
	private UserDao userDao = new UserDaoHibernate();
	private UserGroupDao userGroupDao = new UserGroupDaoHibernate();

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

	@Override
	public List<Menu> showMenus(String userName)
	{
		List<Menu> menus = menuDao.findAll();
		User user = userDao.findByName(userName);
		if (menus == null || user == null)
		{
			return null;
		}

		if (user.isUserIsAdmin())
		{
			return menus;
		}
		else
		{
			List<Menu> returnMenu = new ArrayList<Menu>();
			for (Menu menu : menus)
			{
				if (menu.getMenuP().charAt(6) == 'r')
				{
					returnMenu.add(menu);
				}
				else if (menu.getMenuP().charAt(0) == 'r' && menu.getMenuOwner() == user)
				{
					returnMenu.add(menu);
				}

				else if (menu.getMenuP().charAt(3) == 'r' && menu.getMenuGroup().getGroupUsers().contains(user))
				{
					returnMenu.add(menu);
				}
			}
			return returnMenu;
		}
	}

	@Override
	public int validLogin(User user)
	{
		User tempUser = null;
		tempUser = userDao.findByNameAndPass(user);
		if (tempUser != null && tempUser.isUserIsLogged() == false)
		{
			tempUser.setUserIsLogged(true);
			if (tempUser.isUserIsAdmin() == true)
			{
				return LOGIN_ADM;
			}
			else
			{
				return LOGIN_USR;
			}

		}
		else
		{
			return LOGIN_FAIL;
		}
	}

	@Override
	public Set<Doc> unfoldMenu(String userName, String menuName)
	{
		User user = userDao.findByName(userName);
		Menu menu = menuDao.findByName(menuName);
		if (menu == null || user == null)
		{
			return null;
		}
		menu.getMenuUnfoldUsers().add(user);
		user.getUserUnfoldMenus().add(menu);
		return menu.getMenuDocs();
	}

	@Override
	public int foldMenu(String userName, String menuName)
	{
		User user = userDao.findByName(userName);
		Menu menu = menuDao.findByName(menuName);
		if (menu == null || user == null)
		{
			return 0;
		}
		else if (menu.getMenuUnfoldUsers().contains(user) == false || user.getUserUnfoldMenus().contains(menu) == false)
		{
			return 1;
		}
		else
		{
			menu.getMenuUnfoldUsers().remove(user);
			user.getUserUnfoldMenus().remove(menu);
			return 2;
		}
	}

	@Override
	public long createDoc(String userName, String docName, String menuName, String docContent)
	{
		User user = userDao.findByName(userName);
		Menu menu = menuDao.findByName(menuName);
		if (user == null || docName == null)
		{
			return 0;
		}
		if (menuName.equals("temp") || menu == null)
		{
			menu = menuDao.findByName("temp");
		}
		// ºÏ≤‚Œƒµµ÷ÿ∏¥
		Doc tempDoc = docDao.findByName(docName);
		if (tempDoc != null && tempDoc.getDocMenu() == menu)
		{
			return 1;
		}
		Doc doc = new Doc();
		doc.setDocName(docName);
		doc.setDocContent(docContent);
		doc.setDocGroup(null);
		doc.setDocEditor(null);
		doc.setDocModifier(null);
		doc.setDocOwner(user);
		doc.setDocMenu(menu);
		doc.setDocP(DEFAULT_DOCP);
		if (judgeMenuP(user, menu, 'w'))
		{
			docDao.save(doc);
			return 2;
		}
		return 3;
	}

	@Override
	public int deleteDoc(String userName, String menuName, String docName)
	{
		User user = userDao.findByName(userName);
		Menu menu = menuDao.findByName(menuName);
		Doc doc = docDao.findByName(docName);
		if (user == null || menu == null || doc == null)
		{
			return 0;
		}
		if (judgeMenuP(user, menu, 'x') && judgeDocP(user, doc, 'x'))
		{
			if (doc.getDocModifier() != null || doc.getDocEditor() != null)
			{
				return 2;
			}
			else
			{
				docDao.delete(doc);
				return 3;
			}
		}
		return 1;
	}

	public static boolean judgeMenuP(User user, Menu menu, char p)
	{
		if (p == 'r')
		{
			if (menu.getMenuP().charAt(6) == p)
			{
				return true;
			}
			else if (menu.getMenuP().charAt(0) == p && menu.getMenuOwner() == user)
			{
				return true;
			}
			else if (menu.getMenuP().charAt(3) == p && menu.getMenuGroup().getGroupUsers().contains(user))
			{
				return true;
			}

		}
		if (p == 'w')
		{
			if (menu.getMenuP().charAt(7) == p)
			{
				return true;
			}
			else if (menu.getMenuP().charAt(1) == p && menu.getMenuOwner() == user)
			{
				return true;
			}
			else if (menu.getMenuP().charAt(4) == p && menu.getMenuGroup().getGroupUsers().contains(user))
			{
				return true;
			}
		}
		if (p == 'x')
		{
			if (menu.getMenuP().charAt(8) == p)
			{
				return true;
			}
			else if (menu.getMenuP().charAt(2) == p && menu.getMenuOwner() == user)
			{
				return true;
			}
			else if (menu.getMenuP().charAt(5) == p && menu.getMenuGroup().getGroupUsers().contains(user))
			{
				return true;
			}

		}

		return false;

	}

	public static boolean judgeDocP(User user, Doc doc, char p)
	{
		if (p == 'r')
		{
			if (doc.getDocP().charAt(6) == p)
			{
				return true;
			}
			else if (doc.getDocP().charAt(0) == p && doc.getDocOwner() == user)
			{
				return true;
			}
			else if (doc.getDocP().charAt(3) == p && doc.getDocGroup().getGroupUsers().contains(user))
			{
				return true;
			}

		}
		if (p == 'w')
		{
			if (doc.getDocP().charAt(7) == p)
			{
				return true;
			}
			else if (doc.getDocP().charAt(1) == p && doc.getDocOwner() == user)
			{
				return true;
			}
			else if (doc.getDocP().charAt(4) == p && doc.getDocGroup().getGroupUsers().contains(user))
			{
				return true;
			}
		}
		if (p == 'x')
		{
			if (doc.getDocP().charAt(8) == p)
			{
				return true;
			}
			else if (doc.getDocP().charAt(2) == p && doc.getDocOwner() == user)
			{
				return true;
			}
			else if (doc.getDocP().charAt(5) == p && doc.getDocGroup().getGroupUsers().contains(user))
			{
				return true;
			}

		}

		return false;

	}

	@Override
	public String openDoc(String userName, String docName)
	{
		User user = userDao.findByName(userName);
		Doc doc = docDao.findByName(docName);
		if (user == null || doc == null)
		{
			return "0";
		}
		if (judgeDocP(user, doc, 'r'))
		{
			if (user.getUserReadDocs().contains(doc) || doc.getDocReadUsers().contains(user))
			{
				return "2";
			}
			else
			{
				user.getUserReadDocs().add(doc);
				doc.getDocReadUsers().add(user);
				return doc.getDocContent();
			}

		}
		return "1";
	}

	@Override
	public int closeDoc(String userName, String docName)
	{
		User user = userDao.findByName(userName);
		Doc doc = docDao.findByName(docName);
		if (user == null || doc == null)
		{
			return 0;
		}
		if (user.getUserReadDocs().contains(doc) && doc.getDocReadUsers().contains(user))
		{
			user.getUserReadDocs().remove(doc);
			doc.getDocReadUsers().remove(user);
			return 2;
		}
		return 1;
	}

	@Override
	public int editDoc(String userName, String docName, String docContent)
	{
		User user = userDao.findByName(userName);
		Doc doc = docDao.findByName(docName);
		if (user == null || doc == null)
		{
			return 0;
		}
		if (judgeDocP(user, doc, 'w'))
		{
			if (doc.getDocEditor() == null)
			{
				doc.setDocEditor(user);
				if(doc.getDocEditor()==user)
				{
					user.getUserEditedDocs().add(doc);
					doc.setDocContent(docContent);
					doc.setDocEditor(null);
					user.getUserEditedDocs().remove(doc);
				}
			}
			return 2;
		}
		return 1;
	}

	@Override
	public int modifyDoc(String userName, String docName, String docNewName, String docP, String docOwnerName, String docGroupName, String docMenuName)
	{
		User user = userDao.findByName(userName);
		Doc doc = docDao.findByName(docName);
		if (user == null || doc == null)
		{
			return 0;
		}
		if (!(docNewName.equals(docName)) && docDao.findByName(docNewName) != null)
		{
			return 1;
		}
		User docOwner = userDao.findByName(docOwnerName);
		UserGroup docGroup = userGroupDao.findByName(docGroupName);
		Menu docMenu = menuDao.findByName(docMenuName);

		if (judgeDocP(user, doc, 'x'))
		{
			if (doc.getDocModifier() == null)
			{
				doc.setDocModifier(user);
				if (doc.getDocModifier() == user)
				{
					if (docOwner != doc.getDocOwner())
					{
						doc.setDocOwner(docOwner);
					}
					if (docGroup != doc.getDocGroup())
					{
						doc.setDocGroup(docGroup);
					}
					if (!doc.getDocName().equals(docNewName))
					{
						doc.setDocName(docNewName);
					}
					if (!doc.getDocP().equals(docP))
					{
						doc.setDocP(docP);
					}
					doc.setDocModifier(null);
					return 4;
				}
				return 3;
			}
			return 3;
		}
		return 2;

	}
}
