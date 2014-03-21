package teamnote.properties.tabDescriptor;

import org.eclipse.ui.views.properties.tabbed.AbstractTabDescriptor;

import teamnote.properties.sectionDescriptor.TestSectionDescriptor;

public class TestTabDescriptor extends AbstractTabDescriptor
{
	public TestTabDescriptor()
	{
		super();
		getSectionDescriptors().add(new TestSectionDescriptor());
	}
	@Override
	public String getCategory()
	{
		return "default";
	}

	@Override
	public String getId()
	{
		return "testTab";
	}

	@Override
	public String getLabel()
	{
		return "TabTest";
	}

}
