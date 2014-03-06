package teamnote.action;

public class DeleteMenuAction extends AdminBaseAction
{
	public String execute(String userName, String menuName) throws Exception
	{
		int result = adminService.deleteMenu(userName, menuName);
		if (result == -1)
		{
			return "用户不存在或目录不存在，或目录为temp目录";
		}
		if(result==1)
		{
			return "删除目录成功";
		}
		else
		{
			return "删除目录失败";
		}

	}
}
