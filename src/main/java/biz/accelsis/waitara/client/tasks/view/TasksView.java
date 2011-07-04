package biz.accelsis.waitara.client.tasks.view;

import java.util.List;

import javax.inject.Inject;

import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.presenter.TasksPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class TasksView extends ViewImpl implements TasksPresenter.MyView
{
    // @formatter:off
    interface TasksUi extends UiBinder<Widget, TasksView> {}
    private static TasksUi uiBinder = GWT.create(TasksUi.class);

    @UiField(provided = true) TasksTable tasksTable;
    // @formatter:on

    private final Widget widget;


    @Inject
    public TasksView(final TasksTableResources resources)
    {
        this.tasksTable = new TasksTable(resources);
        widget = uiBinder.createAndBindUi(this);
    }


    @Override
    public Widget asWidget()
    {
        return widget;
    }


    @Override
    public void updateTasks(List<Task> tasks)
    {
        tasksTable.update(tasks);
    }
}