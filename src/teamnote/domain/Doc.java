package teamnote.domain;

import java.util.HashSet;
import java.util.Set;

public class Doc
{
	private long docId; // �ĵ�����
	private String docName; // �ĵ���
	private String docP; // �ĵ�Ȩ��
	private String docContent; // �ĵ�����

	private User docOwner; // �½��ĵ���
	private User docEditor; // �ĵ��޸���
	private User docModifier;// �ĵ������޸���

	private Set<User> readUser = new HashSet<User>(); // �ĵ���ȡ��

	private UserGroup docGroup; // �ĵ�������

	private Menu docMenu; // �ĵ�����Ŀ¼

	public Doc()
	{
	}

	public Doc(long docId, String docName, String docP, String docContent, User docOwner, User docEditor, User docModifier, Set<User> readUser, UserGroup docGroup, Menu docMenu)
	{
		super();
		this.docId = docId;
		this.docName = docName;
		this.docP = docP;
		this.docContent = docContent;
		this.docOwner = docOwner;
		this.docEditor = docEditor;
		this.docModifier = docModifier;
		this.readUser = readUser;
		this.docGroup = docGroup;
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

	public Set<User> getReadUser()
	{
		return readUser;
	}

	public void setReadUser(Set<User> readUser)
	{
		this.readUser = readUser;
	}

	public UserGroup getDocGroup()
	{
		return docGroup;
	}

	public void setDocGroup(UserGroup docGroup)
	{
		this.docGroup = docGroup;
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
