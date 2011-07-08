package biz.accelsis.waitara.client.tasks.view.mobile;

import javax.inject.Inject;

import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.view.TaskDetailView;
import biz.accelsis.waitara.client.ui.FormatUtils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class TaskDetailViewMobile extends ViewImpl implements TaskDetailView
{
    // @formatter:off
    interface TaskDetailUi extends UiBinder<Widget, TaskDetailViewMobile> {}
    private static TaskDetailUi uiBinder = GWT.create(TaskDetailUi.class);

    @UiField LIElement description;
    @UiField LIElement dueDate;
    @UiField LIElement finished;
    // @formatter:on

    private final Widget widget;


    @Inject
    public TaskDetailViewMobile()
    {
        widget = uiBinder.createAndBindUi(this);
    }


    @Override
    public Widget asWidget()
    {
        return widget;
    }


    @Override
    public void showTask(Task task)
    {
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
