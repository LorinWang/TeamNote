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
			msgBox.setMessage("���ո�ȥ");
			if(msgBox.open()==SWT.YES)
			{
				
			}
			return "�û���Ŀ¼���ļ���������";
		}
		if (result == -2)
		{
			return "���û�û��Ŀ¼���ļ���xȨ��";
		}
		if (result == -3)
		{
			return "���ļ����ڱ��޸�";
		}
		if (result == 1)
		{
			return "ɾ���ĵ��ɹ�";
		}
		else
		{
			return "ɾ���ĵ�ʧ��";
		}
	}
}