package biz.accelsis.waitara.client.tasks.view;

import biz.accelsis.waitara.client.tasks.model.Task;

import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * @author $LastChangedBy:$
 * @version $LastChangedRevision:$
 */
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
