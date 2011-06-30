package biz.accelsis.waitara.client.application;

import biz.accelsis.waitara.client.resources.Resources;
import biz.accelsis.waitara.client.ui.UiUtils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ApplicationViewDesktop extends AbstractApplicationView
{
    // @formatter:off
    interface ApplicationUi extends UiBinder<Widget, ApplicationViewDesktop> {}
    private static ApplicationUi uiBinder = GWT.create(ApplicationUi.class);

    @UiField FlowPanel navigationPanel;
    @UiField ScrollPanel mainPanel;
    // @formatter:on

    @Inject
    public ApplicationViewDesktop(Resources resources)
    {
        this.resources = resources;
        this.resources.desktop().ensureInjected();
        this.widget = uiBinder.createAndBindUi(this);

    }


    @Override
    public void setInSlot(Object slot, Widget content)
    {
        if (slot == ApplicationPresenter.TYPE_SetMainContent)
        {
            UiUtils.setContent(mainPanel, content);
        }
        else if (slot == ApplicationPresenter.SLOT_Navigation)
        {
            UiUtils.setContent(navigationPanel, content);
        }
        else
        {
            super.setInSlot(slot, content);
        }
    }
}
