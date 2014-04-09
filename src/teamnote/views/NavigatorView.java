package teamnote.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
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
import teamnote.view.action.CreateMenuViewAction;

public class NavigatorView extends ViewPart implements ITabbedPropertySheetPageContributor
{
	public static TreeViewer tv;
	
	public static void refresh()
	{
	//设置树的内容提供器
			tv.setContentProvider(new TreeViewerContentProvider());
			//设置标签提供器
			tv.setLabelProvider(new TreeViewerLabelProvider());
			
			tv.setInput(NavigatorEntityFactory.TreeEntityElement(Application.user));
			// 标题栏
			// fillViewToolBarAction();
			// fillViewToolBarContextMenu();
			tv.refresh();
			
			
	}

	@Override
	public void createPartControl(Composite parent)
	{
		tv = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		//设置树的内容提供器
		tv.setContentProvider(new TreeViewerContentProvider());
		//设置标签提供器
		tv.setLabelProvider(new TreeViewerLabelProvider());
		
		tv.setInput(NavigatorEntityFactory.TreeEntityElement(Application.user));
		// 标题栏
		// fillViewToolBarAction();
		// fillViewToolBarContextMenu();
		tv.refresh();
		fillTreeViewContextMenu();

		hookDoubleClickAction();
		//这将把treeViwer即NavigatorView这个视图注册为选择提供程序
		this.getSite().setSelectionProvider(tv);
	}

	private void fillTreeViewContextMenu()
	{
		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(tv.getControl());
		System.out.println(tv.getControl());
		tv.getControl().setMenu(menu);
		//menuManager.add(new CreateMenuViewAction());
		// drillDownAdapter.addNavigationActions(menuManager);

	}

	private void fillViewToolBarContextMenu()
	{
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager toolBarMenu = bars.getMenuManager();
		//toolBarMenu.add(new CreateMenuViewAction());
	//	drillDownAdapter.addNavigationActions(toolBarMenu);
	}

	private void fillViewToolBarAction()
	{
		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager toolBar = bars.getToolBarManager();
		//drillDownAdapter = new DrillDownAdapter(tv);
		//drillDownAdapter.addNavigationActions(toolBar);
		toolBar.add(new Separator());
		//toolBar.add(new CreateMenuViewAction());
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
		tv.getControl().setFocus();
	}

	// 支持tabbed property view
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
