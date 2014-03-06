package teamnote.action;

public class CloseDocAction extends UserBaseAction
{
	public String execute(String userName,long docId) throws Exception
	{
		long result=userService.closeDoc(userName, docId);
		if(result==-1)
		{
			return "用户或文件名不存在";
		}
		if(result==-2)
		{
			return "该文档未被打开";
		}
		if(result==1)
		{
			return "关闭文档成功";
		}
		else
		{
			return "关闭文档失败";
		}
	}
}