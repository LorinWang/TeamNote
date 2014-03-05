package teamnote.action;

import teamnote.domain.User;

public class LoginAction extends UserBaseAction
{
	// ����һ��������ΪԱ����¼�ɹ���Result��
	private final String USR_RESULT = "usr";
	// ����һ��������Ϊ�����¼�ɹ���Result��
	private final String ADM_RESULT = "adm";

	// ��װ�������
	private User user;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	// �����¼�����ʾ��Ϣ
	private String tip;

	// tip���Ե�setter��getter����
	public void setTip(String tip)
	{
		this.tip = tip;
	}

	public String getTip()
	{
		return this.tip;
	}

	// �����û�����
	public String execute(User user) throws Exception
	{
		
		// ����ҵ���߼������������¼����
		int result = userService.validLogin(user);
		// ��¼���Ϊ��ͨԱ��
		if (result == 1)
		{
			setTip("���Ѿ��ɹ���¼ϵͳ");
			return USR_RESULT;
		}
		// ��¼���Ϊ����
		else if (result == 2)
		{
			setTip("���Ѿ��ɹ���¼ϵͳ");
			return ADM_RESULT;
		}
		// �û��������벻ƥ��
		else
		{
			setTip("�û���/���벻ƥ��");
			return null;
		}

	}
}