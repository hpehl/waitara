package biz.accelsis.waitara.client.application;

import biz.accelsis.waitara.client.resources.Resources;
import biz.accelsis.waitara.client.ui.UiUtils;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public abstract class AbstractApplicationView extends ViewImpl implements ApplicationPresenter.MyView
{
    // @formatter:off
    @UiField FlowPanel navigationPanel;
    @UiField ScrollPanel mainPanel;
    // @formatter:on

    protected Widget widget;
    protected Resources resources;


    @Override
    public Widget asWidget()
    {
        return widget;
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
