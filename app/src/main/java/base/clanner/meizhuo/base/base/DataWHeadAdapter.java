package base.clanner.meizhuo.base.base;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Clanner on 2017/5/17.
 */
public abstract class DataWHeadAdapter<HEAD extends BaseViewHolder,ITEM extends BaseViewHolder, DATA> extends BaseAdapter<HEAD, ITEM, BaseViewHolder, DATA>{
    public DataWHeadAdapter(Context context, int head_layout_id, int layout_id, int foot_layout_id, List<DATA> datas) {
        super(context, head_layout_id, layout_id, foot_layout_id, datas);
    }

    @Override
    protected BaseViewHolder createFootView(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected void bindFootView(BaseViewHolder holder, int position) {
    }
}
