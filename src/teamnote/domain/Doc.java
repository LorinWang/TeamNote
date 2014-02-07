package teamnote.domain;

import java.util.HashSet;
import java.util.Set;

public class Doc
{
	private long docId; // �ĵ�����
	private String docName; // �ĵ���
	private String docP; // �ĵ�Ȩ��
	private String docContent; // �ĵ�����

	private User docOwner; // �ĵ�������
	private UserGroup docGroup; // �ĵ�������

	private User docEditor; // �ĵ������޸���
	private User docModifier;// �ĵ������޸���

	private Set<User> docReadUsers = new HashSet<User>(); // �ĵ���ȡ��

	private Menu docMenu; // �ĵ�����Ŀ¼

	public Doc()
	{
	}

	public Doc(long docId, String docName, String docP, String docContent, User docOwner, UserGroup docGroup, User docEditor, User docModifier, Set<User> docReadUsers, Menu docMenu)
	{
		super();
		this.docId = docId;
		this.docName = docName;
		this.docP = docP;
		this.docContent = docContent;
		this.docOwner = docOwner;
		this.docGroup = docGroup;
		this.docEditor = docEditor;
		this.docModifier = docModifier;
		this.docReadUsers = docReadUsers;
		this.docMenu = docMenu;
	}

	public long getDocId()
	{
		return docId;
	}

	public void setDocId(long docId)
	{
		this.docId = docId;
	}

	public String getDocName()
	{
		return docName;
	}

	public void setDocName(String docName)
	{
		this.docName = docName;
	}

	public String getDocP()
	{
		return docP;
	}

	public void setDocP(String docP)
	{
		this.docP = docP;
	}

	public String getDocContent()
	{
		return docContent;
	}

	public void setDocContent(String docContent)
	{
		this.docContent = docContent;
	}

	public User getDocOwner()
	{
		return docOwner;
	}

	public void setDocOwner(User docOwner)
	{
		this.docOwner = docOwner;
	}

	public UserGroup getDocGroup()
	{
		return docGroup;
	}

	public void setDocGroup(UserGroup docGroup)
	{
		this.docGroup = docGroup;
	}

	public User getDocEditor()
	{
		return docEditor;
	}

	public void setDocEditor(User docEditor)
	{
		this.docEditor = docEditor;
	}

	public User getDocModifier()
	{
		return docModifier;
	}

	public void setDocModifier(User docModifier)
	{
		this.docModifier = docModifier;
	}

	public Set<User> getDocReadUsers()
	{
		return docReadUsers;
	}

	public void setDocReadUsers(Set<User> docReadUsers)
	{
		this.docReadUsers = docReadUsers;
	}

	public Menu getDocMenu()
	{
		return docMenu;
	}

	public void setDocMenu(Menu docMenu)
	{
		this.docMenu = docMenu;
	}

}
