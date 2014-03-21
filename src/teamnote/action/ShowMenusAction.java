package teamnote.action;

import java.util.List;

import teamnote.domain.Menu;

public class ShowMenusAction extends UserBaseAction
{

	public List<Menu> execute(String userName) throws Exception
	{
		List<Menu> menus = userService.showMenus(userName);
		if (menus==null||menus.size()==0)
		{
			return null;
		}
		return menus;

	}

}
