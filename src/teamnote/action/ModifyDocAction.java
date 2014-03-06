package teamnote.action;

public class ModifyDocAction extends UserBaseAction
{
	public String execute(String userName, long docId, String docNewName, String docP, String docOwnerName, String docGroupName, String docMenuName) throws Exception
	{
		long result=userService.modifyDoc(userName, docId, docNewName, docP, docOwnerName, docGroupName, docMenuName);
		if(result==-1)
		{
			return "用户或文件不存在";
		}
		if(result==-2)
		{
			return "该目录下已有与新文件名相同的文件";
		}
		if(result==-3)
		{
			return "用户没有文档的x权限";
		}
		if(result==-4)
		{
			return "文档属性正在被其他用户修改";
		}
		if(result==1)
		{
			return "修改文档属性成功";
		}
		else
		{
			return "修改文档属性失败";
		}
	}
}
