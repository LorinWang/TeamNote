package teamnote.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import teamnote.Application;
import teamnote.domain.User;
import teamnote.utils.ImageKeys;

public class LoginDialog extends TitleAreaDialog
{
	private Text userName;
	private Text passWord;
	private User user;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public LoginDialog(Shell parentShell)
	{
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void configureShell(Shell newShell)
	{
		super.configureShell(newShell);
		newShell.setText("用户登录");
		newShell.setSize(500, 200);
		newShell.setLocation(260, 260);
		newShell.setImage(AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, ImageKeys.LOGIN).createImage());
	}

	@Override
	protected Control createContents(Composite parent)
	{
		Control contents = super.createContents(parent);
		setTitle("添加登录信息");
		setMessage("登录文本信息不能为空", IMessageProvider.INFORMATION);
		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent)
	{
		Composite composite =new Composite(parent,SWT.BORDER);
		composite.setLayout(new GridLayout(2,false));
		GridData layoutData=new GridData(GridData.FILL_HORIZONTAL);
		composite.setLayoutData(layoutData);
		new Label(composite,SWT.NONE).setText("用户名:");
		userName=new Text(composite,SWT.BORDER);
		userName.setLayoutData(layoutData);
		
		new Label(composite,SWT.NONE).setText("密   码:");
		passWord=new Text(composite,SWT.BORDER);
		passWord.setEchoChar('*');
		passWord.setLayoutData(layoutData);
		return composite;
	}

	@Override
	protected void buttonPressed(int buttonId)
	{
		if(IDialogConstants.OK_ID==buttonId)
		{
			if(!checkValue())
			{
				return;
			}
			getValue(user);
		}
		okPressed();
		if(IDialogConstants.CANCEL_ID==buttonId)
		{
			cancelPressed();
		}
	}
	
	private boolean checkValue()
	{
		String un=userName.getText();
		String pw=passWord.getText();
		if(pw==null||pw.equals("")||un==null||un.equals(""))
		{
			setErrorMessage("用户名或密码不能为空");
			return false;
		}
		return true;
	}
	
	private void getValue(User user)
	{
		String un=userName.getText();
		String pw=passWord.getText();
		user.setUserName(un);
		user.setUserPassword(pw);
	}

}
