package biz.accelsis.waitara.client.tasks.view;

import java.util.List;

import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.presenter.TaskUiHandlers;

import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;

public interface TaskListView extends View, HasUiHandlers<TaskUiHandlers>
{
    void updateTasks(List<Task> tasks);
}
