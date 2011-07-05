package biz.accelsis.waitara.client.settings;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class SettingsView extends ViewImpl implements SettingsPresenter.MyView
{
    // @formatter:off
    interface HelpUi extends UiBinder<Widget, SettingsView> { }
    private static HelpUi uiBinder = GWT.create(HelpUi.class);
    // @formatter:on

    private final Widget widget;


    public SettingsView()
    {
        widget = uiBinder.createAndBindUi(this);
    }


    @Override
    public Widget asWidget()
    {
        return widget;
    }
}
