package biz.accelsis.waitara.client.application.view;

import java.util.List;

import biz.accelsis.waitara.client.tasks.model.Task;

import com.gwtplatform.mvp.client.View;

public interface ApplicationView extends View
{
    void highlight(String token);


    void taskList(List<Task> tasks);


    void taskDetail(Task task);
}
