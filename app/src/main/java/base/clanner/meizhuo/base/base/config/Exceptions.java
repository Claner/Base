package base.clanner.meizhuo.base.base.config;

/**
 * Created by Clanner on 2017/2/5.
 */

public class Exceptions {
    public static void illegalArgument(String msg, Object... params)
    {
        throw new IllegalArgumentException(String.format(msg, params));
    }
}
