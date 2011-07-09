package biz.accelsis.waitara.client.tasks.model;

import com.google.gwt.view.client.ProvidesKey;

public class TaskKeyProvider implements ProvidesKey<Task>
{
    @Override
    public Object getKey(Task item)
    {
        return item == null ? null : item.getId();
    }
}
