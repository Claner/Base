package base.clanner.meizhuo.base.base;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Clanner on 2017/5/17.
 */

public abstract class DataAdapter<ITEM extends BaseViewHolder, DATA> extends BaseAdapter<BaseViewHolder, ITEM, BaseViewHolder, DATA> {

    public DataAdapter(Context context, int layout_id, List<DATA> datas) {
        super(context, 0, layout_id, 0, datas);
    }

    @Override
    protected BaseViewHolder createHeadView(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected BaseViewHolder createFootView(ViewGroup parent, int viewType) {
        return null;
    }


    @Override
    protected void bindHeadView(BaseViewHolder holder, int position) {
    }

    @Override
    protected void bindFootView(BaseViewHolder holder, int position) {
    }
}
