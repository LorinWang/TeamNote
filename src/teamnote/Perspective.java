package teamnote;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory
{

	public void createInitialLayout(IPageLayout layout)
	{
		String navigatorViewID="TeamNote.views.NavigatorView";
		
		String editorArea=layout.getEditorArea();
		
		layout.addView(navigatorViewID, IPageLayout.LEFT, 0.3f, editorArea);
		
		layout.setEditorAreaVisible(true);
		layout.setFixed(true);

	}

}
