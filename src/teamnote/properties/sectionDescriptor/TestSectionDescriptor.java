package teamnote.properties.sectionDescriptor;

import org.eclipse.jface.viewers.IFilter;
import org.eclipse.ui.views.properties.tabbed.AbstractSectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ISection;

import teamnote.properties.filters.testFilter;
import teamnote.section.testSection;

public class TestSectionDescriptor extends AbstractSectionDescriptor
{

	@Override
	public String getId()
	{
		return this.getClass().toString();
	}

	@Override
	public ISection getSectionClass()
	{
		return new testSection();
	}

	@Override
	public String getTargetTab()
	{
		return "testTab";
	}

	@Override
	public IFilter getFilter()
	{
		return new testFilter();
	}

}
