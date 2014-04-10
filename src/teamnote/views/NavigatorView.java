package teamnote.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import teamnote.Application;
import teamnote.navigator.model.NavigatorEntityFactory;
import teamnote.navigator.model.TreeViewerContentProvider;
import teamnote.navigator.model.TreeViewerLabelProvider;

public class NavigatorView extends ViewPart implements ITabbedPropertySheetPageContributor
{
	public static TreeViewer tv;

	@Override
	public void createPartControl(Composite parent)
	{
		tv = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		//�������������ṩ��
		tv.setContentProvider(new TreeViewerContentProvider());
		//���ñ�ǩ�ṩ��
		tv.setLabelProvider(new TreeViewerLabelProvider());
		
		tv.setInput(NavigatorEntityFactory.TreeEntityElement(Application.user));
		// ������
		tv.refresh();
		//�⽫��treeViwer��NavigatorView�����ͼע��Ϊѡ���ṩ����
		this.getSite().setSelectionProvider(tv);
	}

	@Override
	public void setFocus()
	{
		tv.getControl().setFocus();
	}

	// ֧��tabbed property view
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
	
	public static void refresh()
	{
		//�������������ṩ��
		tv.setContentProvider(new TreeViewerContentProvider());
		//���ñ�ǩ�ṩ��
		tv.setLabelProvider(new TreeViewerLabelProvider());
		
		tv.setInput(NavigatorEntityFactory.TreeEntityElement(Application.user));
		// ������
		tv.refresh();
	}
}
