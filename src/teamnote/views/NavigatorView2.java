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
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import teamnote.Application;
import teamnote.navigator.model.NavigatorEntityElement;
import teamnote.navigator.model.NavigatorEntityFactory;
import teamnote.navigator.model.TreeViewerContentProvider;
import teamnote.navigator.model.TreeViewerLabelProvider;

public class NavigatorView2 extends ViewPart implements ITabbedPropertySheetPageContributor
{
	private TreeViewer tv;
	private DrillDownAdapter drillDownAdapter;

	@Override
	public void createPartControl(Composite parent)
	{
		tv = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		tv.setContentProvider(new TreeViewerContentProvider());
		tv.setLabelProvider(new TreeViewerLabelProvider());
		tv.setInput(NavigatorEntityFactory.TreeEntityElement(Application.user));
		// fillViewToolBarAction();
		// fillViewToolBarContextMenu();
		hookDoubleClickAction();
		getSite().setSelectionProvider(tv);
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

	// Ö§³Ötabbed property view
	@Override
	public String getContributorId()
	{
		return "teamnote.contributor";
	}

	@Override
	public Object getAdapter(Class adapter)
	{
		if (adapter == IPropertySheetPage.class)
			return new TabbedPropertySheetPage(this);
		return super.getAdapter(adapter);
	}
}
