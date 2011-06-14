package biz.accelsis.waitara.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * @author $Author: harald.pehl $
 * @version $Date: 2010-12-22 16:43:49 +0100 (Mi, 22 Dez 2010) $ $Revision: 157
 *          $
 */
// @formatter:off
public interface Resources extends ClientBundle
{
    // -------------------------------------------------------------------- CSS
    
    /**
     * Global CSS rules
     * 
     * @return
     */
    @Source("waitara.css")
    CssResource waitara();


    /**
     * CSS classes to style GWT and custom widgets
     * 
     * @return
     */
    @Source("widgets.css")
    CssResource widgets();
}
