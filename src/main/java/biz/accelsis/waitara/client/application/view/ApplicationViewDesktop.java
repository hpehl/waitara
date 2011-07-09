package biz.accelsis.waitara.client.application.view;

import biz.accelsis.waitara.client.resources.Resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationViewDesktop extends AbstractApplicationView
{
    // @formatter:off
    interface ApplicationUi extends UiBinder<Widget, ApplicationViewDesktop> {}
    private static ApplicationUi uiBinder = GWT.create(ApplicationUi.class);

    @UiField InlineHyperlink tasks;
    @UiField InlineHyperlink settings;
    @UiField InlineHyperlink help;
    @UiField InlineHyperlink about;
    // @formatter:on

    final InlineHyperlink[] navigationLinks;


    public ApplicationViewDesktop()
    {
        super();
        this.navigationLinks = new InlineHyperlink[] {tasks, settings, help, about,};
    }


    @Override
    protected void injectCss(Resources resources)
    {
        resources.desktop().ensureInjected();

    }


    @Override
    protected Widget initUi()
    {
        return uiBinder.createAndBindUi(this);
    }


    @Override
    public void highlight(String token)
    {
        if (token != null)
        {
            for (InlineHyperlink link : navigationLinks)
            {
                if (link != null)
                {
                    if (token.equals(link.getTargetHistoryToken()))
                    {
                        link.addStyleName(resources.desktop().selectedNavigationEntry());
                    }
                    else
                    {
                        link.removeStyleName(resources.desktop().selectedNavigationEntry());
                    }
                }
            }
        }
    }
}
