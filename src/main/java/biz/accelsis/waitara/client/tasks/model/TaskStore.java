package biz.accelsis.waitara.client.tasks.model;

import java.util.List;

/**
 * @author $LastChangedBy:$
 * @version $LastChangedRevision:$
 */
public class TaskStore
{
    final static String TASKS_KEY = "biz.accelsis.waitara.client.tasks";


    public void save(List<Task> tasks)
    {

    }


    public List<Task> load()
    {
        return new TaskFactory().sampleTasks();
    }
}
