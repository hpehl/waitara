package biz.accelsis.waitara.client.tasks.view.desktop;

import biz.accelsis.waitara.client.tasks.model.Task;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import com.google.gwt.user.cellview.client.Column;

public class TaskColumn extends Column<Task, Task>
{
    public TaskColumn(Cell<Task> cell)
    {
        super(cell);
    }


    public TaskColumn(TaskTable tasksTable, SafeHtmlRenderer<Task> renderer)
    {
        super(new TaskCell(tasksTable, renderer));
    }


    @Override
    public Task getValue(Task object)
    {
        return object;
    }
}
