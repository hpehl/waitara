package biz.accelsis.waitara.client.application.view;

import java.util.List;

import biz.accelsis.waitara.client.resources.Resources;
import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.view.ui.TaskListWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationViewTablet extends AbstractApplicationView
{
    // @formatter:off
    interface ApplicationUi extends UiBinder<Widget, ApplicationViewTablet> {}
    private static ApplicationUi uiBinder = GWT.create(ApplicationUi.class);
    
    @UiField TaskListWidget taskList;
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


    @Override
    public void taskList(List<Task> tasks)
    {
        taskList.update(tasks);
    }
}
