package biz.accelsis.waitara.client.tasks.view;

import java.util.List;

import biz.accelsis.waitara.client.Waitara;
import biz.accelsis.waitara.client.tasks.model.Task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class TasksViewDesktop extends AbstractTasksView
{
    // @formatter:off
    interface TasksUi extends UiBinder<Widget, TasksViewDesktop> {}
    private static TasksUi uiBinder = GWT.create(TasksUi.class);
    
    @UiField(provided = true) TasksTable tasks;
    // @formatter:on

    @Override
    protected Widget initUi()
    {
        tasks = new TasksTable(Waitara.ginjector.getTasksTableResources());
        return uiBinder.createAndBindUi(this);
    }


    @Override
    public void updateTasks(List<Task> tasks)
    {
        this.tasks.update(tasks);
    }
}
