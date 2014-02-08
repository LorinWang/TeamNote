package teamnote.navigator.model;

import java.util.ArrayList;

import teamnote.editors.DocEditorInput;

public class NavigatorEntityFactory
{
	public static Object TreeEntityElement()
	{
		NavigatorEntityElement root1 = new NavigatorEntityElement("һ��");
		NavigatorEntityElement root2 = new NavigatorEntityElement("����");

		NavigatorEntityElement level1 = new NavigatorEntityElement("һ������");
		NavigatorEntityElement level2 = new NavigatorEntityElement("��������");

		level1.setEditorInput(new DocEditorInput());

		root1.addChild(level1);
		root2.addChild(level2);
		{
			ArrayList list = new ArrayList();
			list.add(root1);
			list.add(root2);
			return list;
		}
	}

}
