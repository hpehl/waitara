package biz.accelsis.waitara.client.application;

import biz.accelsis.waitara.client.resources.Resources;
import biz.accelsis.waitara.client.ui.UiUtils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationViewDesktop extends AbstractApplicationView
{
    // @formatter:off
    interface ApplicationUi extends UiBinder<Widget, ApplicationViewDesktop> {}
    private static ApplicationUi uiBinder = GWT.create(ApplicationUi.class);

    @UiField FlowPanel navigationPanel;
    // @formatter:on

    @Override
    public void setInSlot(Object slot, Widget content)
    {
        if (slot == ApplicationPresenter.SLOT_Navigation)
        {
            UiUtils.setContent(navigationPanel, content);
        }
        else
        {
            super.setInSlot(slot, content);
        }
    }


    @Override
    protected void injectCss(Resources resources)
    {
        resources.desktop().ensureInjected();

    }


    @Override
    protected Widget initUi()
    {
        return uiBinder.createAndBindUi(this);
    }
}
