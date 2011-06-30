package biz.accelsis.waitara.client.gin;

import biz.accelsis.waitara.client.NameTokens;
import biz.accelsis.waitara.client.WaitaraPlaceManager;
import biz.accelsis.waitara.client.application.ApplicationPresenter;
import biz.accelsis.waitara.client.application.ApplicationViewDesktop;
import biz.accelsis.waitara.client.navigation.NavigationPresenter;
import biz.accelsis.waitara.client.navigation.NavigationView;
import biz.accelsis.waitara.client.resources.Resources;
import biz.accelsis.waitara.client.tasks.TasksPresenter;
import biz.accelsis.waitara.client.tasks.TasksView;

import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

/**
 * @author $LastChangedBy: harald.pehl $
 * @version $LastChangedRevision: 202 $
 */
public class WaitaraModule extends AbstractPresenterModule
{
    @Override
    protected void configure()
    {
        // Defaults
        install(new DefaultModule(WaitaraPlaceManager.class));

        // Resources
        bind(Resources.class).in(Singleton.class);

        // Constants
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.tasks);

        // PresenterWidgets (a-z)
        bindPresenterWidget(NavigationPresenter.class, NavigationPresenter.MyView.class, NavigationView.class);

        // Presenters (a-z)
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationViewDesktop.class,
                ApplicationPresenter.MyProxy.class);
        bindPresenter(TasksPresenter.class, TasksPresenter.MyView.class, TasksView.class, TasksPresenter.MyProxy.class);
    }
}
