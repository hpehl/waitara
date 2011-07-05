package biz.accelsis.waitara.client.gin;

import biz.accelsis.waitara.client.about.AboutPresenter;
import biz.accelsis.waitara.client.application.ApplicationPresenter;
import biz.accelsis.waitara.client.help.HelpPresenter;
import biz.accelsis.waitara.client.settings.SettingsPresenter;
import biz.accelsis.waitara.client.tasks.presenter.TaskDetailPresenter;
import biz.accelsis.waitara.client.tasks.presenter.TasksPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
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

    AsyncProvider<AboutPresenter> getAboutPresenter();
    Provider<ApplicationPresenter> getApplicationPresenter();
    AsyncProvider<HelpPresenter> getHelpPresenter();
    AsyncProvider<SettingsPresenter> getSettingsPresenter();
    Provider<TaskDetailPresenter> getTaskDeProvider();
    Provider<TasksPresenter> getTasksPresenter();
}
