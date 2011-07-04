package biz.accelsis.waitara.client.tasks.model;

import java.util.Date;

import biz.accelsis.waitara.client.model.UUID;

/**
 * @author $LastChangedBy:$
 * @version $LastChangedRevision:$
 */
public class Task
{
    private String id;
    private String name;
    private String description;
    private Date dueDate;
    private boolean finished;


    Task()
    {
        this.id = UUID.uuid();
    }


    public Task(String name, String description)
    {
        this();
        this.name = name;
        this.description = description;
    }


    @Override
    public String toString()
    {
        return "Task [" + name + "]";
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public Date getDueDate()
    {
        return dueDate;
    }


    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }


    public boolean isFinished()
    {
        return finished;
    }


    public void setFinished(boolean finished)
    {
        this.finished = finished;
    }


    protected void setId(String id)
    {
        this.id = id;
    }


    public String getId()
    {
        return id;
    }
}
