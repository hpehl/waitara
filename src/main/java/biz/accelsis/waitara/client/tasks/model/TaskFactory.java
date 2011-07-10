package biz.accelsis.waitara.client.tasks.model;

import static java.lang.System.currentTimeMillis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskFactory
{
    final int ONE_DAY_IN_MILLIS = 24 * 60 * 60 * 1000;


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
        t.setDueDate(new Date(currentTimeMillis() + 10 * ONE_DAY_IN_MILLIS));
        t.setFinished(false);
        tasks.add(t);

        t = new Task();
        t.setName("Buy birthday gift");
        t.setDescription("What about a photo book?");
        t.setDueDate(new Date(111, 10, 23));
        t.setFinished(false);
        tasks.add(t);

        t = new Task();
        t.setName("Get new RHCP CD");
        t.setDescription("Called \"I'm with you\"");
        t.setDueDate(new Date(111, 7, 26));
        t.setFinished(false);
        tasks.add(t);

        t = new Task();
        t.setName("Dinner with Tina");
        t.setDescription("Try out the new italian restaurant.");
        t.setDueDate(new Date(currentTimeMillis() - 5 * ONE_DAY_IN_MILLIS));
        t.setFinished(true);
        tasks.add(t);

        t = new Task();
        t.setName("Plan holiday trip");
        t.setDescription("What about New Zealand?");
        t.setDueDate(new Date(currentTimeMillis() + 22 * ONE_DAY_IN_MILLIS));
        t.setFinished(false);
        tasks.add(t);

        t = new Task();
        t.setName("St. Pauli tickets");
        t.setDescription("Get them once the new game plan will be published.");
        t.setDueDate(null);
        t.setFinished(false);
        tasks.add(t);

        return tasks;
    }
}
