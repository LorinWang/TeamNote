package teamnote.views;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

import teamnote.navigator.model.NavigatorEntityElement;
import teamnote.navigator.model.NavigatorEntityFactory;
import teamnote.navigator.model.TreeViewerContentProvider;
import teamnote.navigator.model.TreeViewerLabelProvider;

public class NavigatorView extends ViewPart
{
	private TreeViewer tv;
	private DrillDownAdapter drillDownAdapter;

	@Override
	public void createPartControl(Composite parent)
	{
		tv = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		tv.setContentProvider(new TreeViewerContentProvider());
		tv.setLabelProvider(new TreeViewerLabelProvider());
		tv.setInput(NavigatorEntityFactory.TreeEntityElement());
		// fillViewToolBarAction();
		// fillViewToolBarContextMenu();
		hookDoubleClickAction();
	}

	private void hookDoubleClickAction()
	{
		tv.addDoubleClickListener(new IDoubleClickListener()
		{

			@Override
			public void doubleClick(DoubleClickEvent event)
			{
				String editorId = null;
				ISelection selection = tv.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				NavigatorEntityElement object = (NavigatorEntityElement) obj;
				IEditorInput editorInput = object.getEditorInput();
				IWorkbenchPage workbenchPage = getViewSite().getPage();

				{
					editorId = "TeamNote.Editors.DocEditor";
					IEditorPart editor = workbenchPage.findEditor(editorInput);
					if (editor != null)
					{
						workbenchPage.bringToTop(editor);
					}
					else
					{
						try
						{
							editor = workbenchPage.openEditor(editorInput, editorId);
						}
						catch (Exception ex)
						{
							System.out.println(ex);
						}
					}
				}
			}

		});
	}

	@Override
	public void setFocus()
	{
		// TODO Auto-generated method stub

	}

}
