package biz.accelsis.waitara.client;

/**
 * The central location of all name tokens for the application. All
 * {@link com.gwtplatform.mvp.client.proxy.ProxyPlace} classes get their tokens
 * from here. This class also makes it easy to use name tokens as a resource
 * within UIBinder xml files.
 * <p>
 * The public static final String is used within the annotation
 * {@link com.gwtplatform.mvp.client.annotations.NameToken}, which can't use a
 * method and the method associated with this field is used within UiBinder
 * which can't access static fields.
 * <p>
 * Also note the exclamation mark in front of the tokens, this is used for
 * search engine crawling support.
 * 
 * @author $Author: harald.pehl $
 * @version $Date: 2010-09-23 13:52:31 +0200 (Do, 23. Sep 2010) $ $Revision: 88
 *          $
 */
public class NameTokens
{
    public static final String tasks = "!tasks";
    public static final String taskDetail = "!taskDetail";
    public static final String settings = "!settings";
    public static final String help = "!help";
    public static final String about = "!about";


    public static String tasks()
    {
        return tasks;
    }


    public static String taskDetail()
    {
        return taskDetail;
    }


    public static String settings()
    {
        return settings;
    }


    public static String help()
    {
        return help;
    }


    public static String about()
    {
        return about;
    }

}
