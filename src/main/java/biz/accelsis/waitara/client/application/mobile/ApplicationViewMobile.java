package biz.accelsis.waitara.client.application.mobile;

import biz.accelsis.waitara.client.application.AbstractApplicationView;
import biz.accelsis.waitara.client.resources.Resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationViewMobile extends AbstractApplicationView
{
    // @formatter:off
    interface ApplicationUi extends UiBinder<Widget, ApplicationViewMobile> {}
    private static ApplicationUi uiBinder = GWT.create(ApplicationUi.class);
    
    @UiField HeadingElement header;
    @UiField InlineHyperlink tasks;
    // @formatter:on

    @Override
    protected void injectCss(Resources resources)
    {
        resources.mobile().ensureInjected();

    }


    @Override
    protected Widget initUi()
    {
        return uiBinder.createAndBindUi(this);
    }
}
