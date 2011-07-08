package biz.accelsis.waitara.client.tasks.presenter;

import java.util.List;

import javax.inject.Inject;

import biz.accelsis.waitara.client.NameTokens;
import biz.accelsis.waitara.client.application.ApplicationPresenter;
import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.model.TaskStore;
import biz.accelsis.waitara.client.tasks.view.TaskListView;

import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class TaskListPresenter extends Presenter<TaskListView, TaskListPresenter.MyProxy> implements TaskUiHandlers
{
    @ProxyStandard
    @NameToken(NameTokens.tasks)
    public interface MyProxy extends ProxyPlace<TaskListPresenter>
    {
    }

    private final PlaceManager placeManager;
    private final TaskStore taskStore;


    @Inject
    public TaskListPresenter(final EventBus eventBus, final TaskListView view, final MyProxy proxy,
            final PlaceManager placeManager, final TaskStore taskStore)
    {
        super(eventBus, view, proxy);
        this.placeManager = placeManager;
        this.taskStore = taskStore;
        getView().setUiHandlers(this);
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


    @Override
    public void onDetail(Task task)
    {
        if (task != null)
        {
            PlaceRequest request = new PlaceRequest(NameTokens.taskDetail).with("id", task.getId());
            placeManager.revealPlace(request);
        }
    }
}
