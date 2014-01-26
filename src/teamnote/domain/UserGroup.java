package teamnote.domain;

import java.util.HashSet;
import java.util.Set;

public class UserGroup
{
	private long groupId; // �û�������
	private String groupName; // �û�����

	private Set<User> users = new HashSet<User>(); // �û����Ա

	private User groupOwner; // �û������Ա

	public UserGroup()
	{
		super();
	}

	public UserGroup(long groupId, String groupName, Set<User> users, User groupOwner)
	{
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.users = users;
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

	public Set<User> getUsers()
	{
		return users;
	}

	public void setUsers(Set<User> users)
	{
		this.users = users;
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
