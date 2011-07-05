package biz.accelsis.waitara.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface Resources extends ClientBundle
{
    @Source("desktop.css")
    DesktopResource desktop();

    public interface DesktopResource extends CssResource
    {
        @ClassName("selectedNavigationEntry")
        String selectedNavigationEntry();
    }


    @Source("tablet.css")
    CssResource tablet();


    @Source("mobile.css")
    CssResource mobile();
}
