package teamnote.service;

import java.util.List;
import java.util.Set;

import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;

public interface UserService
{
	public static final String DEFAULT_DOCP = "rwxrw-r--";
	// ��¼ʧ��
	public static final int LOGIN_FAIL = 0;
	// ����ͨԱ����¼
	public static final int LOGIN_USR = 1;
	// �Ծ����¼
	public static final int LOGIN_ADM = 2;

	// �û���¼
	int validLogin(User user);

	// ��ʾĿ¼
	List<Menu> showMenus(String userName);

	// չ��Ŀ¼
	Set<Doc> unfoldMenu(String userName, String menuName);

	// �ر�Ŀ¼
	int foldMenu(String userName, String menuName);

	// �½��ĵ�
	long createDoc(String userName, String docName, String menuName, String docContent);

	// ɾ���ĵ�
	int deleteDoc(String userName, long docId);

	// ��ʾ�ĵ�����
	Doc openDoc(String userName, long docId);

	// �ر��ĵ�����
	int closeDoc(String userName, long docId);

	// �޸��ĵ�����
	int startEditDoc(String userName, long docId);

	int finishEditDoc(String userName, long docId, String docContent);

	int cancelEditDoc(String userName, long docId);

	// �޸��ĵ�����
	int modifyDoc(String userName, long docId, String docNewName, String docP, String docOwnerName, String docGroupName, String docMenuName);
	// ɾ���ĵ�

	//�õ�doc
	Doc startModifyDoc(String userName,long docId);
	
	List<Menu> getAllMenus();
	List<User> getAllUsers();
	List<UserGroup> getAllUserGroups();
	
	
}
