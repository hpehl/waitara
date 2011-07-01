package biz.accelsis.waitara.client.tasks.view;

import com.google.gwt.user.cellview.client.CellTable;

public interface TasksTableResources extends CellTable.Resources
{
    public interface TasksTableStyle extends CellTable.Style
    {
        String activeActivity();


        String oddDays();


        String startColumn();


        String durationInHoursColumn();


        String durationFromToColumn();


        String nameColumn();


        String projectColumn();


        String actionColumn();


        String hideActions();
    }


    @Override
    @Source("tasksTable.css")
    TasksTableStyle cellTableStyle();
}
