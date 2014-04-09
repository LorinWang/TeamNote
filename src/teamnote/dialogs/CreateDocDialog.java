package teamnote.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import teamnote.Application;
import teamnote.utils.ImageKeys;

public class CreateDocDialog extends Dialog
{
	private Label docNameLabel=null;
	private Text docNameText=null;
	
	private Label docContentLabel=null;
	private Text docContentText=null;
	
	private String docNameString;
	private String docContentString;
	
	public String getDocNameString()
	{
		return docNameString;
	}

	public String getDocContentString()
	{
		return docContentString;
	}

	public CreateDocDialog(Shell parentShell)
	{
		super(parentShell);
	}
	
	//配置对话框
	@Override
	protected void configureShell(Shell newShell)
	{
		super.configureShell(newShell);
		newShell.setText("新建文档");
		newShell.setSize(600, 600);
		newShell.setImage(AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, ImageKeys.CREATEDOC).createImage());
	}

	//渲染窗口组件
	@Override
	protected Control createDialogArea(Composite parent)
	{
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new FormLayout());
		docNameLabel=new Label(composite,SWT.NONE);
		docNameLabel.setText("文档名称");
		FormData data = new FormData();
		data.left = new FormAttachment(0, 10);
		data.right = new FormAttachment(0, 60);
		data.top = new FormAttachment(0, 10);
		data.bottom = new FormAttachment(0, 30);
		docNameLabel.setLayoutData(data);
		
		docNameText=new Text(composite,SWT.BORDER|SWT.SINGLE);
		data = new FormData();
		data.left = new FormAttachment(docNameLabel, 10,SWT.RIGHT);
		data.right = new FormAttachment(100, -10);
		data.top = new FormAttachment(0, 10);
		data.bottom = new FormAttachment(0, 30);
		docNameText.setLayoutData(data);
		
		docContentLabel=new Label(composite,SWT.NONE);
		docContentLabel.setText("文档内容");
		data = new FormData();
		data.left = new FormAttachment(0, 10);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(docNameLabel, 10,SWT.BOTTOM);
		data.bottom = new FormAttachment(docNameLabel, 40,SWT.BOTTOM);
		docContentLabel.setLayoutData(data);
		
		docContentText=new Text(composite,SWT.BORDER|SWT.MULTI|SWT.V_SCROLL|SWT.H_SCROLL);
		data = new FormData();
		data.left = new FormAttachment(0, 10);
		data.right = new FormAttachment(100, -10);
		data.top = new FormAttachment(docContentLabel, 0,SWT.BOTTOM);
		data.bottom = new FormAttachment(100,0);
		docContentText.setLayoutData(data);
		
		
		return parent;
	}
	
	//按钮按下
	@Override
	protected void buttonPressed(int buttonId)
	{
		if(IDialogConstants.OK_ID==buttonId)
		{
			if(!checkValue())
			{
				return;
			}
			getValue();
		}
		okPressed();
		if(IDialogConstants.CANCEL_ID==buttonId)
		{
			cancelPressed();
		}
	}
	
	private boolean checkValue()
	{
		if(docNameText.getText()==null||docNameText.getText().equals(""))
		{			
			return false;
		}
		return true;
	}
	
	private void getValue()
	{
		docNameString=docNameText.getText();
		docContentString=""+docContentText.getText();
	}
}
