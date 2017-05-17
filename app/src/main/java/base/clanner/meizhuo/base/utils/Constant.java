package base.clanner.meizhuo.base.utils;

/**
 * Created by Clanner on 2017/5/17.
 */

public class Constant {

    public final String base_url = "http://119.29.14.160/Design/";
    public final int SUCCESS = 20000;

    private Constant() {
    }

    public static final Constant getInstance() {
        return ConstantHolder.instance;
    }

    private static final class ConstantHolder {
        private static final Constant instance = new Constant();
    }
}
