package teamnote.domain;

import java.util.HashSet;
import java.util.Set;

public class Menu
{
	private long menuId; // Ŀ¼����
	private String menuName; // Ŀ¼��
	private String menuP; // Ŀ¼Ȩ��

	private User menuOwner; // Ŀ¼������
	private UserGroup menuGroup; // Ŀ¼������

	private User modifyUser; // Ŀ¼�޸���

	private Set<Doc> docs = new HashSet<Doc>(); // Ŀ¼���ĵ�
	private Set<User> unfoldUsers = new HashSet<User>(); // Ŀ¼չ����

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
