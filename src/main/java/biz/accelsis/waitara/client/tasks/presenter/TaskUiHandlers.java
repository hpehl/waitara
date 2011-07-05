package biz.accelsis.waitara.client.tasks.presenter;

import biz.accelsis.waitara.client.tasks.model.Task;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * @author $LastChangedBy:$
 * @version $LastChangedRevision:$
 */
public interface TaskUiHandlers extends UiHandlers
{
    void onDetail(Task task);
}
