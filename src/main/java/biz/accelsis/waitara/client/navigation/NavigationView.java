package biz.accelsis.waitara.client.navigation;


import biz.accelsis.waitara.client.resources.Resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author $Author: harald.pehl $
 * @version $Date: 2010-12-16 10:41:46 +0100 (Do, 16 Dez 2010) $ $Revision: 175
 *          $
 */
public class NavigationView extends ViewImpl implements NavigationPresenter.MyView
{
    interface NavigationUi extends UiBinder<Widget, NavigationView>
    {
    }

    private static NavigationUi uiBinder = GWT.create(NavigationUi.class);

    // @formatter:off
    @UiField InlineHyperlink dashboard;
    @UiField InlineHyperlink projects;
    @UiField InlineHyperlink clients;
    @UiField InlineHyperlink tags;
    @UiField InlineHyperlink reports;
    @UiField InlineHyperlink help;
    @UiField InlineHyperlink settings;
    private final InlineHyperlink[] navigationLinks;
    // @formatter:on

    private final Widget widget;
    private final Resources resources;


    @Inject
    public NavigationView(final Resources resources)
    {
        this.resources = resources;
        this.widget = uiBinder.createAndBindUi(this);
        this.navigationLinks = new InlineHyperlink[] {dashboard, projects, clients, tags, reports, help, settings,};
    }


    @Override
    public Widget asWidget()
    {
        return widget;
    }
}
