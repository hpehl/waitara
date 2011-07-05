package biz.accelsis.waitara.client.application;

import javax.inject.Inject;

import biz.accelsis.waitara.client.navigation.NavigationPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;

public class ApplicationPresenter extends Presenter<ApplicationView, ApplicationPresenter.MyProxy>
{
    @ProxyStandard
    public interface MyProxy extends Proxy<ApplicationPresenter>
    {
    }

    @ContentSlot
    public static final Type<RevealContentHandler<?>> TYPE_SetMainContent = new Type<RevealContentHandler<?>>();

    public static final Object SLOT_Navigation = new Object();

    private final NavigationPresenter navigationPresenter;


    @Inject
    public ApplicationPresenter(final EventBus eventBus, final ApplicationView view, final MyProxy proxy,

    final NavigationPresenter navigationPresenter)
    {
        super(eventBus, view, proxy);
        this.navigationPresenter = navigationPresenter;
    }


    @Override
    protected void revealInParent()
    {
        RevealRootLayoutContentEvent.fire(this, this);
    }


    @Override
    protected void onReveal()
    {
        setInSlot(SLOT_Navigation, navigationPresenter);
    }
}
