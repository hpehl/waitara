package biz.accelsis.waitara.client.tasks.view.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import biz.accelsis.waitara.client.Waitara;
import biz.accelsis.waitara.client.tasks.event.TaskAction;
import biz.accelsis.waitara.client.tasks.event.TaskActionEvent;
import biz.accelsis.waitara.client.tasks.event.TaskActionEvent.TaskActionHandler;
import biz.accelsis.waitara.client.tasks.model.Task;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

public class TaskListWidget extends Widget implements TaskActionEvent.HasTaskActionHandlers
{
    private final UListElement ul;
    private final EventBus eventBus;
    private final List<LIElement> lis;
    private final Map<AnchorElement, Task> links;


    public TaskListWidget()
    {
        this.ul = Document.get().createULElement();
        this.eventBus = Waitara.ginjector.getEventBus();
        this.lis = new ArrayList<LIElement>();
        this.links = new HashMap<AnchorElement, Task>();
        setElement(ul);
        setStyleName("waitara-tasklist");
    }


    @Override
    public HandlerRegistration addTaskActionHandler(TaskActionHandler handler)
    {
        return addHandler(handler, TaskActionEvent.getType());
    }


    public void update(List<Task> tasks)
    {
        links.clear();
        while (ul.hasChildNodes())
        {
            ul.removeChild(ul.getLastChild());
        }
        if (tasks != null)
        {
            for (Task task : tasks)
            {
                LIElement li = Document.get().createLIElement();
                AnchorElement a = Document.get().createAnchorElement();
                a.setInnerText(task.getName());
                DOM.sinkEvents((Element) a.cast(), Event.ONCLICK);
                DOM.setEventListener((Element) a.cast(), this);
                links.put(a, task);
                li.appendChild(a);
                lis.add(li);
                ul.appendChild(li);
            }
        }
    }


    @Override
    public void onBrowserEvent(Event event)
    {
        super.onBrowserEvent(event);
        if (DOM.eventGetType(event) == Event.ONCLICK)
        {
            DOM.eventPreventDefault(event);
            AnchorElement a = event.getEventTarget().cast();
            if (a != null)
            {
                Task task = links.get(a);
                if (task != null)
                {
                    TaskActionEvent.fire(this, task, TaskAction.Action.DETAIL);
                    eventBus.fireEvent(new TaskActionEvent(task, TaskAction.Action.DETAIL));
                    com.google.gwt.dom.client.Element parentElement = a.getParentElement();
                    if (parentElement.getNodeName().equalsIgnoreCase("li"))
                    {
                        LIElement selectedLi = parentElement.cast();
                        for (LIElement li : lis)
                        {
                            if (li == selectedLi)
                            {
                                li.setAttribute("selected", "true");
                            }
                            else
                            {
                                li.removeAttribute("selected");
                            }
                        }
                    }
                }
            }
        }
    }
}
