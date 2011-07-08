package biz.accelsis.waitara.client.tasks.view;

import biz.accelsis.waitara.client.tasks.model.Task;

import com.gwtplatform.mvp.client.View;

public interface TaskDetailView extends View
{
    void showTask(Task task);
}
