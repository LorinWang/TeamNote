package teamnote.action;

public class CreateMenuAction extends AdminBaseAction
{
	public String execute(String userName,String menuName) throws Exception
	{
		Long menuId=adminService.createMenu(userName, menuName);
		if(menuId!=0)
		{
			return menuId.toString();
		}
		return "Create menu fail";
		
	}
}
