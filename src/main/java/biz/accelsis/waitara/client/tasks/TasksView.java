package biz.accelsis.waitara.client.tasks;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class TasksView extends ViewImpl implements TasksPresenter.MyView
{
    // @formatter:off
    interface TasksUi extends UiBinder<Widget, TasksView> {}
    private static TasksUi uiBinder = GWT.create(TasksUi.class);
    // @formatter:on

    private final Widget widget;


    public TasksView()
    {
        widget = uiBinder.createAndBindUi(this);
    }


    @Override
    public Widget asWidget()
    {
        return widget;
    }
}
