package teamnote.action;

public class FoldMenuAction extends UserBaseAction
{
	public String execute(String userName,String menuName) throws Exception
	{
		int result=userService.foldMenu(userName, menuName);
		if(result==0)
		{
			return "�û���Ŀ¼������";
		}
		if(result==1)
		{
			return "�û��ѹرո�Ŀ¼";
		}
		if(result==2)
		{
			return "�ر�Ŀ¼�ɹ�";
		}
		else
		{
			return "�ر�Ŀ¼ʧ��";
		}
	}

}
