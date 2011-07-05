package biz.accelsis.waitara.client.help;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class HelpView extends ViewImpl implements HelpPresenter.MyView
{
    // @formatter:off
    interface HelpUi extends UiBinder<Widget, HelpView> {}
    private static HelpUi uiBinder = GWT.create(HelpUi.class);
    // @formatter:on

    private final Widget widget;


    public HelpView()
    {
        widget = uiBinder.createAndBindUi(this);
    }


    @Override
    public Widget asWidget()
    {
        return widget;
    }
}
