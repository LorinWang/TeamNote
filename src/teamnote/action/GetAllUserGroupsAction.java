package teamnote.action;

import java.util.List;

import teamnote.domain.UserGroup;

public class GetAllUserGroupsAction extends UserBaseAction
{
	public List<UserGroup> execute() throws Exception
	{
		List<UserGroup> userGroups = null;
		userGroups = userService.getAllUserGroups();
		if (userGroups == null)
		{
			System.out.println("userGroupsÎª¿Õ");
			return null;
		}
		else
		{
			return userGroups;
		}
	}

}
