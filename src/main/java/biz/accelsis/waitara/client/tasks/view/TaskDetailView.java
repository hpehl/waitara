package biz.accelsis.waitara.client.tasks.view;

import javax.inject.Inject;

import biz.accelsis.waitara.client.tasks.model.Task;
import biz.accelsis.waitara.client.tasks.presenter.TaskDetailPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class TaskDetailView extends ViewImpl implements TaskDetailPresenter.MyView
{
    // @formatter:off
    interface TaskDetailUi extends UiBinder<Widget, TaskDetailView> {}
    private static TaskDetailUi uiBinder = GWT.create(TaskDetailUi.class);
    
    @UiField HeadingElement header;
    // @formatter:on

    private final Widget widget;


    @Inject
    public TaskDetailView()
    {
        widget = uiBinder.createAndBindUi(this);
    }


    @Override
    public Widget asWidget()
    {
        return widget;
    }


    @Override
    public void showTask(Task task)
    {
        String text = "Unknown Task";
        if (task != null)
        {
            text = "Details for task '" + task.getName() + "'";
        }
        header.setInnerText(text);
    }
}
