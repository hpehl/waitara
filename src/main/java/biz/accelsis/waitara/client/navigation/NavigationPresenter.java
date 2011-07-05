package biz.accelsis.waitara.client.navigation;

import javax.inject.Inject;

import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class NavigationPresenter extends PresenterWidget<NavigationPresenter.MyView>
{
    public interface MyView extends View
    {
        void highlight(String token);
    }

    private final PlaceManager placeManager;


    @Inject
    public NavigationPresenter(final EventBus eventBus, final MyView view, final PlaceManager placeManager)
    {
        super(eventBus, view);
        this.placeManager = placeManager;
    }


    @Override
    protected void onReset()
    {
        PlaceRequest request = placeManager.getCurrentPlaceRequest();
        String token = request.getNameToken();
        getView().highlight(token);
    }
}
