package teamnote.action;

public class DeleteMenuAction extends AdminBaseAction
{
	public String execute(String userName, String menuName) throws Exception
	{
		int result = adminService.deleteMenu(userName, menuName);
		if (result == -1)
		{
			return "�û������ڻ�Ŀ¼�����ڣ���Ŀ¼ΪtempĿ¼";
		}
		if(result==1)
		{
			return "ɾ��Ŀ¼�ɹ�";
		}
		else
		{
			return "ɾ��Ŀ¼ʧ��";
		}

	}
}
