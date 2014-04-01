package teamnote.action;

import teamnote.domain.Doc;

public class OpenDocAction extends UserBaseAction
{
	public Doc execute(String userName,long docId) throws Exception
	{
		Doc doc=null;
		doc=userService.openDoc(userName, docId);
		if(doc!=null)
		{
			return doc;
		}
		else
		{
			System.out.println("read doc fail");
			return null;
		}
	}
}