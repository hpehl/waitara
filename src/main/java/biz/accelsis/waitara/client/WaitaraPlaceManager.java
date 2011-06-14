package biz.accelsis.waitara.client;


import biz.accelsis.waitara.client.gin.DefaultPlace;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

public class WaitaraPlaceManager extends PlaceManagerImpl
{
    private final PlaceRequest defaultPlaceRequest;


    @Inject
    public WaitaraPlaceManager(EventBus eventBus, TokenFormatter tokenFormatter, @DefaultPlace String defaultNameToken)
    {
        super(eventBus, tokenFormatter);
        this.defaultPlaceRequest = new PlaceRequest(defaultNameToken);
    }


    @Override
    public void revealDefaultPlace()
    {
        revealPlace(defaultPlaceRequest);
    }
}
