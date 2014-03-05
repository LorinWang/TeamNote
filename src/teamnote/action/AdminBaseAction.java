package teamnote.action;

import teamnote.service.AdminService;
import teamnote.service.impl.AdminServiceImpl;

public class AdminBaseAction
{
	protected AdminService adminService=new AdminServiceImpl();

	public AdminService getAdminService()
	{
		return adminService;
	}

	public void setAdminService(AdminService adminService)
	{
		this.adminService = adminService;
	}

	

}
