package teamnote.action;

public class OpenDocAction extends UserBaseAction
{
	public String execute(String userName,long docId) throws Exception
	{
		String result=userService.openDoc(userName, docId);
		if(result.equals("-1"))
		{
			return "用户或文件名不存在";
		}
		if(result.equals("-2"))
		{
			return "用户不具有该文档的r权限";
		}
		if(result.equals("-3"))
		{
			return "该文档已被用户打开";
		}
		else
		{
			return "文档内容为:"+result;
		}
	}
}