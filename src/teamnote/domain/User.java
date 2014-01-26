package teamnote.domain;

import java.util.HashSet;
import java.util.Set;

public class User
{
	private long userId; //用户主键
	private String userName;	//用户名
	private String userPassword;	//用户密码

	private boolean isAdmin;	//是否是管理员
	private boolean isLogged;	//是否登录

	private Set<Menu> modifyMenu = new HashSet<Menu>();// 修改目录
	private Set<Menu> unfoldMenu = new HashSet<Menu>();// 展开的目录

	private Set<Doc> createdDocs = new HashSet<Doc>();// 新建文档
	private Set<Doc> editedDocs = new HashSet<Doc>();// 正在修改的文档
	private Set<Doc> modifiedDocs = new HashSet<Doc>();// 正在修改属性的文档
	private Set<Doc> readDocs=new HashSet<Doc>();//正在读的文档

	private Set<UserGroup> group = new HashSet<UserGroup>();// 用户所属组
	private Set<UserGroup> ownedGroups = new HashSet<UserGroup>();// 用户管理的用户组

	public User()
	{
		super();
	}
	
	public User(long userId, String userName, String userPassword, boolean isAdmin, boolean isLogged, Set<Menu> modifyMenu, Set<Menu> unfoldMenu, Set<Doc> createdDocs, Set<Doc> editedDocs, Set<Doc> modifiedDocs, Set<Doc> readDocs, Set<UserGroup> group, Set<UserGroup> ownedGroups)
	{
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.isAdmin = isAdmin;
		this.isLogged = isLogged;
		this.modifyMenu = modifyMenu;
		this.unfoldMenu = unfoldMenu;
		this.createdDocs = createdDocs;
		this.editedDocs = editedDocs;
		this.modifiedDocs = modifiedDocs;
		this.readDocs = readDocs;
		this.group = group;
		this.ownedGroups = ownedGroups;
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
	public boolean isAdmin()
	{
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}
	public boolean isLogged()
	{
		return isLogged;
	}
	public void setLogged(boolean isLogged)
	{
		this.isLogged = isLogged;
	}
	public Set<Menu> getModifyMenu()
	{
		return modifyMenu;
	}
	public void setModifyMenu(Set<Menu> modifyMenu)
	{
		this.modifyMenu = modifyMenu;
	}
	public Set<Menu> getUnfoldMenu()
	{
		return unfoldMenu;
	}
	public void setUnfoldMenu(Set<Menu> unfoldMenu)
	{
		this.unfoldMenu = unfoldMenu;
	}
	public Set<Doc> getCreatedDocs()
	{
		return createdDocs;
	}
	public void setCreatedDocs(Set<Doc> createdDocs)
	{
		this.createdDocs = createdDocs;
	}
	public Set<Doc> getEditedDocs()
	{
		return editedDocs;
	}
	public void setEditedDocs(Set<Doc> editedDocs)
	{
		this.editedDocs = editedDocs;
	}
	public Set<Doc> getModifiedDocs()
	{
		return modifiedDocs;
	}
	public void setModifiedDocs(Set<Doc> modifiedDocs)
	{
		this.modifiedDocs = modifiedDocs;
	}
	public Set<Doc> getReadDocs()
	{
		return readDocs;
	}
	public void setReadDocs(Set<Doc> readDocs)
	{
		this.readDocs = readDocs;
	}
	public Set<UserGroup> getGroup()
	{
		return group;
	}
	public void setGroup(Set<UserGroup> group)
	{
		this.group = group;
	}
	public Set<UserGroup> getOwnedGroups()
	{
		return ownedGroups;
	}
	public void setOwnedGroups(Set<UserGroup> ownedGroups)
	{
		this.ownedGroups = ownedGroups;
	}

	
}
