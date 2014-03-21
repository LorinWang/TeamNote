package teamnote.navigator.model;

import java.util.List;

public interface ITreeElement
{
	public long getId();
	public void setId(long id);
	
	public boolean isMenu();
	public void setMenu(boolean isMenu);
	
	public void setName(String name);

	public String getName();

	public void setChildren(List children);

	public List getChildren();

	public boolean hasChildren();

	public void addChild(ITreeElement treeElement);

	public void removeChild(ITreeElement treeElement);

	public void removeAllChildren();

}
