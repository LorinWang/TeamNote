package teamnote.action;

public class FinishEditDocAction extends UserBaseAction
{
	public String execute(String userName, long docId, String docContent) throws Exception
	{
		int result = userService.finishEditDoc(userName, docId, docContent);
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
			return "�޸��ĵ��ɹ�";
		}
		else
		{
			return "�޸��ĵ�����ʧ��";
		}
	}
}
