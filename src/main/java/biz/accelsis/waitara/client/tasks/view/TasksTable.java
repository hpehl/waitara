package biz.accelsis.waitara.client.tasks.view;

import static com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.DISABLED;

import java.util.List;

import biz.accelsis.waitara.client.tasks.event.TaskAction;
import biz.accelsis.waitara.client.tasks.event.TaskActionEvent;
import biz.accelsis.waitara.client.tasks.event.TaskActionEvent.HasTaskActionHandlers;
import biz.accelsis.waitara.client.tasks.event.TaskActionEvent.TaskActionHandler;
import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.ui.FormatUtils;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.cellview.client.CellTable;

/**
 * @author $LastChangedBy:$
 * @version $LastChangedRevision:$
 */
public class TasksTable extends CellTable<Task> implements HasTaskActionHandlers
{
    // -------------------------------------------------------- private members

    private final TasksTableResources resources;


    // ----------------------------------------------------------- constructors

    public TasksTable(final TasksTableResources resources)
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
        addColumnStyleName(0, resources.cellTableStyle().startColumn());
        addColumn(nameColumn);

        // Column #1: Description
        TaskColumn descriptionColumn = new TaskColumn(this, new TaskTextRenderer()
        {
            @Override
            protected String getValue(Task task)
            {
                return task.getDescription();
            }
        });
        addColumnStyleName(1, resources.cellTableStyle().durationFromToColumn());
        addColumn(descriptionColumn);

        // Column #2: Due Date
        TaskColumn dueDateColumn = new TaskColumn(this, new TaskTextRenderer()
        {
            @Override
            public String getValue(Task task)
            {
                return FormatUtils.date(task.getDueDate());
            }
        });
        addColumnStyleName(2, resources.cellTableStyle().durationInHoursColumn());
        addColumn(dueDateColumn);
    }


    // --------------------------------------------------------- public methods

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


    public void onEdit(int rowIndex, Task task)
    {
        TaskActionEvent.fire(this, rowIndex, task, TaskAction.Action.EDIT);
    }
}
