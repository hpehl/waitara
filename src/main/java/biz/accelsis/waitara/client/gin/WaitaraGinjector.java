package biz.accelsis.waitara.client.gin;

import biz.accelsis.waitara.client.application.ApplicationPresenter;
import biz.accelsis.waitara.client.tasks.TasksPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

/**
 * @author $LastChangedBy: harald.pehl $
 * @version $LastChangedRevision: 173 $
 */
// @formatter:off
@GinModules(WaitaraModule.class)
public interface WaitaraGinjector extends Ginjector
{
    // ------------------------------------------------------------- singletons

    EventBus getEventBus();
    PlaceManager getPlaceManager();

    // ------------------------------------------------------- presenters (a-z)

    Provider<ApplicationPresenter> getApplicationPresenter();
    Provider<TasksPresenter> getTasksPresenter();
}
