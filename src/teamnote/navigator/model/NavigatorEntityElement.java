package teamnote.navigator.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.IEditorInput;

public class NavigatorEntityElement implements ITreeElement
{
	private long id;
	private String name;
	private boolean isMenu;
	private IEditorInput editorInput;
	private List list = new ArrayList();

	public NavigatorEntityElement()
	{
	}

	public NavigatorEntityElement(long id,String name,boolean isMenu)
	{
		this.id=id;
		this.name = name;
		this.isMenu=isMenu;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setChildren(List children)
	{
		this.list = children;
	}

	@Override
	public List getChildren()
	{
		return list;
	}

	@Override
	public boolean hasChildren()
	{
		if (list.size() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void addChild(ITreeElement treeElement)
	{
		list.add(treeElement);
	}

	public IEditorInput getEditorInput()
	{
		return editorInput;
	}

	public void setEditorInput(IEditorInput editorInput)
	{
		this.editorInput = editorInput;
	}

	@Override
	public void removeChild(ITreeElement treeElement)
	{
		list.remove(treeElement);

	}

	@Override
	public void removeAllChildren()
	{
		list = null;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public boolean isMenu()
	{
		return isMenu;
	}

	public void setMenu(boolean isMenu)
	{
		this.isMenu = isMenu;
	}

}
