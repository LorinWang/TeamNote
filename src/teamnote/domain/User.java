package teamnote.domain;

import java.util.HashSet;
import java.util.Set;

public class User
{
	private long userId; // 用户主键
	private String userName; // 用户名
	private String userPassword; // 用户密码

	private boolean userIsAdmin; // 是否是管理员
	private boolean userIsLogged; // 是否登录

	private Set<Menu> userModifiedMenus = new HashSet<Menu>();// 修改目录
	private Set<Menu> userUnfoldMenus = new HashSet<Menu>();// 展开的目录
	private Set<Menu> userOwnedMenus = new HashSet<Menu>();// 管理的目录

	private Set<Doc> userOwnedDocs = new HashSet<Doc>();// 新建文档
	private Set<Doc> userEditedDocs = new HashSet<Doc>();// 正在修改的文档
	private Set<Doc> userModifiedDocs = new HashSet<Doc>();// 正在修改属性的文档
	private Set<Doc> userReadDocs = new HashSet<Doc>();// 正在读的文档

	private Set<UserGroup> userGroup = new HashSet<UserGroup>();// 用户所属组
	private Set<UserGroup> userOwnedGroups = new HashSet<UserGroup>();// 用户管理的用户组

	public User()
	{
		super();
	}

	public User(long userId, String userName, String userPassword, boolean userIsAdmin, boolean userIsLogged, Set<Menu> userModifiedMenus, Set<Menu> userUnfoldMenus, Set<Menu> userOwnedMenus, Set<Doc> userOwnedDocs, Set<Doc> userEditedDocs, Set<Doc> userModifiedDocs, Set<Doc> userReadDocs, Set<UserGroup> userGroup, Set<UserGroup> userOwnedGroups)
	{
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userIsAdmin = userIsAdmin;
		this.userIsLogged = userIsLogged;
		this.userModifiedMenus = userModifiedMenus;
		this.userUnfoldMenus = userUnfoldMenus;
		this.userOwnedMenus = userOwnedMenus;
		this.userOwnedDocs = userOwnedDocs;
		this.userEditedDocs = userEditedDocs;
		this.userModifiedDocs = userModifiedDocs;
		this.userReadDocs = userReadDocs;
		this.userGroup = userGroup;
		this.userOwnedGroups = userOwnedGroups;
	}

	public long getUserId()
	{
		return userId;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPassword()
	{
		return userPassword;
	}

	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}

	public boolean isUserIsAdmin()
	{
		return userIsAdmin;
	}

	public void setUserIsAdmin(boolean userIsAdmin)
	{
		this.userIsAdmin = userIsAdmin;
	}

	public boolean isUserIsLogged()
	{
		return userIsLogged;
	}

	public void setUserIsLogged(boolean userIsLogged)
	{
		this.userIsLogged = userIsLogged;
	}

	public Set<Menu> getUserModifiedMenus()
	{
		return userModifiedMenus;
	}

	public void setUserModifiedMenus(Set<Menu> userModifiedMenus)
	{
		this.userModifiedMenus = userModifiedMenus;
	}

	public Set<Menu> getUserUnfoldMenus()
	{
		return userUnfoldMenus;
	}

	public void setUserUnfoldMenus(Set<Menu> userUnfoldMenus)
	{
		this.userUnfoldMenus = userUnfoldMenus;
	}

	public Set<Menu> getUserOwnedMenus()
	{
		return userOwnedMenus;
	}

	public void setUserOwnedMenus(Set<Menu> userOwnedMenus)
	{
		this.userOwnedMenus = userOwnedMenus;
	}

	public Set<Doc> getUserOwnedDocs()
	{
		return userOwnedDocs;
	}

	public void setUserOwnedDocs(Set<Doc> userOwnedDocs)
	{
		this.userOwnedDocs = userOwnedDocs;
	}

	public Set<Doc> getUserEditedDocs()
	{
		return userEditedDocs;
	}

	public void setUserEditedDocs(Set<Doc> userEditedDocs)
	{
		this.userEditedDocs = userEditedDocs;
	}

	public Set<Doc> getUserModifiedDocs()
	{
		return userModifiedDocs;
	}

	public void setUserModifiedDocs(Set<Doc> userModifiedDocs)
	{
		this.userModifiedDocs = userModifiedDocs;
	}

	public Set<Doc> getUserReadDocs()
	{
		return userReadDocs;
	}

	public void setUserReadDocs(Set<Doc> userReadDocs)
	{
		this.userReadDocs = userReadDocs;
	}

	public Set<UserGroup> getUserGroup()
	{
		return userGroup;
	}

	public void setUserGroup(Set<UserGroup> userGroup)
	{
		this.userGroup = userGroup;
	}

	public Set<UserGroup> getUserOwnedGroups()
	{
		return userOwnedGroups;
	}

	public void setUserOwnedGroups(Set<UserGroup> userOwnedGroups)
	{
		this.userOwnedGroups = userOwnedGroups;
	}

}
