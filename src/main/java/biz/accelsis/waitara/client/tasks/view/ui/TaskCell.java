package biz.accelsis.waitara.client.tasks.view.ui;

import biz.accelsis.waitara.client.tasks.model.Task;

import com.google.gwt.cell.client.AbstractSafeHtmlCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.SafeHtmlRenderer;

public class TaskCell extends AbstractSafeHtmlCell<Task>
{
    private final TaskCellTable tasksTable;


    public TaskCell(TaskCellTable tasksTable, SafeHtmlRenderer<Task> renderer)
    {
        super(renderer, "click");
        this.tasksTable = tasksTable;
    }


    @Override
    public void onBrowserEvent(Cell.Context context, Element parent, Task value, NativeEvent event,
            ValueUpdater<Task> valueUpdater)
    {
        super.onBrowserEvent(context, parent, value, event, valueUpdater);
        if ("click".equals(event.getType()))
        {
            tasksTable.onDetail(value);
        }
    }


    @Override
    protected void render(Cell.Context context, SafeHtml data, SafeHtmlBuilder sb)
    {
        if (data != null)
        {
            sb.append(data);
        }
    }
}
