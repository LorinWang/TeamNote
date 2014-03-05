package teamnote;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import teamnote.action.CreateMenuAction;
import teamnote.action.LoginAction;
import teamnote.action.ShowDocAction;
import teamnote.action.ShowMenuAction;
import teamnote.dialogs.LoginDialog;
import teamnote.domain.User;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.
	 * IApplicationContext)
	 */
	public Object start(IApplicationContext context)
	{
		Display display = PlatformUI.createDisplay();
		try
		{
			if (!preOpen())
			{
				return IApplication.EXIT_OK;
			}
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			if (returnCode == PlatformUI.RETURN_RESTART)
			{
				return IApplication.EXIT_RESTART;
			}
			return IApplication.EXIT_OK;
		}
		finally
		{
			display.dispose();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop()
	{
		if (!PlatformUI.isWorkbenchRunning())
			return;
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable()
		{
			public void run()
			{
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}

	public boolean preOpen()
	{
		LoginDialog ld = new LoginDialog(null);
		User user = new User();
		ld.setUser(user);
		String result = null;
		if (ld.open() == IDialogConstants.OK_ID)
		{
			LoginAction loginAction = new LoginAction();

			ShowMenuAction showMenuAction=new ShowMenuAction();
			
			ShowDocAction showDocAction=new ShowDocAction();
			
			CreateMenuAction createMenuAction=new CreateMenuAction();
			
			try
			{
				result = loginAction.execute(user);
				System.out.println(result);
				String menuName=showMenuAction.execute(user.getUserName());
				System.out.println(menuName);
				String showDocResult=showDocAction.execute(user.getUserName(),menuName);
				System.out.println(showDocResult);
				
				System.out.println(createMenuAction.execute(user.getUserName(), "menu123"));
				
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (result == null)
		{
			MessageDialog.openInformation(null, null, "用户名、密码验证失败");
			return false;
		}
		else
		{
			return true;
		}

	}
}
