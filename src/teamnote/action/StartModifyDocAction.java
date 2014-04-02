package teamnote.action;

public class StartModifyDocAction extends UserBaseAction
{
	public String execute(String userName,long docId) throws Exception
	{
		int result=userService.startModifyDoc(userName, docId);
		if(result==-1)
		{
			return "用户或文件不存在";
		}
		if(result==-2)
		{
			return "该用户没有修改权限";
		}
		if(result==-3)
		{
			return "该文档属性正在被编辑";
		}
		if(result==1)
		{
			return "SUCCESS";
		}
		else
		{
			return "修改文档属性失败";
		}
	}

}
