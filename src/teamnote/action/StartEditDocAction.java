package teamnote.action;

public class StartEditDocAction extends UserBaseAction
{
	public String execute(String userName,long docId) throws Exception
	{
		int result=userService.startEditDoc(userName, docId);
		if(result==-1)
		{
			return "�û����ļ�������";
		}
		if(result==-2)
		{
			return "���ĵ�û��д����";
		}
		if(result==-3)
		{
			return "���ĵ����ڱ��༭";
		}
		if(result==1)
		{
			return "SUCCESS";
		}
		else
		{
			return "�޸��ĵ�����ʧ��";
		}
	}
}
