package teamnote.action;

public class CancelModifyDocAction extends UserBaseAction
{
	public String execute(String userName,long docId) throws Exception
	{
		int result=userService.cancelModifyDoc(userName, docId);
		if(result==-1)
		{
			return "�û����ļ���������";
		}
		if(result==1)
		{
			return "SUCCESS";
		}
		return "fail";
	}
}
