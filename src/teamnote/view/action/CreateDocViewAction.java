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

public class CreateDocViewAction extends Action implements ISelectionListener, IWorkbenchAction
{
	// final���͵ı����ڴ������ʱ��͸�����ʼֵ
	// �����ڹ��췽������͸�������ʼֵ
	private final IWorkbenchWindow window;
	public final static String ID = "createDoc";
	private IStructuredSelection selection;
	
	private String menuName;
	
	private CreateDocAction createDocAction=new CreateDocAction();

	// ���캯��
	public CreateDocViewAction(IWorkbenchWindow window)
	{
		this.window = window;
		// ���øö�����ID
		this.setId(ID);
		// ָ���˵�����
		this.setText("�½��ʼ�");
		// ���ŵ��˵������ϵ���ʾ��Ϣ
		this.setToolTipText("�½��ʼ�");
		// ���øö�����ʾ��ͼ��
		this.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, ImageKeys.CREATEDOC));
		// ��Ӽ���(�ö���ע�����ѡ������������е�ѡ��ı�ʱ�����selectionChanged()����)
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
		if (selection1 instanceof IStructuredSelection)
		{
			this.selection = (IStructuredSelection) selection1;
			if (selection.size() == 1 && selection.getFirstElement() instanceof ITreeElement)
			{
				ITreeElement iTreeElement = (ITreeElement) selection.getFirstElement();
				if (iTreeElement.isMenu())
				{
					menuName=iTreeElement.getName();
					this.setEnabled(true);
				}
				else
				{
					this.setEnabled(false);
				}
			}
			else
			{
				this.setEnabled(false);
			}
		}
		else
		{
			this.setEnabled(false);
		}
	}

	@Override
	public void run()
	{
		CreateDocDialog createDocDialog=new CreateDocDialog(window.getShell());
		int code = createDocDialog.open();
		if (code == Window.OK)
		{
			try
			{
				createDocAction.execute(Application.user.getUserName(), createDocDialog.getDocNameString(), menuName, createDocDialog.getDocContentString());
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
