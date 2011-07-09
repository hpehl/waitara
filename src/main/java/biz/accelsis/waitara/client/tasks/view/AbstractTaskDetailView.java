package biz.accelsis.waitara.client.tasks.view;

import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public abstract class AbstractTaskDetailView extends ViewImpl implements TaskDetailView
{
    private final Widget widget;


    public AbstractTaskDetailView()
    {
        this.widget = initUi();
    }


    protected abstract Widget initUi();


    @Override
    public Widget asWidget()
    {
        return widget;
    }
}
