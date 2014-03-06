package teamnote.action;

public class CreateMenuAction extends AdminBaseAction
{
	public String execute(String userName, String menuName) throws Exception
	{
		Long menuId = adminService.createMenu(userName, menuName);
		if (menuId == -1)
		{
			return "�û������ڻ��Ѵ���ͬ��Ŀ¼";
		}
		return "�½�Ŀ¼�ɹ���Ŀ¼IDΪ:" + menuId.toString();

	}
}
