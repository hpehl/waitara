package biz.accelsis.waitara.client.model;

import java.util.ArrayList;
import java.util.List;

public class TaskFactory
{
    public List<Task> sampleTasks()
    {
        List<Task> tasks = new ArrayList<Task>();
        Task t = new Task();
        t = new Task();
        t = new Task();
        t = new Task();
        t = new Task();
        t = new Task();
        tasks.add(t);
        return tasks;
    }
}
