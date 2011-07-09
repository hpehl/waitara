package biz.accelsis.waitara.client.application.mobile;

import java.util.List;

import biz.accelsis.waitara.client.application.AbstractApplicationView;
import biz.accelsis.waitara.client.resources.Resources;
import biz.accelsis.waitara.client.tasks.model.Task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationViewMobile extends AbstractApplicationView
{
    // @formatter:off
    interface ApplicationUi extends UiBinder<Widget, ApplicationViewMobile> {}
    private static ApplicationUi uiBinder = GWT.create(ApplicationUi.class);
    
    @UiField HeadingElement header;
    @UiField InlineHyperlink tasks;
    // @formatter:on

    @Override
    protected void injectCss(Resources resources)
    {
        resources.mobile().ensureInjected();

    }


    @Override
    protected Widget initUi()
    {
        return uiBinder.createAndBindUi(this);
    }


    @Override
    public void taskList(List<Task> tasks)
    {
        header.setInnerText("Waitara Task Management");
        this.tasks.removeStyleName(resources.mobile().visible());
        this.tasks.addStyleName(resources.mobile().hidden());
    }


    @Override
    public void taskDetail(Task task)
    {
        header.setInnerText(task.getName());
        tasks.removeStyleName(resources.mobile().hidden());
        tasks.addStyleName(resources.mobile().visible());
    }
}
