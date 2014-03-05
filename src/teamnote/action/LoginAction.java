package teamnote.action;

import teamnote.domain.User;

public class LoginAction extends UserBaseAction
{
	// 定义一个常量作为员工登录成功的Result名
	private final String USR_RESULT = "usr";
	// 定义一个常量作为经理登录成功的Result名
	private final String ADM_RESULT = "adm";

	// 封装请求参数
	private User user;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	// 处理登录后的提示信息
	private String tip;

	// tip属性的setter和getter方法
	public void setTip(String tip)
	{
		this.tip = tip;
	}

	public String getTip()
	{
		return this.tip;
	}

	// 处理用户请求
	public String execute(User user) throws Exception
	{
		
		// 调用业务逻辑方法来处理登录请求
		int result = userService.validLogin(user);
		// 登录结果为普通员工
		if (result == 1)
		{
			setTip("您已经成功登录系统");
			return USR_RESULT;
		}
		// 登录结果为经理
		else if (result == 2)
		{
			setTip("您已经成功登录系统");
			return ADM_RESULT;
		}
		// 用户名和密码不匹配
		else
		{
			setTip("用户名/密码不匹配");
			return null;
		}

	}
}