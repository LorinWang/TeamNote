package teamnote.action;

public class ModifyMenuAction extends AdminBaseAction
{
	public String execute(String userName, String menuName, String menuNewName, String menuP, String menuOwnerName, String menuGroupName) throws Exception
	{
		int result = adminService.modifyMenu(userName, menuName, menuNewName, menuP, menuOwnerName, menuGroupName);
		if (result == -1)
		{
			return "用户不存在或目录不存在，或目录为temp目录";
		}
		if(result==-2)
		{
			return "已存在与新目录名相同的文件";
		}
		if(result==-3)
		{
			return "该目录正在被修改";
		}
		if(result==-4)
		{
			return "用户不具备修改目录的权限";
		}
		if(result==1)
		{
			return "修改目录成功";
		}
		else
		{
			return "修改目录失败";
		}

	}
}

