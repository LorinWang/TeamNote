package teamnote.section;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class docContentSection extends AbstractPropertySection
{
	private Text docText=null;
	private Button editButton=null;
	private Button okButton=null;
	private Button cancelButton=null;

	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		
		editButton=getWidgetFactory().createButton(composite, "编辑", SWT.NONE);
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom=new FormAttachment(0,30);
		editButton.setLayoutData(data);
		
		okButton=getWidgetFactory().createButton(composite, "确定", SWT.NONE);
		data = new FormData();
		data.left = new FormAttachment(21, 0);
		data.right = new FormAttachment(41, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom=new FormAttachment(0,30);
		okButton.setLayoutData(data);
		okButton.setEnabled(false);
		
		cancelButton=getWidgetFactory().createButton(composite, "取消", SWT.NONE);
		data = new FormData();
		data.left = new FormAttachment(42, 0);
		data.right = new FormAttachment(62, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom=new FormAttachment(0,30);
		cancelButton.setLayoutData(data);
		cancelButton.setEnabled(false);
		
		docText=getWidgetFactory().createText(composite, "test text");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 35);
		data.bottom=new FormAttachment(0,100);
		docText.setLayoutData(data);
		docText.setEditable(false);
		docText.setEnabled(false);
		
		
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection)
	{
		super.setInput(part, selection);
		Object test=selection;
		
	}

	@Override
	public void refresh()
	{
		// TODO Auto-generated method stub
		super.refresh();
	}
	
	

	
}
