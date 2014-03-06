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
		menuDao.save(menu);
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
			return -1;
		}
		if (menuName.equals("temp") || menu == null)
		{
			menu = menuDao.findByName("temp");
		}
		if (judgeMenuP(user, menu, 'w'))
		{
			// ºÏ≤‚Œƒµµ÷ÿ∏¥
			Doc tempDoc = docDao.findByName(docName);
			if (tempDoc != null && tempDoc.getDocMenu() == menu)
			{
				return -3;
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
			docDao.save(doc);
			return doc.getDocId();

		}
		return -2;
	}

	@Override
	public int deleteDoc(String userName, String menuName, long docId)
	{
		User user = userDao.findByName(userName);
		Menu menu = menuDao.findByName(menuName);
		Doc doc = docDao.findById(docId);
		if (user == null || menu == null || doc == null)
		{
			return -1;
		}
		if (judgeMenuP(user, menu, 'x') && judgeDocP(user, doc, 'x'))
		{
			if (doc.getDocModifier() != null || doc.getDocEditor() != null)
			{
				return -3;
			}
			else
			{
				docDao.delete(doc);
				return 1;
			}
		}
		return -2;
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
	public String openDoc(String userName, long docId)
	{
		User user = userDao.findByName(userName);
		Doc doc = docDao.findById(docId);
		if (user == null || doc == null)
		{
			return "-1";
		}
		if (judgeDocP(user, doc, 'r'))
		{
			if (user.getUserReadDocs().contains(doc) || doc.getDocReadUsers().contains(user))
			{
				return "-3";
			}
			else
			{
				user.getUserReadDocs().add(doc);
				userDao.save(user);
				return doc.getDocContent();
			}

		}
		return "-2";
	}

	@Override
	public int closeDoc(String userName, long docId)
	{
		User user = userDao.findByName(userName);
		Doc doc = docDao.findById(docId);
		if (user == null || doc == null)
		{
			return -1;
		}
		if (user.getUserReadDocs().contains(doc) && doc.getDocReadUsers().contains(user))
		{
			user.getUserReadDocs().remove(doc);
			userDao.save(user);
			return 1;
		}
		return -2;
	}

	@Override
	public int editDoc(String userName, long docId, String docContent)
	{
		User user = userDao.findByName(userName);
		Doc doc = docDao.findById(docId);
		if (user == null || doc == null)
		{
			return -1;
		}
		if (judgeDocP(user, doc, 'w'))
		{
			if (doc.getDocEditor() == null)
			{
				doc.setDocEditor(user);
				docDao.save(doc);
				if (doc.getDocEditor() == user)
				{
					//System.out.println(user.getUserEditedDocs());
					doc.setDocContent(docContent);
					doc.setDocEditor(null);	
					docDao.save(doc);
					user.getUserEditedDocs().remove(doc);
					//System.out.println(user.getUserEditedDocs());
					return 1;
				}
				return -3;
			}
			return -3;
		}
		return -2;
	}

	@Override
	public int modifyDoc(String userName, long docId, String docNewName, String docP, String docOwnerName, String docGroupName, String docMenuName)
	{
		User user = userDao.findByName(userName);
		Doc doc = docDao.findById(docId);
		User docOwner = userDao.findByName(docOwnerName);
		UserGroup docGroup = userGroupDao.findByName(docGroupName);
		Menu docMenu = menuDao.findByName(docMenuName);
		if (user == null || doc == null||docMenu==null)
		{
			return -1;
		}
		
		Doc tempDoc=docDao.findByName(docNewName);
		if (!(docNewName.equals(doc.getDocName())) && tempDoc!= null&&tempDoc.getDocMenu()==doc.getDocMenu())
		{
			return -2;
		}
		
		

		if (judgeDocP(user, doc, 'x'))
		{
			if (doc.getDocModifier() == null)
			{
				doc.setDocModifier(user);
				docDao.save(doc);
				if (doc.getDocModifier() == user)
				{
					System.out.println(user.getUserModifiedDocs());
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
					if (doc.getDocMenu()!=docMenu)
					{
						doc.setDocMenu(docMenu);
					}
					doc.setDocModifier(null);
					docDao.save(doc);
					user.getUserModifiedDocs().remove(doc);
					System.out.println(user.getUserModifiedDocs());
					return 1;
				}
				return -4;
			}
			return -4;
		}
		return -3;

	}
}
