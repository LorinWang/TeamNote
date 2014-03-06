package teamnote;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import teamnote.action.CloseDocAction;
import teamnote.action.CreateDocAction;
import teamnote.action.CreateMenuAction;
import teamnote.action.DeleteDocAction;
import teamnote.action.EditDocAction;
import teamnote.action.FoldMenuAction;
import teamnote.action.LoginAction;
import teamnote.action.ModifyDocAction;
import teamnote.action.UnfoldMenuAction;
import teamnote.action.ShowMenusAction;
import teamnote.action.OpenDocAction;
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

			ShowMenusAction showMenusAction=new ShowMenusAction();
			
			UnfoldMenuAction unfoldMenuAction=new UnfoldMenuAction();
			
			FoldMenuAction foldMenuAction=new FoldMenuAction();
			
			CreateMenuAction createMenuAction=new CreateMenuAction();
			
			CreateDocAction createDocAction=new CreateDocAction();
			
			OpenDocAction openDocAction=new OpenDocAction();
			
			CloseDocAction closeDocAction=new CloseDocAction();
			
			EditDocAction editDocAction=new EditDocAction();
			
			ModifyDocAction modifyDocAction=new ModifyDocAction();
			
			DeleteDocAction deleteDocAction=new DeleteDocAction();
			try
			{
				//用户登录
				result = loginAction.execute(user);
				System.out.println(result);
				//显示目录
				//String menuName=showMenusAction.execute(user.getUserName());
				//System.out.println(menuName);
				
				//展开目录
				//String showDocResult=unfoldMenuAction.execute(user.getUserName(),menuName);
				//System.out.println(showDocResult);
				//关闭目录
				//String foldMenuResultString=foldMenuAction.execute(user.getUserName(), menuName);
				//System.out.println(foldMenuResultString);
				
				//新建目录
				//System.out.println(createMenuAction.execute(user.getUserName(), "menu123"));
				//新建文档
				//System.out.println(createDocAction.execute(user.getUserName(), "doc1", "menu123", "content1"));
				//显示文档内容
				//System.out.println(openDocAction.execute(user.getUserName(),4));
				//关闭文档内容
				//System.out.println(closeDocAction.execute(user.getUserName(),4));
				//修改文档内容
				//System.out.println(editDocAction.execute(user.getUserName(), 4, "contentabc"));
				//修改文档属性
				//System.out.println(modifyDocAction.execute(user.getUserName(), 4, "doc4", "rwxrwxrwx", "admin", "group1", "temp"));
				//删除文档
				//System.out.println(deleteDocAction.execute(user.getUserName(), "temp", 4));
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
