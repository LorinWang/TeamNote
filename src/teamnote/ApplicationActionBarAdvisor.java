package teamnote;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import teamnote.view.action.CreateDocViewAction;
import teamnote.view.action.CreateMenuViewAction;
import teamnote.view.action.CreateUserGroupViewAction;
import teamnote.view.action.CreateUserViewAction;
import teamnote.view.action.DeleteDocViewAction;
import teamnote.view.action.DeleteMenuViewAction;
import teamnote.view.action.DeleteUserGroupViewAction;
import teamnote.view.action.DeleteUserViewAction;
import teamnote.view.action.InUserGroupViewAction;
import teamnote.view.action.OutUserGroupViewAction;
import teamnote.view.action.RefreshDocViewAction;
import teamnote.view.action.RefreshUserViewAction;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor
{
	private static IWorkbenchAction createMenuViewAction;
	private static IWorkbenchAction deleteMenuViewAction;

	private static IWorkbenchAction createDocViewAction;
	private static IWorkbenchAction deleteDocViewAction;

	private static IWorkbenchAction createUserViewAction;
	private static IWorkbenchAction deleteUserViewAction;

	private static IWorkbenchAction createUserGroupViewAction;
	private static IWorkbenchAction deleteUserGroupViewAction;
	
	private static IWorkbenchAction inUserGroupViewAction;
	private static IWorkbenchAction outUserGroupViewAction;

	private static IWorkbenchAction refreshDocViewAction;
	private static IWorkbenchAction refreshUserViewAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer)
	{
		super(configurer);
	}

	// ��Ӷ���
	@Override
	protected void makeActions(IWorkbenchWindow window)
	{
		super.makeActions(window);
		createMenuViewAction = new CreateMenuViewAction(window);
		register(createMenuViewAction);
		deleteMenuViewAction = new DeleteMenuViewAction(window);
		register(deleteMenuViewAction);

		createDocViewAction = new CreateDocViewAction(window);
		register(createDocViewAction);
		deleteDocViewAction = new DeleteDocViewAction(window);
		register(deleteDocViewAction);

		createUserViewAction = new CreateUserViewAction(window);
		register(createUserViewAction);
		deleteUserViewAction = new DeleteUserViewAction(window);
		register(deleteUserViewAction);

		createUserGroupViewAction = new CreateUserGroupViewAction(window);
		register(createUserGroupViewAction);
		deleteUserGroupViewAction = new DeleteUserGroupViewAction(window);
		register(deleteUserGroupViewAction);
		
		inUserGroupViewAction = new InUserGroupViewAction(window);
		register(inUserGroupViewAction);
		outUserGroupViewAction = new OutUserGroupViewAction(window);
		register(outUserGroupViewAction);

		refreshDocViewAction = new RefreshDocViewAction(window);
		register(refreshDocViewAction);
		refreshUserViewAction = new RefreshUserViewAction(window);
		register(refreshUserViewAction);
	}

	// ��������ӵ��˵���
	@Override
	protected void fillMenuBar(IMenuManager menuBar)
	{
		super.fillMenuBar(menuBar);
		// �����˵�
		MenuManager menuManager = new MenuManager("Ŀ¼/�ĵ�����", "Ŀ¼/�ĵ�����");
		MenuManager menuManager1 = new MenuManager("�û���/�û�����", "�û���/�û�����");
		MenuManager menuManager2 = new MenuManager("��ͼ����", "��ͼ����");
		// �ڲ˵�������Ӳ���
		menuManager.add(createMenuViewAction);
		menuManager.add(deleteMenuViewAction);
		menuManager.add(new Separator());
		menuManager.add(createDocViewAction);
		menuManager.add(deleteDocViewAction);
		menuManager1.add(new Separator());
		menuManager1.add(createUserViewAction);
		menuManager1.add(deleteUserViewAction);
		menuManager1.add(new Separator());
		menuManager1.add(createUserGroupViewAction);
		menuManager1.add(deleteUserGroupViewAction);
		menuManager1.add(new Separator());
		menuManager1.add(inUserGroupViewAction);
		menuManager1.add(outUserGroupViewAction);
		menuManager1.add(new Separator());
		menuManager2.add(refreshDocViewAction);
		menuManager2.add(refreshUserViewAction);

		// ���˵���ӽ��ͻ���ҳ��
		menuBar.add(menuManager);
		menuBar.add(menuManager1);
		menuBar.add(menuManager2);
	}

	// ��������ӵ������
	@Override
	protected void fillCoolBar(ICoolBarManager coolBar)
	{
		IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
		coolBar.add(toolbar);
		toolbar.add(createMenuViewAction);
		toolbar.add(deleteMenuViewAction);
		toolbar.add(createDocViewAction);
		toolbar.add(deleteDocViewAction);
		toolbar.add(new Separator());
		toolbar.add(createUserViewAction);
		toolbar.add(deleteUserViewAction);
		toolbar.add(createUserGroupViewAction);
		toolbar.add(deleteUserGroupViewAction);
		toolbar.add(new Separator());
		toolbar.add(inUserGroupViewAction);
		toolbar.add(outUserGroupViewAction);
		toolbar.add(new Separator());
		toolbar.add(refreshDocViewAction);
		toolbar.add(refreshUserViewAction);
	}
}
