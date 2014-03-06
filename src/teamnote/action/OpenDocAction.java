package teamnote.action;

public class OpenDocAction extends UserBaseAction
{
	public String execute(String userName,long docId) throws Exception
	{
		String result=userService.openDoc(userName, docId);
		if(result.equals("-1"))
		{
			return "�û����ļ���������";
		}
		if(result.equals("-2"))
		{
			return "�û������и��ĵ���rȨ��";
		}
		if(result.equals("-3"))
		{
			return "���ĵ��ѱ��û���";
		}
		else
		{
			return "�ĵ�����Ϊ:"+result;
		}
	}
}