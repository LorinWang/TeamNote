package teamnote.section;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import teamnote.Application;
import teamnote.action.CancelEditDocAction;
import teamnote.action.CloseDocAction;
import teamnote.action.FinishEditDocAction;
import teamnote.action.OpenDocAction;
import teamnote.action.StartEditDocAction;
import teamnote.domain.Doc;
import teamnote.navigator.model.ITreeElement;

public class docContentSection extends AbstractPropertySection
{
	private Doc doc=null;
	
	private Text docText = null;
	private Button editButton = null;
	private Button okButton = null;
	private Button cancelButton = null;

	private ITreeElement iTreeElement = null;
	private Long docId = null;
	private String docContent = null;
	private String lastDocContent = null;
	private String result = null;

	private ISelection lastSelection = null;

	private OpenDocAction openDocAction = new OpenDocAction();
	private CloseDocAction closeDocAction = new CloseDocAction();

	private StartEditDocAction startEditDocAction = new StartEditDocAction();
	private FinishEditDocAction finishEditDocAction = new FinishEditDocAction();
	private CancelEditDocAction cancelEditDocAction = new CancelEditDocAction();
	
	private SelectionAdapter editButtonAdapter = new SelectionAdapter()
	{
		public void widgetSelected(SelectionEvent e)
		{
			try
			{
				result = startEditDocAction.execute(Application.user.getUserName(), docId);
				if (result.equals("SUCCESS"))
				{
					lastDocContent = docText.getText();
					editButton.setEnabled(false);
					docText.setEnabled(true);
					docText.setEditable(true);
					okButton.setEnabled(true);
					cancelButton.setEnabled(true);
				}
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	};

	private SelectionAdapter okButtonAdapter = new SelectionAdapter()
	{
		public void widgetSelected(SelectionEvent e)
		{
			try
			{
				result = finishEditDocAction.execute(Application.user.getUserName(), docId, docText.getText());
				if (result.equals("SUCCESS"))
				{
					editButton.setEnabled(true);
					docText.setEnabled(false);
					docText.setEditable(false);
					okButton.setEnabled(false);
					cancelButton.setEnabled(false);
				}
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	};

	private SelectionAdapter cancelButtonAdapter = new SelectionAdapter()
	{
		public void widgetSelected(SelectionEvent e)
		{
			try
			{
				result = cancelEditDocAction.execute(Application.user.getUserName(), docId);
				if (result.equals("SUCCESS"))
				{
					docText.setText(lastDocContent);
					editButton.setEnabled(true);
					docText.setEnabled(false);
					docText.setEditable(false);
					okButton.setEnabled(false);
					cancelButton.setEnabled(false);
				}
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}

		}
	};
	
	

	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		
		editButton = getWidgetFactory().createButton(composite, "编辑", SWT.NONE);
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(0, 30);
		editButton.setLayoutData(data);
		editButton.addSelectionListener(editButtonAdapter);

		okButton = getWidgetFactory().createButton(composite, "确定", SWT.NONE);
		data = new FormData();
		data.left = new FormAttachment(21, 0);
		data.right = new FormAttachment(41, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(0, 30);
		okButton.setLayoutData(data);
		okButton.setEnabled(false);
		okButton.addSelectionListener(okButtonAdapter);

		cancelButton = getWidgetFactory().createButton(composite, "取消", SWT.NONE);
		data = new FormData();
		data.left = new FormAttachment(42, 0);
		data.right = new FormAttachment(62, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(0, 30);
		cancelButton.setLayoutData(data);
		cancelButton.setEnabled(false);
		cancelButton.addSelectionListener(cancelButtonAdapter);


		docText = getWidgetFactory().createText(composite, "test text", SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 35);
		//data.bottom=new FormAttachment(100, 0);
		data.bottom = new FormAttachment(cancelButton, 500,SWT.BOTTOM);
		docText.setLayoutData(data);
		docText.setEditable(false);
		docText.setEnabled(false);

	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection)
	{
		super.setInput(part, selection);
		showDoc(selection);
	}

	@Override
	public void refresh()
	{
	}

	private void showDoc(ISelection selection)
	{
		if (lastSelection == null || lastSelection != selection)
		{
			if (lastSelection == null)
			{
				lastSelection = selection;
				iTreeElement = (ITreeElement) ((IStructuredSelection) selection).getFirstElement();
				docId = iTreeElement.getId();

				try
				{
					doc=openDocAction.execute(Application.user.getUserName(), docId);
					docContent = doc.getDocContent();
					docText.setText(docContent);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			if (lastSelection != selection)
			{
				iTreeElement = (ITreeElement) ((IStructuredSelection) lastSelection).getFirstElement();
				if (iTreeElement.isMenu() == false)
				{
					docId = iTreeElement.getId();
					lastSelection = selection;
					try
					{
						closeDocAction.execute(Application.user.getUserName(), docId);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
				iTreeElement = (ITreeElement) ((IStructuredSelection) selection).getFirstElement();
				docId = iTreeElement.getId();
				try
				{
					doc=openDocAction.execute(Application.user.getUserName(), docId);
					docContent = doc.getDocContent();
					docText.setText(docContent);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
