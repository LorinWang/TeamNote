package teamnote.action;

import java.util.Set;

import teamnote.domain.Doc;

public class UnfoldMenuAction extends UserBaseAction
{
	public String execute(String userName,String menuName) throws Exception
	{
		Set<Doc> docs = userService.unfoldMenu(userName,menuName);
		if (docs != null)
		{
			for (Doc doc : docs)
			{
				System.out.println(menuName+"目录里的文件有:"+doc.getDocName());

			}
			return "展开目录成功"+menuName;

		}
		return "展开目录失败"+menuName;
	}
}
