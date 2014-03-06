package teamnote.action;

public class CloseDocAction extends UserBaseAction
{
	public String execute(String userName,long docId) throws Exception
	{
		long result=userService.closeDoc(userName, docId);
		if(result==-1)
		{
			return "�û����ļ���������";
		}
		if(result==-2)
		{
			return "���ĵ�δ����";
		}
		if(result==1)
		{
			return "�ر��ĵ��ɹ�";
		}
		else
		{
			return "�ر��ĵ�ʧ��";
		}
	}
}