package biz.accelsis.waitara.client.application.view;

import java.util.List;

import biz.accelsis.waitara.client.Waitara;
import biz.accelsis.waitara.client.application.presenter.ApplicationPresenter;
import biz.accelsis.waitara.client.resources.Resources;
import biz.accelsis.waitara.client.tasks.model.Task;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public abstract class AbstractApplicationView extends ViewImpl implements ApplicationView
{
    @UiField
    Panel mainPanel;
    final Widget widget;
    final Resources resources;


    public AbstractApplicationView()
    {
        this.resources = Waitara.ginjector.getResources();
        injectCss(this.resources);
        this.widget = initUi();
    }


    abstract void injectCss(Resources resources);


    abstract Widget initUi();


    @Override
    public Widget asWidget()
    {
        return widget;
    }


    @Override
    public void highlight(String token)
    {
        // default implemmentation does nothing
    }


    @Override
    public void taskList(List<Task> tasks)
    {
        // default implemmentation does nothing
    }


    @Override
    public void taskDetail(Task task)
    {
        // default implemmentation does nothing
    }


    @Override
    public void setInSlot(Object slot, Widget content)
    {
        if (slot == ApplicationPresenter.TYPE_SetMainContent)
        {
            mainPanel.clear();
            mainPanel.add(content);
        }
        else
        {
            super.setInSlot(slot, content);
        }
    }
}
