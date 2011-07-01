package biz.accelsis.waitara.client.tasks.presenter;

import java.util.List;

import javax.inject.Inject;

import biz.accelsis.waitara.client.NameTokens;
import biz.accelsis.waitara.client.application.ApplicationPresenter;
import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.model.TaskStore;

import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

/**
 * @author $Author: harald.pehl $
 * @version $Date: 2010-12-01 22:35:01 +0100 (Mi, 01. Dez 2010) $ $Revision: 85
 *          $
 */
public class TasksPresenter extends Presenter<TasksPresenter.MyView, TasksPresenter.MyProxy>
{
    @ProxyStandard
    @NameToken(NameTokens.tasks)
    public interface MyProxy extends ProxyPlace<TasksPresenter>
    {
    }

    public interface MyView extends View
    {
        void updateTasks(List<Task> tasks);
    }

    private final TaskStore taskStore;


    @Inject
    public TasksPresenter(EventBus eventBus, MyView view, MyProxy proxy, TaskStore taskStore)
    {
        super(eventBus, view, proxy);
        this.taskStore = taskStore;
    }


    @Override
    protected void revealInParent()
    {
        RevealContentEvent.fire(this, ApplicationPresenter.TYPE_SetMainContent, this);
    }


    @Override
    protected void onReset()
    {
        List<Task> tasks = taskStore.load();
        getView().updateTasks(tasks);
    }
}
