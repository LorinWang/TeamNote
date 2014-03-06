package teamnote.action;

public class ModifyMenuAction extends AdminBaseAction
{
	public String execute(String userName, String menuName, String menuNewName, String menuP, String menuOwnerName, String menuGroupName) throws Exception
	{
		int result = adminService.modifyMenu(userName, menuName, menuNewName, menuP, menuOwnerName, menuGroupName);
		if (result == -1)
		{
			return "�û������ڻ�Ŀ¼�����ڣ���Ŀ¼ΪtempĿ¼";
		}
		if(result==-2)
		{
			return "�Ѵ�������Ŀ¼����ͬ���ļ�";
		}
		if(result==-3)
		{
			return "��Ŀ¼���ڱ��޸�";
		}
		if(result==-4)
		{
			return "�û����߱��޸�Ŀ¼��Ȩ��";
		}
		if(result==1)
		{
			return "�޸�Ŀ¼�ɹ�";
		}
		else
		{
			return "�޸�Ŀ¼ʧ��";
		}

	}
}

