package teamnote.action;

public class EditDocAction extends UserBaseAction
{
	public String execute(String userName,long docId,String docContent) throws Exception
	{
		long result=userService.editDoc(userName, docId, docContent);
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
			return "�޸��ĵ����ݳɹ�";
		}
		else
		{
			return "�޸��ĵ�����ʧ��";
		}
	}
}