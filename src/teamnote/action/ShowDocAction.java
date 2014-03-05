package teamnote.action;

import java.util.Set;

import teamnote.domain.Doc;

public class ShowDocAction extends UserBaseAction
{
	public String execute(String userName,String menuName) throws Exception
	{
		Set<Doc> docs = userService.unfoldMenu(userName,menuName);
		if (docs != null)
		{
			for (Doc doc : docs)
			{
				System.out.println(doc.getDocName());

			}
			return "show docs ok";

		}
		return "show docs error";
	}
}
