package teamnote.action;

import java.util.List;

import teamnote.domain.Menu;

public class GetAllMenusAction extends UserBaseAction
{
	public List<Menu> execute() throws Exception
	{
		List<Menu> menus = null;
		menus = userService.getAllMenus();
		if (menus == null)
		{
			System.out.println("menusÎª¿Õ");
			return null;
		}
		else
		{
			return menus;
		}
	}
}
