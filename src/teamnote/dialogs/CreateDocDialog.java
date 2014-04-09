package teamnote.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CreateDocDialog extends Dialog
{
	private Text docNameText=null;
	
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
	
	//���öԻ���
	@Override
	protected void configureShell(Shell newShell)
	{
		super.configureShell(newShell);
		newShell.setText("�½��ĵ�");
	}

	//��Ⱦ�������
	@Override
	protected Control createDialogArea(Composite parent)
	{
		Composite composite = (Composite) super.createDialogArea(parent);
		new Label(composite,SWT.NONE).setText("�ĵ���");
		docNameText=new Text(composite,SWT.BORDER|SWT.SINGLE);
		new Label(composite,SWT.NONE).setText("����");
		docContentText=new Text(composite,SWT.BORDER|SWT.MULTI|SWT.V_SCROLL|SWT.H_SCROLL);
		
		
		return parent;
	}
	
	//��ť����
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
