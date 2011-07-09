package biz.accelsis.waitara.client.tasks.view.ui;

import biz.accelsis.waitara.client.tasks.model.Task;

import com.google.gwt.safehtml.shared.SafeHtml;

public abstract class TaskTextRenderer extends TaskRenderer
{
    @Override
    public SafeHtml render(Task activity)
    {
        String value = getValue(activity);
        return toSafeHtml(value);
    }


    protected abstract String getValue(Task task);
}
