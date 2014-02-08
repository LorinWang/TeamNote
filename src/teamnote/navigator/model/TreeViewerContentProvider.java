package teamnote.navigator.model;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TreeViewerContentProvider implements ITreeContentProvider
{

	public TreeViewerContentProvider()
	{
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement)
	{
		if (inputElement instanceof List)
		{
			List list = (List) inputElement;
			return list.toArray();
		}
		else
		{
			return new Object[0];
		}
	}

	@Override
	public Object[] getChildren(Object parentElement)
	{
		ITreeElement treeElement = (ITreeElement) parentElement;
		List list = treeElement.getChildren();
		if (list == null || list.isEmpty())
		{
			return new Object[0];
		}
		else
		{
			return list.toArray();
		}
	}

	@Override
	public Object getParent(Object element)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element)
	{
		ITreeElement treeElement = (ITreeElement) element;
		List list = treeElement.getChildren();
		if (list == null || list.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
