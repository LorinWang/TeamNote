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

public class RefreshUserViewAction extends Action implements ISelectionListener, IWorkbenchAction
{
	private final IWorkbenchWindow window;
	public final static String ID = "refreshUserView";
	private IStructuredSelection selection;
	@Override
	public void dispose()
	{
	}
	
	public RefreshUserViewAction(IWorkbenchWindow window)
	{
		super();
		this.window = window;
		this.setId(ID);
		this.setText("刷新用户组视图");
		this.setToolTipText("刷新用户组视图");
		this.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, ImageKeys.USERGROUP));
		window.getSelectionService().addSelectionListener(this);
	}
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void run()
	{
		super.run();
		System.out.println("abc");
	}

}
