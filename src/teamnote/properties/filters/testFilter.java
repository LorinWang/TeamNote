package teamnote.properties.filters;

import org.eclipse.jface.viewers.IFilter;

import teamnote.navigator.model.NavigatorEntityElement;

public class testFilter implements IFilter
{
	NavigatorEntityElement navigatorEntityElement = null;

	@Override
	public boolean select(Object toTest)
	{
		if (toTest instanceof NavigatorEntityElement)
		{
			navigatorEntityElement = (NavigatorEntityElement) toTest;
			if (navigatorEntityElement.isMenu() == false)
			{
				return true;
			}
		}
		return false;
	}

}
