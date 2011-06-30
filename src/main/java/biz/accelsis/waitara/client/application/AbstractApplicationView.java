package biz.accelsis.waitara.client.application;

import biz.accelsis.waitara.client.resources.Resources;

import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public abstract class AbstractApplicationView extends ViewWithUiHandlers<ApplicationUiHandlers> implements
        ApplicationPresenter.MyView
{
    protected Widget widget;
    protected Resources resources;


    @Override
    public Widget asWidget()
    {
        return widget;
    }
}
