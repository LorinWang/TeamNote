package teamnote.action;

import teamnote.domain.Doc;

public class FinishModifyDocAction extends UserBaseAction
{
	public String execute(String userName, long docId,String docName,String docOwnerName,String docMenuName,String docGroupName,String docP) throws Exception
	{
		int result = userService.finishModifyDoc(userName, docId,docName,docOwnerName,docMenuName,docGroupName,docP);
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
			return "SUCCESS";
		}
		else
		{
			return "修改文档内容失败";
		}
	}
}
