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

	private User menuModifier; // Ŀ¼�����޸���

	private Set<Doc> menuDocs = new HashSet<Doc>(); // Ŀ¼���ĵ�
	private Set<User> menuUnfoldUsers = new HashSet<User>(); // Ŀ¼չ����

	public Menu()
	{
		super();
	}

	public Menu(long menuId, String menuName, String menuP, User menuOwner, UserGroup menuGroup, User menuModifier, Set<Doc> menuDocs, Set<User> menuUnfoldUsers)
	{
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuP = menuP;
		this.menuOwner = menuOwner;
		this.menuGroup = menuGroup;
		this.menuModifier = menuModifier;
		this.menuDocs = menuDocs;
		this.menuUnfoldUsers = menuUnfoldUsers;
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

	public User getMenuModifier()
	{
		return menuModifier;
	}

	public void setMenuModifier(User menuModifier)
	{
		this.menuModifier = menuModifier;
	}

	public Set<Doc> getMenuDocs()
	{
		return menuDocs;
	}

	public void setMenuDocs(Set<Doc> menuDocs)
	{
		this.menuDocs = menuDocs;
	}

	public Set<User> getMenuUnfoldUsers()
	{
		return menuUnfoldUsers;
	}

	public void setMenuUnfoldUsers(Set<User> menuUnfoldUsers)
	{
		this.menuUnfoldUsers = menuUnfoldUsers;
	}

}
