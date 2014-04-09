package teamnote.view.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import teamnote.Application;
import teamnote.action.DeleteDocAction;
import teamnote.navigator.model.ITreeElement;
import teamnote.utils.ImageKeys;

public class DeleteDocViewAction extends Action implements ISelectionListener, IWorkbenchAction
{
	// final���͵ı����ڴ������ʱ��͸�����ʼֵ
	// �����ڹ��췽������͸�������ʼֵ
	private final IWorkbenchWindow window;
	public final static String ID = "deleteDoc";
	private IStructuredSelection selection;
	
	private long docId;
	
	private DeleteDocAction deleteDocAction=new DeleteDocAction();
	
	public DeleteDocViewAction(IWorkbenchWindow window)
	{
		super();
		this.window = window;
		this.setId(ID);
		this.setText("ɾ���ĵ�");
		this.setToolTipText("ɾ���ĵ�");
		this.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, ImageKeys.DELETEDOC));
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
				if (!iTreeElement.isMenu())
				{
					docId=iTreeElement.getId();
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
		MessageBox msgBox = new MessageBox(new Shell(), SWT.YES|SWT.NO|SWT.ICON_QUESTION); 
        msgBox.setText("ɾ���ĵ�"); 
        msgBox.setMessage("ȷ��ɾ���ĵ���"); 
        if(msgBox.open()==SWT.YES){ 
        	try
    		{
    			deleteDocAction.execute(Application.user.getUserName(), docId);
    		}
    		catch (Exception e)
    		{
    			e.printStackTrace();
    		}
        } 		
	}
}
