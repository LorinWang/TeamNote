package teamnote.action;

public class StartEditDocAction extends UserBaseAction
{
	public String execute(String userName,long docId) throws Exception
	{
		int result=userService.startEditDoc(userName, docId);
		if(result==-1)
		{
			return "用户或文件不存在";
		}
		if(result==-2)
		{
			return "该文档没有写操作";
		}
		if(result==-3)
		{
			return "该文档正在被编辑";
		}
		if(result==1)
		{
			return "SUCCESS";
		}
		else
		{
			return "修改文档内容失败";
		}
	}
}
