package biz.accelsis.waitara.client.navigation;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * @author $Author: harald.pehl $
 * @version $Date: 2010-12-06 17:48:50 +0100 (Mo, 06. Dez 2010) $ $Revision: 95
 *          $
 */
public class NavigationPresenter extends PresenterWidget<NavigationPresenter.MyView>
{
    public interface MyView extends View
    {
    }


    @Inject
    public NavigationPresenter(final EventBus eventBus, final MyView view)
    {
        super(eventBus, view);
    }
}
