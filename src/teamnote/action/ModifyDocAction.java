package teamnote.action;

public class ModifyDocAction extends UserBaseAction
{
	public String execute(String userName, long docId, String docNewName, String docP, String docOwnerName, String docGroupName, String docMenuName) throws Exception
	{
		long result=userService.modifyDoc(userName, docId, docNewName, docP, docOwnerName, docGroupName, docMenuName);
		if(result==-1)
		{
			return "�û����ļ�������";
		}
		if(result==-2)
		{
			return "��Ŀ¼�����������ļ�����ͬ���ļ�";
		}
		if(result==-3)
		{
			return "�û�û���ĵ���xȨ��";
		}
		if(result==-4)
		{
			return "�ĵ��������ڱ������û��޸�";
		}
		if(result==1)
		{
			return "�޸��ĵ����Գɹ�";
		}
		else
		{
			return "�޸��ĵ�����ʧ��";
		}
	}
}
