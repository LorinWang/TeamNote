package teamnote.action;

import java.util.Set;

import teamnote.domain.Doc;

public class UnfoldMenuAction extends UserBaseAction
{
	public Set<Doc> execute(String userName,String menuName) throws Exception
	{
		Set<Doc> docs = userService.unfoldMenu(userName,menuName);
		if (docs != null)
		{
			return docs;

		}
		return null;
	}
}
