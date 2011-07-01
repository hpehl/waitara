package biz.accelsis.waitara.client.navigation;

import javax.inject.Inject;

import biz.accelsis.waitara.client.resources.Resources;

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
    @UiField InlineHyperlink settings;
    @UiField InlineHyperlink help;
    @UiField InlineHyperlink about;
    // @formatter:on

    private final Widget widget;
    private final Resources resources;
    private final InlineHyperlink[] navigationLinks;


    @Inject
    public NavigationView(final Resources resources)
    {
        this.resources = resources;
        this.resources.desktop().ensureInjected();
        this.widget = uiBinder.createAndBindUi(this);
        this.navigationLinks = new InlineHyperlink[] {tasks, newTask, settings, help, about,};
    }


    @Override
    public Widget asWidget()
    {
        return widget;
    }


    @Override
    public void highlight(String token)
    {
        if (token != null)
        {
            for (InlineHyperlink link : navigationLinks)
            {
                if (token.equals(link.getTargetHistoryToken()))
                {
                    link.addStyleName(resources.desktop().selectedNavigationEntry());
                }
                else
                {
                    link.removeStyleName(resources.desktop().selectedNavigationEntry());
                }
            }
        }
    }
}
