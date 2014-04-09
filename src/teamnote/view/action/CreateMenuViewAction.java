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

public class CreateMenuViewAction extends Action implements ISelectionListener, IWorkbenchAction
{
	private final IWorkbenchWindow window;
	public final static String ID = "createMenu";
	private IStructuredSelection selection;
	
	
	public CreateMenuViewAction(IWorkbenchWindow window)
	{
		super();
		this.window = window;
		this.setId(ID);
		this.setText("新建目录");
		this.setToolTipText("新建目录");
		this.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, ImageKeys.CREATEMENU));
		
		window.getSelectionService().addSelectionListener(this);
	}

	@Override
	public void dispose()
	{
		window.getSelectionService().removeSelectionListener(this);
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection)
	{
		if(selection instanceof IStructuredSelection){
			this.setEnabled(true);
		}
	}

	@Override
	public void run()
	{
		super.run();
		System.out.println("abc");
	}

}
