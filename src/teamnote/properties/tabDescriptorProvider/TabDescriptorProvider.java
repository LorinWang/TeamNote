/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (c) Copyright IBM Corporation 2008,2012. All Rights Reserved.
 *
 * Note to U.S. Government Users Restricted Rights:  
 * Use, duplication or disclosure restricted by GSA ADP Schedule 
 * Contract with IBM Corp. 
 *******************************************************************************/
package teamnote.properties.tabDescriptorProvider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractTabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptorProvider;

import teamnote.navigator.model.NavigatorEntityElement;
import teamnote.properties.tabDescriptor.TestTabDescriptor;

public class TabDescriptorProvider implements ITabDescriptorProvider
{
	public ITabDescriptor[] getTabDescriptors(IWorkbenchPart arg0, ISelection selection)
	{
		List<AbstractTabDescriptor> result = new ArrayList<AbstractTabDescriptor>();

		result.add(new TestTabDescriptor());
		/*if (selection instanceof StructuredSelection)
		{
			Object input = ((StructuredSelection) selection).getFirstElement();
			if (input instanceof NavigatorEntityElement)
			{
				result.add(new TestTabDescriptor());
				if (input instanceof RPEEditPart)
				{
					templateNode = (TemplateNode) ((RPEEditPart) input).getModel();
				}
				else if (input instanceof RPETreePart)
				{
					templateNode = (TemplateNode) ((RPETreePart) input).getModel();
				}
				if (templateNode != null)
				{
					if (templateNode instanceof ContentPageModel || templateNode instanceof ZoomElementPageModel || templateNode instanceof StyleListModel || templateNode instanceof MasterPageListModel || templateNode instanceof DataSourceListModel || templateNode instanceof VariableListModel)
					{
					}
					else
					{
						result.add(new GeneralTabDescriptor());
						result.add(new ContentTabDescriptor());
						result.add(new DataTabDescriptor());
						result.add(new DynamicConfigurationTabDescriptor());
						result.add(new SpecificTabDescriptor());
						result.add(new MarginTabDescriptor());
						result.add(new FontTabDescriptor());
						result.add(new BorderTabDescriptor());
						result.add(new CellBorderTabDescriptor());
						result.add(new PageBorderTabDescriptor());
						result.add(new PaddingTabDescriptor());
						result.add(new ParagraphPaddingTabDescriptor());
						result.add(new ColorTabDescriptor());
						result.add(new PositionAndAlignmentTabDescriptor());
						result.add(new SizeTabDescriptor());
						result.add(new NumberingTabDescriptor());
						result.add(new GenericTabDescriptor());
					}
				}

			}
		}*/

		return (ITabDescriptor[]) result.toArray(new ITabDescriptor[result.size()]);
	}

}
