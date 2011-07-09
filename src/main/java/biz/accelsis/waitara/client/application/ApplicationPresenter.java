package biz.accelsis.waitara.client.application;

import java.util.List;

import javax.inject.Inject;

import biz.accelsis.waitara.client.NameTokens;
import biz.accelsis.waitara.client.tasks.event.TaskAction.Action;
import biz.accelsis.waitara.client.tasks.event.TaskActionEvent;
import biz.accelsis.waitara.client.tasks.event.TaskActionEvent.TaskActionHandler;
import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.model.TaskStore;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;

public class ApplicationPresenter extends Presenter<ApplicationView, ApplicationPresenter.MyProxy> implements
        TaskActionHandler
{
    @ProxyStandard
    public interface MyProxy extends Proxy<ApplicationPresenter>
    {
    }

    @ContentSlot
    public static final Type<RevealContentHandler<?>> TYPE_SetMainContent = new Type<RevealContentHandler<?>>();

    private final PlaceManager placeManager;
    private final TaskStore taskStore;


    @Inject
    public ApplicationPresenter(final EventBus eventBus, final ApplicationView view, final MyProxy proxy,
            final PlaceManager placeManager, final TaskStore taskStore)
    {
        super(eventBus, view, proxy);
        this.placeManager = placeManager;
        this.taskStore = taskStore;
        getEventBus().addHandler(TaskActionEvent.getType(), this);
    }


    @Override
    protected void revealInParent()
    {
        RevealRootLayoutContentEvent.fire(this, this);
    }


    @Override
    protected void onReset()
    {
        PlaceRequest request = placeManager.getCurrentPlaceRequest();
        String token = request.getNameToken();
        getView().highlight(token);
        if (NameTokens.tasks.equals(token))
        {
            List<Task> tasks = taskStore.load();
            getView().taskList(tasks);
        }
    }


    @Override
    public void onTaskAction(TaskActionEvent event)
    {
        if (event.getAction() == Action.DETAIL)
        {
            getView().taskDetail(event.getTask());
        }
    }
}
