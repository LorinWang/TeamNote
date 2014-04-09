package teamnote;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory
{

	public void createInitialLayout(IPageLayout layout)
	{
		String navigatorViewID="TeamNote.views.NavigatorView";
		String navigatorViewID2="TeamNote.views.NavigatorView2";
		
		String editorArea=layout.getEditorArea();
		
		IFolderLayout leftFolder = layout.createFolder("leftFolder", IPageLayout.LEFT, 0.3f, editorArea); //$NON-NLS-1$
		leftFolder.addView(navigatorViewID);
		leftFolder.addView(navigatorViewID2);
		
		layout.addStandaloneView(IPageLayout.ID_PROP_SHEET, true, IPageLayout.RIGHT, 0.3f, editorArea);
		//layout.addView(IPageLayout.ID_PROP_SHEET, IPageLayout.BOTTOM, 0.3f, editorArea);
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);

	}

}
