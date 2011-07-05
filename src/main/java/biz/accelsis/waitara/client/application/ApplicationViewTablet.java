package biz.accelsis.waitara.client.application;

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

    @Override
    protected void injectCss(Resources resources)
    {
        resources.tablet().ensureInjected();

    }


    @Override
    protected Widget initUi()
    {
        return uiBinder.createAndBindUi(this);
    }
}
