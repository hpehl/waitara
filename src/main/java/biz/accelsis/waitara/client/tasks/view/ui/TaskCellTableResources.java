package biz.accelsis.waitara.client.tasks.view.ui;

import com.google.gwt.user.cellview.client.CellTable;

public interface TaskCellTableResources extends CellTable.Resources
{
    public interface TaskCellTableStyle extends CellTable.Style
    {
        String nameColumn();


        String descriptionColumn();


        String dueDateColumn();


        String finishedColumn();
    }


    @Override
    @Source("taskCellTable.css")
    TaskCellTableStyle cellTableStyle();
}
