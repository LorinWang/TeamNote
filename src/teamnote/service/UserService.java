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
	// 登录失败
	public static final int LOGIN_FAIL = 0;
	// 以普通员工登录
	public static final int LOGIN_USR = 1;
	// 以经理登录
	public static final int LOGIN_ADM = 2;

	// 用户登录
	int validLogin(User user);

	// 显示目录
	List<Menu> showMenus(String userName);

	// 展开目录
	Set<Doc> unfoldMenu(String userName, String menuName);

	// 关闭目录
	int foldMenu(String userName, String menuName);

	// 新建文档
	long createDoc(String userName, String docName, String menuName, String docContent);

	// 删除文档
	int deleteDoc(String userName, long docId);

	// 显示文档内容
	Doc openDoc(String userName, long docId);

	// 关闭文档内容
	int closeDoc(String userName, long docId);

	// 修改文档内容
	int startEditDoc(String userName, long docId);

	int finishEditDoc(String userName, long docId, String docContent);

	int cancelEditDoc(String userName, long docId);

	// 修改文档属性
	int modifyDoc(String userName, long docId, String docNewName, String docP, String docOwnerName, String docGroupName, String docMenuName);
	// 删除文档

	//得到doc
	Doc startModifyDoc(String userName,long docId);
	
	List<Menu> getAllMenus();
	List<User> getAllUsers();
	List<UserGroup> getAllUserGroups();
	
	
}
