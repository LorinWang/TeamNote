package teamnote.navigator.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.IEditorInput;

public class NavigatorEntityElement implements ITreeElement
{
	private String name;
	private IEditorInput editorInput;
	private List list = new ArrayList();

	public NavigatorEntityElement()
	{
	}

	public NavigatorEntityElement(String name)
	{
		this.name = name;
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

}
