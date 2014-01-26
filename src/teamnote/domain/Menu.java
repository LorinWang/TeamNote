package teamnote.domain;

import java.util.HashSet;
import java.util.Set;

public class Menu
{
	private long menuId; // 目录主键
	private String menuName; // 目录名
	private String menuP; // 目录权限

	private User menuOwner; // 目录所有者
	private UserGroup menuGroup; // 目录所属组

	private User modifyUser; // 目录修改者

	private Set<Doc> docs = new HashSet<Doc>(); // 目录中文档
	private Set<User> unfoldUsers = new HashSet<User>(); // 目录展开者

	public Menu()
	{
		super();
	}

	public Menu(long menuId, String menuName, String menuP, User menuOwner, UserGroup menuGroup, User modifyUser, Set<Doc> docs, Set<User> unfoldUsers)
	{
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuP = menuP;
		this.menuOwner = menuOwner;
		this.menuGroup = menuGroup;
		this.modifyUser = modifyUser;
		this.docs = docs;
		this.unfoldUsers = unfoldUsers;
	}

	public long getMenuId()
	{
		return menuId;
	}

	public void setMenuId(long menuId)
	{
		this.menuId = menuId;
	}

	public String getMenuName()
	{
		return menuName;
	}

	public void setMenuName(String menuName)
	{
		this.menuName = menuName;
	}

	public String getMenuP()
	{
		return menuP;
	}

	public void setMenuP(String menuP)
	{
		this.menuP = menuP;
	}

	public User getMenuOwner()
	{
		return menuOwner;
	}

	public void setMenuOwner(User menuOwner)
	{
		this.menuOwner = menuOwner;
	}

	public UserGroup getMenuGroup()
	{
		return menuGroup;
	}

	public void setMenuGroup(UserGroup menuGroup)
	{
		this.menuGroup = menuGroup;
	}

	public User getModifyUser()
	{
		return modifyUser;
	}

	public void setModifyUser(User modifyUser)
	{
		this.modifyUser = modifyUser;
	}

	public Set<Doc> getDocs()
	{
		return docs;
	}

	public void setDocs(Set<Doc> docs)
	{
		this.docs = docs;
	}

	public Set<User> getUnfoldUsers()
	{
		return unfoldUsers;
	}

	public void setUnfoldUsers(Set<User> unfoldUsers)
	{
		this.unfoldUsers = unfoldUsers;
	}

}
