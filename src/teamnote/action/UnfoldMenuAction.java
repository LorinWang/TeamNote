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
				System.out.println(menuName+"Ŀ¼����ļ���:"+doc.getDocName());

			}
			return "չ��Ŀ¼�ɹ�"+menuName;

		}
		return "չ��Ŀ¼ʧ��"+menuName;
	}
}
