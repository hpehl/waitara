package biz.accelsis.waitara.client.application.desktop;

import javax.inject.Inject;

import biz.accelsis.waitara.client.application.AbstractApplicationView;
import biz.accelsis.waitara.client.resources.Resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationViewDesktop extends AbstractApplicationView
{
    // @formatter:off
    interface ApplicationUi extends UiBinder<Widget, ApplicationViewDesktop> {}
    private static ApplicationUi uiBinder = GWT.create(ApplicationUi.class);
    // @formatter:on

    @Inject
    public ApplicationViewDesktop(Resources resources)
    {
        this.resources = resources;
        this.resources.desktop().ensureInjected();
        this.widget = uiBinder.createAndBindUi(this);
    }
}
