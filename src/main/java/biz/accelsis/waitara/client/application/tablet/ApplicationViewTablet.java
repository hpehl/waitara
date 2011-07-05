package biz.accelsis.waitara.client.application.tablet;

import javax.inject.Inject;

import biz.accelsis.waitara.client.application.AbstractApplicationView;
import biz.accelsis.waitara.client.resources.Resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationViewTablet extends AbstractApplicationView
{
    // @formatter:off
    interface ApplicationUi extends UiBinder<Widget, ApplicationViewTablet> {}
    private static ApplicationUi uiBinder = GWT.create(ApplicationUi.class);
    // @formatter:on

    @Inject
    public ApplicationViewTablet(Resources resources)
    {
        this.resources = resources;
        this.resources.mobile().ensureInjected();
        this.widget = uiBinder.createAndBindUi(this);
    }
}
