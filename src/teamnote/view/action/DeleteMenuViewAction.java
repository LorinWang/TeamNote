package teamnote.view.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import teamnote.Application;
import teamnote.navigator.model.ITreeElement;
import teamnote.utils.ImageKeys;

public class DeleteMenuViewAction extends Action implements ISelectionListener, IWorkbenchAction
{
	// final类型的必须在创建类的时候就给他初始值
	// 或者在构造方法里面就给他赋初始值
	private final IWorkbenchWindow window;
	public final static String ID = "deleteMenu";
	private IStructuredSelection selection;
	
	public DeleteMenuViewAction(IWorkbenchWindow window)
	{
		super();
		this.window = window;
		this.setId(ID);
		this.setText("删除目录");
		this.setToolTipText("删除目录");
		this.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, ImageKeys.DELETEMENU));
		window.getSelectionService().addSelectionListener(this);
	}
	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		
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

}
