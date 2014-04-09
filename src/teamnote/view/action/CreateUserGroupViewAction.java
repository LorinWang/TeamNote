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
	// final���͵ı����ڴ������ʱ��͸�����ʼֵ
	// �����ڹ��췽������͸�������ʼֵ
	private final IWorkbenchWindow window;
	public final static String ID = "createUserGroup";
	private IStructuredSelection selection;
	
	// ���캯��
	public CreateUserGroupViewAction(IWorkbenchWindow window)
	{
		this.window = window;
		// ���øö�����ID
		this.setId(ID);
		// ָ���˵�����
		this.setText("�½��û���");
		// ���ŵ��˵������ϵ���ʾ��Ϣ
		this.setToolTipText("�½��û���");
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
