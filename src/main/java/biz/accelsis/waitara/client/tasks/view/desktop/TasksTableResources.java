package biz.accelsis.waitara.client.tasks.view.desktop;

import com.google.gwt.user.cellview.client.CellTable;

public interface TasksTableResources extends CellTable.Resources
{
    public interface TasksTableStyle extends CellTable.Style
    {
        String nameColumn();


        String descriptionColumn();


        String dueDateColumn();


        String finishedColumn();
    }


    @Override
    @Source("tasksTable.css")
    TasksTableStyle cellTableStyle();
}
