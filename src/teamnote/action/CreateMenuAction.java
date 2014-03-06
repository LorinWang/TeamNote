package teamnote.action;

public class CreateMenuAction extends AdminBaseAction
{
	public String execute(String userName, String menuName) throws Exception
	{
		Long menuId = adminService.createMenu(userName, menuName);
		if (menuId == -1)
		{
			return "用户不存在或已存在同名目录";
		}
		return "新建目录成功，目录ID为:" + menuId.toString();

	}
}
