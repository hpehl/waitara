package biz.accelsis.waitara.client.tasks.presenter;

import java.util.List;

import javax.inject.Inject;

import biz.accelsis.waitara.client.NameTokens;
import biz.accelsis.waitara.client.application.ApplicationPresenter;
import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.model.TaskStore;
import biz.accelsis.waitara.client.tasks.view.TaskDetailView;

import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class TaskDetailPresenter extends Presenter<TaskDetailView, TaskDetailPresenter.MyProxy>
{
    @ProxyStandard
    @NameToken(NameTokens.taskDetail)
    public interface MyProxy extends ProxyPlace<TaskDetailPresenter>
    {
    }

    private final PlaceManager placeManager;
    private final TaskStore taskStore;


    @Inject
    public TaskDetailPresenter(EventBus eventBus, TaskDetailView view, MyProxy proxy, PlaceManager placeManager,
            TaskStore taskStore)
    {
        super(eventBus, view, proxy);
        this.placeManager = placeManager;
        this.taskStore = taskStore;
    }


    @Override
    protected void revealInParent()
    {
        RevealContentEvent.fire(this, ApplicationPresenter.TYPE_SetMainContent, this);
    }


    @Override
    public void prepareFromRequest(PlaceRequest request)
    {
        super.prepareFromRequest(request);
        String taskId = request.getParameter("id", null);
        if (taskId != null)
        {
            Task taskToShow = null;
            List<Task> tasks = taskStore.load();
            for (Task task : tasks)
            {
                if (taskId.equals(task.getId()))
                {
                    taskToShow = task;
                    break;
                }
            }
            getView().showTask(taskToShow);
        }
        else
        {
            placeManager.revealErrorPlace(request.getNameToken());
        }
    }
}
