package teamnote.view.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import teamnote.Application;
import teamnote.utils.ImageKeys;

public class DeleteUserViewAction extends Action implements ISelectionListener, IWorkbenchAction
{
	// final���͵ı����ڴ������ʱ��͸�����ʼֵ
	// �����ڹ��췽������͸�������ʼֵ
	private final IWorkbenchWindow window;
	public final static String ID = "deleteUser";
	private IStructuredSelection selection;
	
	// ���캯��
	public DeleteUserViewAction(IWorkbenchWindow window)
	{
		this.window = window;
		// ���øö�����ID
		this.setId(ID);
		// ָ���˵�����
		this.setText("ɾ���û�");
		// ���ŵ��˵������ϵ���ʾ��Ϣ
		this.setToolTipText("ɾ���û�");
		this.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, ImageKeys.DELETEUSER));
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
