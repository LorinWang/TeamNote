package teamnote.service;

import java.util.List;
import java.util.Set;

import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;

public interface UserService
{
	public static final String DEFAULT_DOCP="rwxrw-r--";
	// ��¼ʧ��
	public static final int LOGIN_FAIL = 0;
	// ����ͨԱ����¼
	public static final int LOGIN_USR = 1;
	// �Ծ����¼
	public static final int LOGIN_ADM = 2;

	//�û���¼
	int validLogin(User user);
	
	//��ʾĿ¼	
	List <Menu> showMenus(String userName);
	
	//չ��Ŀ¼
	Set <Doc> unfoldMenu(String userName,String menuName);
	//�ر�Ŀ¼
	int foldMenu(String userName,String menuName);
	//�½��ĵ�
	long createDoc(String userName,String docName,String menuName,String docContent);
	//ɾ���ĵ�
	int deleteDoc(String userName,String menuName,String docName);
	//��ʾ�ĵ�����
	String openDoc(String userName,String docName);
	//�ر��ĵ�����
	int closeDoc(String userName,String docName);
	//�޸��ĵ�����
	int editDoc(String userName,String docName,String docContent);
	//�޸��ĵ�����
	int modifyDoc(String userName,String docName,String docNewName,String docP,String docOwnerName,String docGroupName,String docMenuName);
	
	
}
