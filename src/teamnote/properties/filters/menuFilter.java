package teamnote.properties.filters;

import org.eclipse.jface.viewers.IFilter;

import teamnote.navigator.model.NavigatorEntityElement;

public class menuFilter implements IFilter
{
	NavigatorEntityElement navigatorEntityElement = null;

	@Override
	public boolean select(Object toTest)
	{
		if (toTest instanceof NavigatorEntityElement)
		{
			navigatorEntityElement = (NavigatorEntityElement) toTest;
			if (navigatorEntityElement.isMenu() == true)
			{
				return true;
			}
		}
		return false;
	}

}
