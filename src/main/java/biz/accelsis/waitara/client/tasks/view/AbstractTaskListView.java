package biz.accelsis.waitara.client.tasks.view;

import biz.accelsis.waitara.client.Waitara;
import biz.accelsis.waitara.client.resources.Resources;
import biz.accelsis.waitara.client.tasks.event.TaskActionEvent;
import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.presenter.TaskUiHandlers;

import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public abstract class AbstractTaskListView extends ViewWithUiHandlers<TaskUiHandlers> implements TaskListView
{
    final Widget widget;
    final Resources resources;


    public AbstractTaskListView()
    {
        this.resources = Waitara.ginjector.getResources();
        this.widget = initUi();
    }


    abstract Widget initUi();


    @Override
    public Widget asWidget()
    {
        return widget;
    }


    @UiHandler("tasks")
    public void onTaskAction(TaskActionEvent event)
    {
        if (getUiHandlers() != null)
        {
            Task task = event.getTask();
            switch (event.getAction())
            {
                case DETAIL:
                    getUiHandlers().onDetail(task);
                    break;
                case EDIT:
                case DELETE:
                default:
                    break;
            }
        }
    }
}
