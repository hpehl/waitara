package biz.accelsis.waitara.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

//@formatter:off
public interface Resources extends ClientBundle
{
    // ----------------------------------------------------------------- images

    ImageResource logo();


    // -------------------------------------------------------------------- CSS

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
    MobileResource mobile();


    public interface MobileResource extends CssResource
    {
        @ClassName("hidden")
        String hidden();
        
        @ClassName("visible")
        String visible();
    }
}
