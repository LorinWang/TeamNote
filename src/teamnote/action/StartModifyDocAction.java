package teamnote.action;

public class StartModifyDocAction extends UserBaseAction
{
	public String execute(String userName,long docId) throws Exception
	{
		int result=userService.startModifyDoc(userName, docId);
		if(result==-1)
		{
			return "�û����ļ�������";
		}
		if(result==-2)
		{
			return "���û�û���޸�Ȩ��";
		}
		if(result==-3)
		{
			return "���ĵ��������ڱ��༭";
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
