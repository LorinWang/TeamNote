package teamnote;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;

import teamnote.action.LoginAction;
import teamnote.dialogs.LoginDialog;
import teamnote.domain.User;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication
{
	public static final String PLUGIN_ID = "TeamNote";

	public static User user = new User();

	

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
		// User user = new User();
		ld.setUser(user);
		String result = null;
		if (ld.open() == IDialogConstants.OK_ID)
		{
			LoginAction loginAction = new LoginAction();

			/*
			 * ShowMenusAction showMenusAction=new ShowMenusAction();
			 * 
			 * UnfoldMenuAction unfoldMenuAction=new UnfoldMenuAction();
			 * 
			 * FoldMenuAction foldMenuAction=new FoldMenuAction();
			 * 
			 * CreateMenuAction createMenuAction=new CreateMenuAction();
			 * 
			 * CreateDocAction createDocAction=new CreateDocAction();
			 * 
			 * OpenDocAction openDocAction=new OpenDocAction();
			 * 
			 * CloseDocAction closeDocAction=new CloseDocAction();
			 * 
			 * EditDocAction editDocAction=new EditDocAction();
			 * 
			 * ModifyDocAction modifyDocAction=new ModifyDocAction();
			 * 
			 * DeleteDocAction deleteDocAction=new DeleteDocAction();
			 * 
			 * DeleteMenuAction deleteMenuAction=new DeleteMenuAction();
			 * 
			 * ModifyMenuAction modifyMenuAction=new ModifyMenuAction();
			 */

			try
			{
				// �û���¼
				result = loginAction.execute(user);

				// ��ʾĿ¼
				// String menuName=showMenusAction.execute(user.getUserName());
				// System.out.println(menuName);

				// չ��Ŀ¼
				// String
				// showDocResult=unfoldMenuAction.execute(user.getUserName(),menuName);
				// System.out.println(showDocResult);
				// �ر�Ŀ¼
				// String
				// foldMenuResultString=foldMenuAction.execute(user.getUserName(),
				// menuName);
				// System.out.println(foldMenuResultString);

				// �½�Ŀ¼
				// System.out.println(createMenuAction.execute(user.getUserName(),
				// "menu123"));
				// �½��ĵ�
				// System.out.println(createDocAction.execute(user.getUserName(),
				// "doc1", "menu123", "content1"));
				// ��ʾ�ĵ�����
				// System.out.println(openDocAction.execute(user.getUserName(),4));
				// �ر��ĵ�����
				// System.out.println(closeDocAction.execute(user.getUserName(),4));
				// �޸��ĵ�����
				// System.out.println(editDocAction.execute(user.getUserName(),
				// 4, "contentabc"));
				// �޸��ĵ�����
				// System.out.println(modifyDocAction.execute(user.getUserName(),
				// 4, "doc4", "rwxrwxrwx", "admin", "group1", "temp"));
				// ɾ���ĵ�
				// System.out.println(deleteDocAction.execute(user.getUserName(),
				// "temp", 4));
				// ɾ��Ŀ¼
				// System.out.println(deleteMenuAction.execute(user.getUserName(),
				// "menu1"));
				// �޸�Ŀ¼����
				// System.out.println(modifyMenuAction.execute(user.getUserName(),
				// "menu1", "menunew1","---------", "a1", null));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		if (result == null)
		{
			MessageDialog.openInformation(null, null, "�û�����������֤ʧ��");
			return false;
		}
		else
		{
			user.setUserName(result);
			return true;
		}

	}
}
