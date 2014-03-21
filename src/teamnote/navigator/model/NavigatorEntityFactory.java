package teamnote.navigator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import teamnote.action.ShowMenusAction;
import teamnote.action.UnfoldMenuAction;
import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.editors.DocEditorInput;

public class NavigatorEntityFactory
{
	public static Object TreeEntityElement(User user)
	{
		ShowMenusAction showMenusAction=new ShowMenusAction();
		UnfoldMenuAction unfoldMenuAction=new UnfoldMenuAction();
		
		NavigatorEntityElement root=null;
		NavigatorEntityElement leaf=null;
		
		ArrayList treeList=new ArrayList();
		try
		{
			List<Menu> menus=showMenusAction.execute(user.getUserName());
			if(menus==null)
			{
				return null;
			}
			for(Menu menu:menus)
			{
				root=new NavigatorEntityElement(menu.getMenuId(),menu.getMenuName(),true);
				Set<Doc> docs=unfoldMenuAction.execute(user.getUserName(), menu.getMenuName());
				if(docs!=null)
				{
					for(Doc doc:docs)
					{
						leaf=new NavigatorEntityElement(doc.getDocId(),doc.getDocName(),false);
						leaf.setEditorInput(new DocEditorInput());
						root.addChild(leaf);
					}
				}
				treeList.add(root);
			}
			return treeList;
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
		/*
		NavigatorEntityElement root1 = new NavigatorEntityElement("一班");
		NavigatorEntityElement root2 = new NavigatorEntityElement("二班");

		NavigatorEntityElement level1 = new NavigatorEntityElement("一班名单");
		NavigatorEntityElement level2 = new NavigatorEntityElement("二班名单");

		level1.setEditorInput(new DocEditorInput());

		root1.addChild(level1);
		root2.addChild(level2);
		{
			ArrayList list = new ArrayList();
			list.add(root1);
			list.add(root2);
			return list;
		}*/
	}

}
