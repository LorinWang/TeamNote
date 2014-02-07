package teamnote.domain;

import java.util.HashSet;
import java.util.Set;

public class UserGroup
{
	private long groupId; // �û�������
	private String groupName; // �û�����

	private Set<User> groupUsers = new HashSet<User>(); // �û����Ա

	private Set<Menu> groupOwnedMenus = new HashSet<Menu>();// �����Ŀ¼
	private Set<Doc> groupOwnedDocs = new HashSet<Doc>();// ������ĵ�

	private User groupOwner; // �û������Ա

	public UserGroup()
	{
		super();
	}

	public UserGroup(long groupId, String groupName, Set<User> groupUsers, Set<Menu> groupOwnedMenus, Set<Doc> groupOwnedDocs, User groupOwner)
	{
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupUsers = groupUsers;
		this.groupOwnedMenus = groupOwnedMenus;
		this.groupOwnedDocs = groupOwnedDocs;
		this.groupOwner = groupOwner;
	}

	public long getGroupId()
	{
		return groupId;
	}

	public void setGroupId(long groupId)
	{
		this.groupId = groupId;
	}

	public String getGroupName()
	{
		return groupName;
	}

	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	public Set<User> getGroupUsers()
	{
		return groupUsers;
	}

	public void setGroupUsers(Set<User> groupUsers)
	{
		this.groupUsers = groupUsers;
	}

	public Set<Menu> getGroupOwnedMenus()
	{
		return groupOwnedMenus;
	}

	public void setGroupOwnedMenus(Set<Menu> groupOwnedMenus)
	{
		this.groupOwnedMenus = groupOwnedMenus;
	}

	public Set<Doc> getGroupOwnedDocs()
	{
		return groupOwnedDocs;
	}

	public void setGroupOwnedDocs(Set<Doc> groupOwnedDocs)
	{
		this.groupOwnedDocs = groupOwnedDocs;
	}

	public User getGroupOwner()
	{
		return groupOwner;
	}

	public void setGroupOwner(User groupOwner)
	{
		this.groupOwner = groupOwner;
	}

}
