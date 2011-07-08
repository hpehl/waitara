package biz.accelsis.waitara.client.tasks.event;

import biz.accelsis.waitara.client.tasks.model.Task;

import com.gwtplatform.dispatch.annotation.GenEvent;
import com.gwtplatform.dispatch.annotation.Order;

@GenEvent
public class TaskAction
{
    public static enum Action
    {
        DETAIL,
        EDIT,
        DELETE
    }

    @Order(1)
    Task task;

    @Order(2)
    Action action;
}
