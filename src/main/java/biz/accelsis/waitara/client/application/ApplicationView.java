package biz.accelsis.waitara.client.application;

import biz.accelsis.waitara.client.tasks.model.Task;

import com.gwtplatform.mvp.client.View;

public interface ApplicationView extends View
{
    void highlight(String token);


    void taskList();


    void taskDetail(Task task);
}
