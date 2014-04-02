package teamnote.action;

import teamnote.domain.Doc;

public class FinishModifyDocAction extends UserBaseAction
{
	public String execute(String userName, long docId,String docName,String docOwnerName,String docMenuName,String docGroupName,String docP) throws Exception
	{
		int result = userService.finishModifyDoc(userName, docId,docName,docOwnerName,docMenuName,docGroupName,docP);
		if (result == -1)
		{
			return "�û����ļ�������";
		}
		if (result == -2)
		{
			return "���ĵ�û��д����";
		}
		if (result == -3)
		{
			return "���ĵ����ڱ����˱༭";
		}
		if (result == 1)
		{
			return "SUCCESS";
		}
		else
		{
			return "�޸��ĵ�����ʧ��";
		}
	}
}
