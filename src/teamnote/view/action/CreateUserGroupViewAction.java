package teamnote.view.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import teamnote.Application;
import teamnote.action.CreateDocAction;
import teamnote.dialogs.CreateDocDialog;
import teamnote.navigator.model.ITreeElement;
import teamnote.utils.ImageKeys;

public class CreateUserGroupViewAction extends Action implements ISelectionListener, IWorkbenchAction
{
	// final类型的必须在创建类的时候就给他初始值
	// 或者在构造方法里面就给他赋初始值
	private final IWorkbenchWindow window;
	public final static String ID = "createUserGroup";
	private IStructuredSelection selection;
	
	// 构造函数
	public CreateUserGroupViewAction(IWorkbenchWindow window)
	{
		this.window = window;
		// 设置该动作的ID
		this.setId(ID);
		// 指定菜单名称
		this.setText("新建用户组");
		// 鼠标放到菜单名称上的提示信息
		this.setToolTipText("新建用户组");
		this.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, ImageKeys.CREATEUSERGROUP));
		window.getSelectionService().addSelectionListener(this);
	}

	@Override
	public void dispose()
	{
		window.getSelectionService().removeSelectionListener(this);
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection1)
	{
		this.setEnabled(false);
	}

	@Override
	public void run()
	{
	}

}

