package teamnote.action;

public class FoldMenuAction extends UserBaseAction
{
	public String execute(String userName,String menuName) throws Exception
	{
		int result=userService.foldMenu(userName, menuName);
		if(result==0)
		{
			return "用户或目录不存在";
		}
		if(result==1)
		{
			return "用户已关闭该目录";
		}
		if(result==2)
		{
			return "关闭目录成功";
		}
		else
		{
			return "关闭目录失败";
		}
	}

}
