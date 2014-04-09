package teamnote.action;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class DeleteDocAction extends UserBaseAction
{
	public String execute(String userName, long docId) throws Exception
	{
		long result = userService.deleteDoc(userName, docId);
		if (result == -1)
		{
			MessageBox msgBox = new MessageBox(new Shell(), SWT.ICON_ERROR);
			msgBox.setMessage("我勒个去");
			if(msgBox.open()==SWT.YES)
			{
				
			}
			return "用户、目录或文件名不存在";
		}
		if (result == -2)
		{
			return "该用户没有目录或文件的x权限";
		}
		if (result == -3)
		{
			return "该文件正在被修改";
		}
		if (result == 1)
		{
			return "删除文档成功";
		}
		else
		{
			return "删除文档失败";
		}
	}
}