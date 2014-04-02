package teamnote.section;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import teamnote.Application;
import teamnote.action.CancelModifyDocAction;
import teamnote.action.CloseDocAction;
import teamnote.action.FinishModifyDocAction;
import teamnote.action.GetAllMenusAction;
import teamnote.action.GetAllUserGroupsAction;
import teamnote.action.GetAllUsersAction;
import teamnote.action.OpenDocAction;
import teamnote.action.StartModifyDocAction;
import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;
import teamnote.navigator.model.ITreeElement;

public class docPropertySection extends AbstractPropertySection
{
	private Doc doc = null;

	private Label docNameLabel = null;
	private Text docNameText = null;

	private Label docMenuLabel = null;
	private CCombo docMenuCombo = null;

	private Label docOwnerLabel = null;
	private CCombo docOwnerCombo = null;

	private Label docGroupLabel = null;
	private CCombo docGroupCombo = null;

	private Label docOwnerPLabel = null;
	private Button docOwnerPButtonR = null;
	private Button docOwnerPButtonW = null;
	private Button docOwnerPButtonX = null;

	private Label docGroupPLabel = null;
	private Button docGroupPButtonR = null;
	private Button docGroupPButtonW = null;
	private Button docGroupPButtonX = null;

	private Label docOtherPLabel = null;
	private Button docOtherPButtonR = null;
	private Button docOtherPButtonW = null;
	private Button docOtherPButtonX = null;

	private Button editButton = null;
	private Button okButton = null;
	private Button cancelButton = null;

	private ITreeElement iTreeElement = null;
	private Long docId = null;

	private String result = null;

	private ISelection lastSelection = null;

	private OpenDocAction openDocAction = new OpenDocAction();
	private CloseDocAction closeDocAction = new CloseDocAction();
	
	private GetAllUsersAction getAllUsersAction = new GetAllUsersAction();
	private GetAllUserGroupsAction getAllUserGroupsAction = new GetAllUserGroupsAction();
	private GetAllMenusAction getAllMenusAction = new GetAllMenusAction();

	private StartModifyDocAction startModifyDocAction=new StartModifyDocAction();
	private FinishModifyDocAction finishModifyDocAction=new FinishModifyDocAction();
	private CancelModifyDocAction cancelModifyDocAction=new CancelModifyDocAction();
	
	private SelectionAdapter editButtonAdapter = new SelectionAdapter()
	{
		public void widgetSelected(SelectionEvent e)
		{
			try
			{
				result = startModifyDocAction.execute(Application.user.getUserName(), docId);
				if (result.equals("SUCCESS"))
				{	
					editButton.setEnabled(false);
					okButton.setEnabled(true);
					cancelButton.setEnabled(true);
					enableAllWidgets();
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
				char docP[]={'-','-','-','-','-','-','-','-','-'};
				if(docOwnerPButtonR.getSelection())
				{
					System.out.println("r");
					docP[0]='r';
				}
				if(docOwnerPButtonW.getSelection())
				{
					docP[1]='w';
				}
				if(docOwnerPButtonX.getSelection())
				{
					docP[2]='x';
				}
				if(docGroupPButtonR.getSelection())
				{
					docP[3]='r';
				}
				if(docGroupPButtonW.getSelection())
				{
					docP[4]='w';
				}
				if(docGroupPButtonX.getSelection())
				{
					docP[5]='x';
				}
				if(docOtherPButtonR.getSelection())
				{
					docP[6]='r';
				}
				if(docOtherPButtonW.getSelection())
				{
					docP[7]='w';
				}
				if(docOtherPButtonX.getSelection())
				{
					docP[8]='x';
				}
				String docP1=new String(docP);

				result = finishModifyDocAction.execute(Application.user.getUserName(), docId,docNameText.getText(),docOwnerCombo.getText(),docMenuCombo.getText(),docGroupCombo.getText(),docP1);
				if (result.equals("SUCCESS"))
				{
					editButton.setEnabled(true);
					okButton.setEnabled(false);
					cancelButton.setEnabled(false);
					disableAllWidgets();
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
				result = cancelModifyDocAction.execute(Application.user.getUserName(), docId);
				if (result.equals("SUCCESS"))
				{
					editButton.setEnabled(true);
					okButton.setEnabled(false);
					cancelButton.setEnabled(false);
					disableAllWidgets();
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
		data.right = new FormAttachment(25, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(0, 30);
		editButton.setLayoutData(data);
		editButton.addSelectionListener(editButtonAdapter);

		okButton = getWidgetFactory().createButton(composite, "确定", SWT.NONE);
		data = new FormData();
		data.left = new FormAttachment(25, 0);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(0, 30);
		okButton.setLayoutData(data);
		okButton.setEnabled(false);
		okButton.addSelectionListener(okButtonAdapter);

		cancelButton = getWidgetFactory().createButton(composite, "取消", SWT.NONE);
		data = new FormData();
		data.left = new FormAttachment(50, 0);
		data.right = new FormAttachment(75, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(0, 30);
		cancelButton.setLayoutData(data);
		cancelButton.setEnabled(false);
		cancelButton.addSelectionListener(cancelButtonAdapter);

		docNameLabel = getWidgetFactory().createLabel(composite, "文档名");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(0, 80);
		data.top = new FormAttachment(editButton, 0, SWT.BOTTOM);
		data.bottom = new FormAttachment(editButton, 30, SWT.BOTTOM);
		docNameLabel.setLayoutData(data);

		docNameText = getWidgetFactory().createText(composite, "test text");
		data = new FormData();
		data.left = new FormAttachment(docNameLabel, 0, SWT.RIGHT);
		data.right = new FormAttachment(45, 0);
		data.top = new FormAttachment(docNameLabel, 0, SWT.TOP);
		data.bottom = new FormAttachment(docNameLabel, 0, SWT.BOTTOM);
		docNameText.setLayoutData(data);

		docMenuLabel = getWidgetFactory().createLabel(composite, "文档目录");
		data = new FormData();
		data.left = new FormAttachment(50, 0);
		data.right = new FormAttachment(50, 80);
		data.top = new FormAttachment(docNameLabel, 0, SWT.TOP);
		data.bottom = new FormAttachment(docNameLabel, 0, SWT.BOTTOM);
		docMenuLabel.setLayoutData(data);

		docMenuCombo = getWidgetFactory().createCCombo(composite);
		data = new FormData();
		data.left = new FormAttachment(docMenuLabel, 0, SWT.RIGHT);
		data.right = new FormAttachment(95, 0);
		data.top = new FormAttachment(docMenuLabel, 0, SWT.TOP);
		data.bottom = new FormAttachment(docMenuLabel, 0, SWT.BOTTOM);
		docMenuCombo.setLayoutData(data);

		docOwnerLabel = getWidgetFactory().createLabel(composite, "文档所有者");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(0, 80);
		data.top = new FormAttachment(docNameLabel, 0, SWT.BOTTOM);
		data.bottom = new FormAttachment(docNameLabel, 30, SWT.BOTTOM);
		docOwnerLabel.setLayoutData(data);

		docOwnerCombo = getWidgetFactory().createCCombo(composite);
		data = new FormData();
		data.left = new FormAttachment(docOwnerLabel, 0, SWT.RIGHT);
		data.right = new FormAttachment(45, 0);
		data.top = new FormAttachment(docOwnerLabel, 0, SWT.TOP);
		data.bottom = new FormAttachment(docOwnerLabel, 0, SWT.BOTTOM);
		docOwnerCombo.setLayoutData(data);

		docGroupLabel = getWidgetFactory().createLabel(composite, "文档所属组");
		data = new FormData();
		data.left = new FormAttachment(50, 0);
		data.right = new FormAttachment(50, 80);
		data.top = new FormAttachment(docOwnerLabel, 0, SWT.TOP);
		data.bottom = new FormAttachment(docOwnerLabel, 0, SWT.BOTTOM);
		docGroupLabel.setLayoutData(data);

		docGroupCombo = getWidgetFactory().createCCombo(composite);
		data = new FormData();
		data.left = new FormAttachment(docGroupLabel, 0, SWT.RIGHT);
		data.right = new FormAttachment(95, 0);
		data.top = new FormAttachment(docGroupLabel, 0, SWT.TOP);
		data.bottom = new FormAttachment(docGroupLabel, 0, SWT.BOTTOM);
		docGroupCombo.setLayoutData(data);

		Group group = getWidgetFactory().createGroup(composite, "文档权限");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(docOwnerLabel, 0, SWT.BOTTOM);
		data.bottom = new FormAttachment(0, 200);
		group.setLayoutData(data);
		group.setLayout(composite.getLayout());

		docOwnerPLabel = getWidgetFactory().createLabel(group, "文档所有者权限");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(0, 0);
		docOwnerPLabel.setLayoutData(data);

		docOwnerPButtonR = getWidgetFactory().createButton(group, "R", SWT.CHECK | SWT.RIGHT_TO_LEFT);
		data = new FormData();
		data.left = new FormAttachment(docOwnerPLabel, 0, SWT.RIGHT);
		data.right = new FormAttachment(docOwnerPLabel, 40, SWT.RIGHT);
		data.top = new FormAttachment(docOwnerPLabel, 0, SWT.TOP);
		data.bottom = new FormAttachment(docOwnerPLabel, 0, SWT.BOTTOM);
		docOwnerPButtonR.setLayoutData(data);

		docOwnerPButtonW = getWidgetFactory().createButton(group, "W", SWT.CHECK | SWT.RIGHT_TO_LEFT);
		data = new FormData();
		data.left = new FormAttachment(docOwnerPButtonR, 0, SWT.RIGHT);
		data.right = new FormAttachment(docOwnerPButtonR, 40, SWT.RIGHT);
		data.top = new FormAttachment(docOwnerPButtonR, 0, SWT.TOP);
		data.bottom = new FormAttachment(docOwnerPButtonR, 0, SWT.BOTTOM);
		docOwnerPButtonW.setLayoutData(data);

		docOwnerPButtonX = getWidgetFactory().createButton(group, "X", SWT.CHECK | SWT.RIGHT_TO_LEFT);
		data = new FormData();
		data.left = new FormAttachment(docOwnerPButtonW, 0, SWT.RIGHT);
		data.right = new FormAttachment(docOwnerPButtonW, 40, SWT.RIGHT);
		data.top = new FormAttachment(docOwnerPButtonW, 0, SWT.TOP);
		data.bottom = new FormAttachment(docOwnerPButtonW, 0, SWT.BOTTOM);
		docOwnerPButtonX.setLayoutData(data);

		docGroupPLabel = getWidgetFactory().createLabel(group, "文档所属组权限");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(docOwnerPLabel, 0, SWT.BOTTOM);
		docGroupPLabel.setLayoutData(data);

		docGroupPButtonR = getWidgetFactory().createButton(group, "R", SWT.CHECK | SWT.RIGHT_TO_LEFT);
		data = new FormData();
		data.left = new FormAttachment(docGroupPLabel, 0, SWT.RIGHT);
		data.right = new FormAttachment(docGroupPLabel, 40, SWT.RIGHT);
		data.top = new FormAttachment(docGroupPLabel, 0, SWT.TOP);
		data.bottom = new FormAttachment(docGroupPLabel, 0, SWT.BOTTOM);
		docGroupPButtonR.setLayoutData(data);

		docGroupPButtonW = getWidgetFactory().createButton(group, "W", SWT.CHECK | SWT.RIGHT_TO_LEFT);
		data = new FormData();
		data.left = new FormAttachment(docGroupPButtonR, 0, SWT.RIGHT);
		data.right = new FormAttachment(docGroupPButtonR, 40, SWT.RIGHT);
		data.top = new FormAttachment(docGroupPButtonR, 0, SWT.TOP);
		data.bottom = new FormAttachment(docGroupPButtonR, 0, SWT.BOTTOM);
		docGroupPButtonW.setLayoutData(data);

		docGroupPButtonX = getWidgetFactory().createButton(group, "X", SWT.CHECK | SWT.RIGHT_TO_LEFT);
		data = new FormData();
		data.left = new FormAttachment(docGroupPButtonW, 0, SWT.RIGHT);
		data.right = new FormAttachment(docGroupPButtonW, 40, SWT.RIGHT);
		data.top = new FormAttachment(docGroupPButtonW, 0, SWT.TOP);
		data.bottom = new FormAttachment(docGroupPButtonW, 0, SWT.BOTTOM);
		docGroupPButtonX.setLayoutData(data);

		docOtherPLabel = getWidgetFactory().createLabel(group, "文档所属组权限");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(docGroupPLabel, 0, SWT.BOTTOM);
		docOtherPLabel.setLayoutData(data);

		docOtherPButtonR = getWidgetFactory().createButton(group, "R", SWT.CHECK | SWT.RIGHT_TO_LEFT);
		data = new FormData();
		data.left = new FormAttachment(docOtherPLabel, 0, SWT.RIGHT);
		data.right = new FormAttachment(docOtherPLabel, 40, SWT.RIGHT);
		data.top = new FormAttachment(docOtherPLabel, 0, SWT.TOP);
		data.bottom = new FormAttachment(docOtherPLabel, 0, SWT.BOTTOM);
		docOtherPButtonR.setLayoutData(data);

		docOtherPButtonW = getWidgetFactory().createButton(group, "W", SWT.CHECK | SWT.RIGHT_TO_LEFT);
		data = new FormData();
		data.left = new FormAttachment(docOtherPButtonR, 0, SWT.RIGHT);
		data.right = new FormAttachment(docOtherPButtonR, 40, SWT.RIGHT);
		data.top = new FormAttachment(docOtherPButtonR, 0, SWT.TOP);
		data.bottom = new FormAttachment(docOtherPButtonR, 0, SWT.BOTTOM);
		docOtherPButtonW.setLayoutData(data);

		docOtherPButtonX = getWidgetFactory().createButton(group, "X", SWT.CHECK | SWT.RIGHT_TO_LEFT);
		data = new FormData();
		data.left = new FormAttachment(docOtherPButtonW, 0, SWT.RIGHT);
		data.right = new FormAttachment(docOtherPButtonW, 40, SWT.RIGHT);
		data.top = new FormAttachment(docOtherPButtonW, 0, SWT.TOP);
		data.bottom = new FormAttachment(docOtherPButtonW, 0, SWT.BOTTOM);
		docOtherPButtonX.setLayoutData(data);
		
		disableAllWidgets();
	}

	protected void enableAllWidgets()
	{
		docNameText.setEnabled(true);
		docNameText.setEditable(true);
		docMenuCombo.setEnabled(true);
		docOwnerCombo.setEnabled(true);
		docGroupCombo.setEnabled(true);
		docOwnerPButtonR.setEnabled(true);
		docOwnerPButtonW.setEnabled(true);
		docOwnerPButtonX.setEnabled(true);
		docGroupPButtonR.setEnabled(true);
		docGroupPButtonW.setEnabled(true);
		docGroupPButtonX.setEnabled(true);
		docOtherPButtonR.setEnabled(true);
		docOtherPButtonW.setEnabled(true);
		docOtherPButtonX.setEnabled(true);
	}

	private void disableAllWidgets()
	{
		docNameText.setEnabled(false);
		docNameText.setEditable(false);
		docMenuCombo.setEnabled(false);
		docOwnerCombo.setEnabled(false);
		docGroupCombo.setEnabled(false);
		docOwnerPButtonR.setEnabled(false);
		docOwnerPButtonW.setEnabled(false);
		docOwnerPButtonX.setEnabled(false);
		docGroupPButtonR.setEnabled(false);
		docGroupPButtonW.setEnabled(false);
		docGroupPButtonX.setEnabled(false);
		docOtherPButtonR.setEnabled(false);
		docOtherPButtonW.setEnabled(false);
		docOtherPButtonX.setEnabled(false);
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection)
	{
		super.setInput(part, selection);
		showDocProperty(selection);
	}

	@Override
	public void refresh()
	{
	}

	private void showDocProperty(ISelection selection)
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
					doc = openDocAction.execute(Application.user.getUserName(), docId);
					docNameText.setText(doc.getDocName());
					setCheckButtons();
					setCombos();

				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			if (lastSelection != selection)
			{
				//关掉原先的
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
				//
				iTreeElement = (ITreeElement) ((IStructuredSelection) selection).getFirstElement();
				docId = iTreeElement.getId();
				try
				{
					doc = openDocAction.execute(Application.user.getUserName(), docId);
					docNameText.setText(doc.getDocName());
					setCheckButtons();
					setCombos();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
		}
	}

	private void setCheckButtons()
	{
		docOwnerPButtonR.setSelection(false);
		docOwnerPButtonW.setSelection(false);
		docOwnerPButtonX.setSelection(false);
		docGroupPButtonR.setSelection(false);
		docGroupPButtonW.setSelection(false);
		docGroupPButtonX.setSelection(false);
		docOtherPButtonR.setSelection(false);
		docOtherPButtonW.setSelection(false);
		docOtherPButtonX.setSelection(false);
		
		if (doc.getDocP().charAt(0) == 'r')
		{
			docOwnerPButtonR.setSelection(true);
		}
		if (doc.getDocP().charAt(1) == 'w')
		{
			docOwnerPButtonW.setSelection(true);
		}
		if (doc.getDocP().charAt(2) == 'x')
		{
			docOwnerPButtonX.setSelection(true);
		}
		if (doc.getDocP().charAt(3) == 'r')
		{
			docGroupPButtonR.setSelection(true);
		}
		if (doc.getDocP().charAt(4) == 'w')
		{
			docGroupPButtonW.setSelection(true);
		}
		if (doc.getDocP().charAt(5) == 'x')
		{
			docGroupPButtonX.setSelection(true);
		}
		if (doc.getDocP().charAt(6) == 'r')
		{
			docOtherPButtonR.setSelection(true);
		}
		if (doc.getDocP().charAt(7) == 'w')
		{
			docOtherPButtonW.setSelection(true);
		}
		if (doc.getDocP().charAt(8) == 'x')
		{
			docOtherPButtonX.setSelection(true);
		}
	}

	private void setCombos() throws Exception
	{
		List<User> users = getAllUsersAction.execute();
		User user = null;
		Iterator iterator = users.iterator();
		docOwnerCombo.add("NULL");
		while (iterator.hasNext())
		{
			user = (User) iterator.next();
			docOwnerCombo.add(user.getUserName());
		}

		List<Menu> menus = getAllMenusAction.execute();
		Menu menu = null;
		iterator = menus.iterator();
		//docMenu不能为空
		while (iterator.hasNext())
		{
			menu = (Menu) iterator.next();
			docMenuCombo.add(menu.getMenuName());
		}

		List<UserGroup> userGroups = getAllUserGroupsAction.execute();
		UserGroup userGroup = null;
		iterator = userGroups.iterator();
		docGroupCombo.add("NULL");
		while (iterator.hasNext())
		{
			userGroup = (UserGroup) iterator.next();
			docGroupCombo.add(userGroup.getGroupName());
		}

		if (doc.getDocOwner() == null)
		{
			docOwnerCombo.select(docOwnerCombo.indexOf("NULL"));
		}
		else
		{
			docOwnerCombo.select(docOwnerCombo.indexOf(doc.getDocOwner().getUserName()));
		}

		if (doc.getDocMenu() == null)
		{
			docMenuCombo.select(docMenuCombo.indexOf("NULL"));
		}
		else
		{
			docMenuCombo.select(docMenuCombo.indexOf(doc.getDocMenu().getMenuName()));
		}

		if (doc.getDocGroup() == null)
		{
			docGroupCombo.select(docGroupCombo.indexOf("NULL"));
		}
		else
		{
			docGroupCombo.select(docGroupCombo.indexOf(doc.getDocGroup().getGroupName()));
		}
	}

}
