package biz.accelsis.waitara.client.about;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class AboutView extends ViewImpl implements AboutPresenter.MyView
{
    // @formatter:off
    interface AboutUi extends UiBinder<Widget, AboutView> {}
    private static AboutUi uiBinder = GWT.create(AboutUi.class);
    // @formatter:on

    private final Widget widget;


    public AboutView()
    {
        widget = uiBinder.createAndBindUi(this);
    }


    @Override
    public Widget asWidget()
    {
        return widget;
    }
}
