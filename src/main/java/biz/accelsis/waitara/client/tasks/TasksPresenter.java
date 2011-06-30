package biz.accelsis.waitara.client.tasks;

import biz.accelsis.waitara.client.NameTokens;
import biz.accelsis.waitara.client.application.ApplicationPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
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
    }


    @Inject
    public TasksPresenter(EventBus eventBus, MyView view, MyProxy proxy)
    {
        super(eventBus, view, proxy);
    }


    @Override
    protected void revealInParent()
    {
        RevealContentEvent.fire(this, ApplicationPresenter.TYPE_SetMainContent, this);
    }
}
