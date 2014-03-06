package teamnote.action;

public class CreateDocAction extends UserBaseAction
{
	public String execute(String userName,String docName,String menuName,String docContent) throws Exception
	{
		long result=userService.createDoc(userName, docName, menuName, docContent);
		if(result==-1)
		{
			return "用户或文件名不存在";
		}
		if(result==-2)
		{
			return "用户不具有该目录的w权限";
		}
		if(result==-3)
		{
			return "该目录下有同名文档";
		}
		else
		{
			return "新建文档id为:"+result;
		}
	}
}
