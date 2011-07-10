package biz.accelsis.waitara.client.tasks.model;

import java.util.List;

import javax.inject.Inject;

import com.google.gwt.storage.client.Storage;

public class TaskStore
{
    final static String TASKS_KEY = "biz.accelsis.waitara.client.tasks";

    private List<Task> cache;
    private final TaskReader reader;
    private final TaskWriter writer;
    private final TaskFactory factory;
    private final Storage storage = Storage.getLocalStorageIfSupported();


    @Inject
    public TaskStore(TaskReader reader, TaskWriter writer, TaskFactory factory)
    {
        this.reader = reader;
        this.writer = writer;
        this.factory = factory;
    }


    public void save(List<Task> tasks)
    {
        if (storage != null)
        {
            String jsonTasks = writer.toJson(tasks, "tasks");
            storage.setItem(TASKS_KEY, jsonTasks);
        }
    }


    public List<Task> load()
    {
        if (cache != null)
        {
            return cache;
        }

        List<Task> tasks = null;
        if (storage != null)
        {
            String jsonTasks = storage.getItem(TASKS_KEY);
            if (jsonTasks != null)
            {
                tasks = reader.readList(jsonTasks);
            }
        }
        if (tasks == null)
        {
            tasks = factory.sampleTasks();
            save(tasks);
        }
        cache = tasks;
        return tasks;
    }
}
