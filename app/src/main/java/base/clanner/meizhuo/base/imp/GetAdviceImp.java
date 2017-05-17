package base.clanner.meizhuo.base.imp;


import java.util.List;

import base.clanner.meizhuo.base.entity.DesignAdvice;

/**
 * Created by Clanner on 2017/4/19.
 */

public interface GetAdviceImp {
    void getAdvice();

    void getAdviceSuccess(List<DesignAdvice> dataBean);

    void getAdviceFailure(String message);
}
