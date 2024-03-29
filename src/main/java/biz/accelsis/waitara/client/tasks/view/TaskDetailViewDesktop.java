package biz.accelsis.waitara.client.tasks.view;

import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.ui.FormatUtils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;

public class TaskDetailViewDesktop extends AbstractTaskDetailView
{
    // @formatter:off
    interface TaskDetailUi extends UiBinder<Widget, TaskDetailViewDesktop> {}
    private static TaskDetailUi uiBinder = GWT.create(TaskDetailUi.class);
    
    @UiField HeadingElement header;
    @UiField InlineLabel name;
    @UiField InlineLabel description;
    @UiField InlineLabel dueDate;
    @UiField HTML finished;
    // @formatter:on

    @Override
    protected Widget initUi()
    {
        return uiBinder.createAndBindUi(this);
    }


    @Override
    public void showTask(Task task)
    {
        if (task != null)
        {
            header.setInnerText("Details for task '" + task.getName() + "'");
            name.setText(task.getName());
            description.setText(task.getDescription());
            if (task.getDueDate() != null)
            {
                dueDate.setText(FormatUtils.date(task.getDueDate()));
            }
            else
            {
                dueDate.setText("No due date specified");
            }
            String entity = task.isFinished() ? "&#9745;" : "&#9744;";
            SafeHtml safeHtml = new SafeHtmlBuilder().appendHtmlConstant(entity).toSafeHtml();
            finished.setHTML(safeHtml);
        }
        else
        {
            header.setInnerText("Unknown Task");
            name.setText("");
            description.setText("");
            dueDate.setText("");
            finished.setText("");
        }
    }
}
