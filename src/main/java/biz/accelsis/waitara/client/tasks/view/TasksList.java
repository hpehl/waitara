package biz.accelsis.waitara.client.tasks.view;

import java.util.List;

import biz.accelsis.waitara.client.tasks.event.TaskActionEvent;
import biz.accelsis.waitara.client.tasks.event.TaskActionEvent.TaskActionHandler;
import biz.accelsis.waitara.client.tasks.model.Task;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

public class TasksList extends Widget implements TaskActionEvent.HasTaskActionHandlers
{
    private final UListElement ul;


    public TasksList()
    {
        ul = Document.get().createULElement();
        setElement(ul);
    }


    @Override
    public HandlerRegistration addTaskActionHandler(TaskActionHandler handler)
    {
        return addHandler(handler, TaskActionEvent.getType());
    }


    void update(List<Task> tasks)
    {
        NodeList<Node> children = ul.getChildNodes();
        if (children.getLength() != 0)
        {
            for (int i = 0; i < children.getLength(); i++)
            {
                Node li = children.getItem(i);
                li.removeFromParent();
            }
        }
        if (tasks != null)
        {
            for (Task task : tasks)
            {
                LIElement li = Document.get().createLIElement();
                AnchorElement a = Document.get().createAnchorElement();
                a.setInnerText(task.getName());
                li.appendChild(a);
                ul.appendChild(li);
            }
        }
    }
}
