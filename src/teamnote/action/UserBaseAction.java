package teamnote.action;

import teamnote.service.UserService;
import teamnote.service.impl.UserServiceImpl;

public class UserBaseAction
{
	protected UserService userService=new UserServiceImpl();

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}


}
