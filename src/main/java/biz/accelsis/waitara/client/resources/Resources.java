package biz.accelsis.waitara.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

//@formatter:off
public interface Resources extends ClientBundle
{
    // ----------------------------------------------------------------- images

    ImageResource arrow();
    ImageResource logo();
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource header();


    // -------------------------------------------------------------------- CSS

    @Source("desktop.css")
    DesktopResource desktop();

    public interface DesktopResource extends CssResource
    {
        @ClassName("selected")
        String selected();
    }


    @Source("tablet.css")
    TabletResource tablet();

    public interface TabletResource extends CssResource
    {
    }

    
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
