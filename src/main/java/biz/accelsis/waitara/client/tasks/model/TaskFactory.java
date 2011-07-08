package biz.accelsis.waitara.client.tasks.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskFactory
{
    @SuppressWarnings("deprecation")
    public List<Task> sampleTasks()
    {
        List<Task> tasks = new ArrayList<Task>();
        Task t = new Task();
        t = new Task();
        t.setName("Buy milk");
        t.setDescription("But please no low fat!");
        t.setDueDate(null);
        t.setFinished(true);
        tasks.add(t);

        t = new Task();
        t.setName("Write article");
        t.setDescription("Don't forget to add the MVP diagram");
        t.setDueDate(new Date(System.currentTimeMillis() + 10 * 24 * 60 * 60 * 1000));
        t.setFinished(false);
        tasks.add(t);

        t = new Task();
        t.setName("Buy birthday gift");
        t.setDescription("What about a photo book?");
        t.setDueDate(new Date(111, 10, 23));
        t.setFinished(false);
        tasks.add(t);

        return tasks;
    }
}
