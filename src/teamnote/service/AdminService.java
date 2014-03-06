package teamnote.service;

public interface AdminService
{
	long createMenu(String userName, String menuName);

	int deleteMenu(String userName, String menuName);

	int modifyMenu(String userName, String menuName, String menuNewName, String menuP, String menuOwnerName, String menuGroupName);
}
