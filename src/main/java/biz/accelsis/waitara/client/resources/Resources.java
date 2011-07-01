package biz.accelsis.waitara.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * @author $Author: harald.pehl $
 * @version $Date: 2010-12-22 16:43:49 +0100 (Mi, 22 Dez 2010) $ $Revision: 157
 *          $
 */
public interface Resources extends ClientBundle
{
    // -------------------------------------------------------------------- CSS

    /**
     * Global CSS rules for desktop version
     * 
     * @return
     */
    @Source("desktop.css")
    DesktopResource desktop();

    public interface DesktopResource extends CssResource
    {
        @ClassName("selectedNavigationEntry")
        String selectedNavigationEntry();
    }


    /**
     * Global CSS rules for tablet version
     * 
     * @return
     */
    @Source("tablet.css")
    CssResource tablet();


    /**
     * Global CSS rules for mobile version
     * 
     * @return
     */
    @Source("mobile.css")
    CssResource mobile();
}
