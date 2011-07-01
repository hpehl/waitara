package biz.accelsis.waitara.client.tasks.view;

import biz.accelsis.waitara.client.tasks.model.Task;

import com.google.gwt.view.client.ProvidesKey;

/**
 * @author $LastChangedBy:$
 * @version $LastChangedRevision:$
 */

class TaskKeyProvider implements ProvidesKey<Task>
{
    @Override
    public Object getKey(Task item)
    {
        return item == null ? null : item.getId();
    }
}
