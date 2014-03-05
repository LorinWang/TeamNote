package teamnote.action;

import java.util.List;

import teamnote.domain.Menu;
import teamnote.domain.User;

public class ShowMenuAction extends UserBaseAction
{

	public String execute(String userName) throws Exception
	{
		List<Menu> menus = userService.showMenus(userName);
		if (menus != null)
		{
			for (Menu menu : menus)
			{
				System.out.println(menu.getMenuName());
			}
			return menus.get(0).getMenuName();
		}
		else
		{
			System.out.println("Пе");
			return "error";
		}

	}

}
