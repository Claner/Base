package base.clanner.meizhuo.base.model;

import base.clanner.meizhuo.base.base.BaseEntity;
import base.clanner.meizhuo.base.entity.DesignAdvice;
import base.clanner.meizhuo.base.presenter.GetAdvicePresenter;
import base.clanner.meizhuo.base.utils.Constant;
import base.clanner.meizhuo.base.utils.RetrofitManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Clanner on 2017/4/19.
 */

public class GetAdviceModel {
    private GetAdvicePresenter getAdvicePresenter;

    public GetAdviceModel(GetAdvicePresenter getAdvicePresenter) {
        this.getAdvicePresenter = getAdvicePresenter;
    }

    public void getAdvice(int pageNo, int pageSize) {
        RetrofitManager.getRetrofit().create(GetAdviceImp.class)
                .addParams(pageNo, pageSize).enqueue(new Callback<BaseEntity<Object, DesignAdvice>>() {
            @Override
            public void onResponse(Call<BaseEntity<Object, DesignAdvice>> call, Response<BaseEntity<Object, DesignAdvice>> response) {
                if (response.body() == null) {
                    getAdvicePresenter.getAdviceFailure("解析json失败");
                    return;
                }
                if (response.body().getCode() == Constant.getInstance().SUCCESS) {
                    getAdvicePresenter.getAdviceSuccess(response.body().getDataList());
                } else {
                    getAdvicePresenter.getAdviceFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<BaseEntity<Object, DesignAdvice>> call, Throwable t) {
                getAdvicePresenter.getAdviceFailure("获取设计咨询失败，请检查网络连接");
            }
        });
    }

    private interface GetAdviceImp {
        @FormUrlEncoded
        @POST("Home/DesignAdvice/showDesignAdvice")
        Call<BaseEntity<Object, DesignAdvice>> addParams(@Field("pageNo") int pageNo,
                                                         @Field("pageSize") int pageSize);
    }
}
