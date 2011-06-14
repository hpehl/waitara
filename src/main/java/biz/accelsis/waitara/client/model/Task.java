package biz.accelsis.waitara.client.model;

import java.util.Date;

/**
 * @author $LastChangedBy:$
 * @version $LastChangedRevision:$
 */
public class Task
{
    private final String id;
    private String name;
    private String description;
    private Date dueDate;
    private boolean finished;


    public Task()
    {
        this.id = UUID.uuid();
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


    public String getId()
    {
        return id;
    }
}
