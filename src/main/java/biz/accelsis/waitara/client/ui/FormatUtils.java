package biz.accelsis.waitara.client.ui;

import java.util.Date;

import biz.accelsis.waitara.client.Defaults;

public final class FormatUtils
{
    private FormatUtils()
    {
    }


    public static String date(Date date)
    {
        if (date != null)
        {
            return Defaults.DATE_FORMAT.format(date);
        }
        return "";
    }
}
