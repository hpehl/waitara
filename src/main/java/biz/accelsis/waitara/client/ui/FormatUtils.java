package biz.accelsis.waitara.client.ui;

import java.util.Date;

import biz.accelsis.waitara.client.Defaults;

/**
 * @author $Author: harald.pehl $
 * @version $Date: 2010-12-03 16:50:33 +0100 (Fr, 03. Dez 2010) $ $Revision: 173
 *          $
 */
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
