package teamnote.action;

public class CancelEditDocAction extends UserBaseAction
{
	public String execute(String userName,long docId) throws Exception
	{
		int result=userService.cancelEditDoc(userName, docId);
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
