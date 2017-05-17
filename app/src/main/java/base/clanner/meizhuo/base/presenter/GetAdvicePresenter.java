package base.clanner.meizhuo.base.presenter;


import java.util.List;

import base.clanner.meizhuo.base.entity.DesignAdvice;
import base.clanner.meizhuo.base.imp.GetAdviceImp;
import base.clanner.meizhuo.base.model.GetAdviceModel;

/**
 * Created by Clanner on 2017/4/19.
 */

public class GetAdvicePresenter {
    private GetAdviceImp getAdviceImp;
    private GetAdviceModel getAdviceModel;

    public GetAdvicePresenter(GetAdviceImp getAdviceImp) {
        this.getAdviceImp = getAdviceImp;
        getAdviceModel = new GetAdviceModel(this);
    }

    public void getAdvice(int pageNo,int pageSize){
        getAdviceModel.getAdvice(pageNo,pageSize);
    }

    public void getAdviceSuccess(List<DesignAdvice> dataBean){
        getAdviceImp.getAdviceSuccess(dataBean);
    }

    public void getAdviceFailure(String message){
        getAdviceImp.getAdviceFailure(message);
    }
}
