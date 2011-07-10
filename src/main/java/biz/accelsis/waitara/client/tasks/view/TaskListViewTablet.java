package biz.accelsis.waitara.client.tasks.view;

import java.util.List;

import biz.accelsis.waitara.client.tasks.event.TaskAction.Action;
import biz.accelsis.waitara.client.tasks.event.TaskActionEvent;
import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.view.ui.TaskListWidget;
import biz.accelsis.waitara.client.ui.FormatUtils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;

public class TaskListViewTablet extends AbstractTaskListView
{
    // @formatter:off
    interface TasksUi extends UiBinder<Widget, TaskListViewTablet> {}
    private static TasksUi uiBinder = GWT.create(TasksUi.class);
    
    @UiField(provided = true) TaskListWidget tasks;
    @UiField LIElement description;
    @UiField LIElement dueDate;
    @UiField LIElement finished;
    // @formatter:on

    @Override
    protected Widget initUi()
    {
        tasks = new TaskListWidget();
        return uiBinder.createAndBindUi(this);
    }


    @Override
    public void updateTasks(List<Task> tasks)
    {
        this.tasks.update(tasks);
    }


    @Override
    @UiHandler("tasks")
    public void onTaskAction(TaskActionEvent event)
    {
        if (event.getAction() == Action.DETAIL)
        {
            Task task = event.getTask();
            if (task != null)
            {
                description.setInnerText("Description: " + task.getDescription());
                if (task.getDueDate() != null)
                {
                    dueDate.setInnerText("Due date: " + FormatUtils.date(task.getDueDate()));
                }
                else
                {
                    dueDate.setInnerText("No due date");
                }
                String entity = task.isFinished() ? "&#9745;" : "&#9744;";
                SafeHtml safeHtml = new SafeHtmlBuilder().appendHtmlConstant(entity).toSafeHtml();
                finished.setInnerHTML("Finished: " + safeHtml.asString());
            }
            else
            {
                description.setInnerText("No description");
                dueDate.setInnerText("No due date");
                SafeHtml safeHtml = new SafeHtmlBuilder().appendHtmlConstant("&#9744;").toSafeHtml();
                finished.setInnerHTML("Finished: " + safeHtml.asString());
            }
        }
    }
}
