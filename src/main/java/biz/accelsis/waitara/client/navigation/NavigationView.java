package biz.accelsis.waitara.client.navigation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author $Author: harald.pehl $
 * @version $Date: 2010-12-16 10:41:46 +0100 (Do, 16 Dez 2010) $ $Revision: 175
 *          $
 */
public class NavigationView extends ViewImpl implements NavigationPresenter.MyView
{
    // @formatter:off
    interface NavigationUi extends UiBinder<Widget, NavigationView> {}
    private static NavigationUi uiBinder = GWT.create(NavigationUi.class);

    @UiField InlineHyperlink tasks;
    @UiField InlineHyperlink newTask;
    @UiField InlineHyperlink about;
    // @formatter:on

    private final Widget widget;


    public NavigationView()
    {
        this.widget = uiBinder.createAndBindUi(this);
    }


    @Override
    public Widget asWidget()
    {
        return widget;
    }
}
