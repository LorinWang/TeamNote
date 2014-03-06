package teamnote.action;

public class DeleteDocAction extends UserBaseAction
{
	public String execute(String userName,String menuName,long docId) throws Exception
	{
		long result=userService.deleteDoc(userName, menuName, docId);
		if(result==-1)
		{
			return "�û���Ŀ¼���ļ���������";
		}
		if(result==-2)
		{
			return "���û�û��Ŀ¼���ļ���xȨ��";
		}
		if(result==-3)
		{
			return "���ļ����ڱ��޸�";
		}
		if(result==1)
		{
			return "ɾ���ĵ��ɹ�";
		}
		else
		{
			return "ɾ���ĵ�ʧ��";
		}
	}
}