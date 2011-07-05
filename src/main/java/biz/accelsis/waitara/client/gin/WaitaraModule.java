package biz.accelsis.waitara.client.gin;

import biz.accelsis.waitara.client.NameTokens;
import biz.accelsis.waitara.client.WaitaraPlaceManager;
import biz.accelsis.waitara.client.about.AboutPresenter;
import biz.accelsis.waitara.client.about.AboutView;
import biz.accelsis.waitara.client.application.ApplicationPresenter;
import biz.accelsis.waitara.client.help.HelpPresenter;
import biz.accelsis.waitara.client.help.HelpView;
import biz.accelsis.waitara.client.navigation.NavigationPresenter;
import biz.accelsis.waitara.client.navigation.NavigationView;
import biz.accelsis.waitara.client.resources.Resources;
import biz.accelsis.waitara.client.settings.SettingsPresenter;
import biz.accelsis.waitara.client.settings.SettingsView;
import biz.accelsis.waitara.client.tasks.model.TaskFactory;
import biz.accelsis.waitara.client.tasks.model.TaskReader;
import biz.accelsis.waitara.client.tasks.model.TaskStore;
import biz.accelsis.waitara.client.tasks.model.TaskWriter;
import biz.accelsis.waitara.client.tasks.presenter.TaskDetailPresenter;
import biz.accelsis.waitara.client.tasks.presenter.TasksPresenter;
import biz.accelsis.waitara.client.tasks.view.TaskDetailView;
import biz.accelsis.waitara.client.tasks.view.TasksView;

import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class WaitaraModule extends AbstractPresenterModule
{
    @Override
    protected void configure()
    {
        // Defaults
        install(new DefaultModule(WaitaraPlaceManager.class));

        // Resources
        bind(Resources.class).in(Singleton.class);

        // JsonReader / Writer
        // Bind them as eager singletons so that the JsonRegistry
        // is setup correctly!
        bind(TaskReader.class).asEagerSingleton();
        bind(TaskWriter.class).asEagerSingleton();

        // Constants
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.tasks);

        // Misc
        bind(TaskFactory.class).in(Singleton.class);
        bind(TaskStore.class).in(Singleton.class);

        // PresenterWidgets (a-z)
        bindPresenterWidget(NavigationPresenter.class, NavigationPresenter.MyView.class, NavigationView.class);

        // Presenters (a-z)
        bindPresenter(AboutPresenter.class, AboutPresenter.MyView.class, AboutView.class, AboutPresenter.MyProxy.class);
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyProxy.class);
        bindPresenter(HelpPresenter.class, HelpPresenter.MyView.class, HelpView.class, HelpPresenter.MyProxy.class);
        bindPresenter(SettingsPresenter.class, SettingsPresenter.MyView.class, SettingsView.class,
                SettingsPresenter.MyProxy.class);
        bindPresenter(TaskDetailPresenter.class, TaskDetailPresenter.MyView.class, TaskDetailView.class,
                TaskDetailPresenter.MyProxy.class);
        bindPresenter(TasksPresenter.class, TasksPresenter.MyView.class, TasksView.class, TasksPresenter.MyProxy.class);
    }
}
