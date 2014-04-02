package teamnote.action;

import java.util.List;

import teamnote.domain.User;

public class GetAllUsersAction extends UserBaseAction
{
	public List<User> execute() throws Exception
	{
		List<User> users = null;
		users = userService.getAllUsers();
		if (users == null)
		{
			System.out.println("usersÎª¿Õ");
			return null;
		}
		else
		{
			return users;
		}
	}
}
