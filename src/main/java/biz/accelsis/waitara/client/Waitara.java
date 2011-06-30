package biz.accelsis.waitara.client;

import biz.accelsis.waitara.client.gin.WaitaraGinjector;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

/**
 * @author $Author: harald.pehl $
 * @version $Revision: 95 $
 */
public class Waitara implements EntryPoint
{
    public final WaitaraGinjector ginjector = GWT.create(WaitaraGinjector.class);


    @Override
    public void onModuleLoad()
    {
        DelayedBindRegistry.bind(ginjector);
        ginjector.getPlaceManager().revealCurrentPlace();
    }
}
