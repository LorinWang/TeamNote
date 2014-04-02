package teamnote.action;

public class FinishEditDocAction extends UserBaseAction
{
	public String execute(String userName, long docId, String docContent) throws Exception
	{
		int result = userService.finishEditDoc(userName, docId, docContent);
		if (result == -1)
		{
			return "用户或文件不存在";
		}
		if (result == -2)
		{
			return "该文档没有写操作";
		}
		if (result == -3)
		{
			return "该文档正在被他人编辑";
		}
		if (result == 1)
		{
			return "修改文档成功";
		}
		else
		{
			return "修改文档内容失败";
		}
	}
}
