package biz.accelsis.waitara.client.tasks.view.ui;

import static com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.DISABLED;

import java.util.List;

import biz.accelsis.waitara.client.tasks.event.TaskAction;
import biz.accelsis.waitara.client.tasks.event.TaskActionEvent;
import biz.accelsis.waitara.client.tasks.event.TaskActionEvent.TaskActionHandler;
import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.model.TaskKeyProvider;
import biz.accelsis.waitara.client.ui.FormatUtils;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellTable;

public class TaskCellTable extends CellTable<Task> implements TaskActionEvent.HasTaskActionHandlers
{
    // -------------------------------------------------------- private members

    private final TaskCellTableResources resources;


    // ----------------------------------------------------------- constructors

    public TaskCellTable(final TaskCellTableResources resources)
    {
        super(Integer.MAX_VALUE, resources, new TaskKeyProvider());
        this.resources = resources;

        setRowCount(0);
        setKeyboardSelectionPolicy(DISABLED);
        addColumns();
    }


    // -------------------------------------------------------------- gui setup

    private void addColumns()
    {
        // Column #0: Name
        TaskColumn nameColumn = new TaskColumn(this, new TaskTextRenderer()
        {
            @Override
            protected String getValue(Task task)
            {
                return task.getName();
            }
        });
        addColumnStyleName(0, resources.cellTableStyle().nameColumn());
        addColumn(nameColumn, "Name");

        // Column #1: Description
        TaskColumn descriptionColumn = new TaskColumn(this, new TaskTextRenderer()
        {
            @Override
            protected String getValue(Task task)
            {
                return task.getDescription();
            }
        });
        addColumnStyleName(1, resources.cellTableStyle().descriptionColumn());
        addColumn(descriptionColumn, "Description");

        // Column #2: Due Date
        TaskColumn dueDateColumn = new TaskColumn(this, new TaskTextRenderer()
        {
            @Override
            public String getValue(Task task)
            {
                return FormatUtils.date(task.getDueDate());
            }
        });
        addColumnStyleName(2, resources.cellTableStyle().dueDateColumn());
        addColumn(dueDateColumn, "Due Date");

        // Column #3: Finished
        TaskColumn finishedColumn = new TaskColumn(this, new TaskRenderer()
        {
            @Override
            public SafeHtml render(Task task)
            {
                String entity = task.isFinished() ? "&#9745;" : "&#9744;";
                return new SafeHtmlBuilder().appendHtmlConstant(entity).toSafeHtml();
            }
        });
        addColumnStyleName(3, resources.cellTableStyle().finishedColumn());
        addColumn(finishedColumn, "Finished");
    }


    public void update(List<Task> tasks)
    {
        if (tasks != null)
        {
            setRowData(0, tasks);
            setRowCount(tasks.size());
        }
    }


    // --------------------------------------------------------- event handling

    @Override
    public HandlerRegistration addTaskActionHandler(TaskActionHandler handler)
    {
        return addHandler(handler, TaskActionEvent.getType());
    }


    void onDetail(Task task)
    {
        TaskActionEvent.fire(this, task, TaskAction.Action.DETAIL);
    }
}
