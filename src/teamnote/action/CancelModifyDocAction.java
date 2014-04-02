package teamnote.action;

public class CancelModifyDocAction extends UserBaseAction
{
	public String execute(String userName,long docId) throws Exception
	{
		int result=userService.cancelModifyDoc(userName, docId);
		if(result==-1)
		{
			return "用户或文件名不存在";
		}
		if(result==1)
		{
			return "SUCCESS";
		}
		return "fail";
	}
}
