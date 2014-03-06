package teamnote.action;

public class CreateDocAction extends UserBaseAction
{
	public String execute(String userName,String docName,String menuName,String docContent) throws Exception
	{
		long result=userService.createDoc(userName, docName, menuName, docContent);
		if(result==-1)
		{
			return "�û����ļ���������";
		}
		if(result==-2)
		{
			return "�û������и�Ŀ¼��wȨ��";
		}
		if(result==-3)
		{
			return "��Ŀ¼����ͬ���ĵ�";
		}
		else
		{
			return "�½��ĵ�idΪ:"+result;
		}
	}
}
