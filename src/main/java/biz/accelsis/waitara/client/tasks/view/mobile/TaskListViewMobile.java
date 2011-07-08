package biz.accelsis.waitara.client.tasks.view.mobile;

import java.util.List;

import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.view.AbstractTaskListView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class TaskListViewMobile extends AbstractTaskListView
{
    // @formatter:off
    interface TasksUi extends UiBinder<Widget, TaskListViewMobile> {}
    private static TasksUi uiBinder = GWT.create(TasksUi.class);
    
    @UiField(provided = true) TaskList tasks;
    // @formatter:on

    @Override
    protected Widget initUi()
    {
        tasks = new TaskList();
        return uiBinder.createAndBindUi(this);
    }


    @Override
    public void updateTasks(List<Task> tasks)
    {
        this.tasks.update(tasks);
    }
}
