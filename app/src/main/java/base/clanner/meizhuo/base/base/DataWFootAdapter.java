package base.clanner.meizhuo.base.base;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Clanner on 2017/5/17.
 */

public abstract class DataWFootAdapter<ITEM extends BaseViewHolder, FOOT extends BaseViewHolder, DATA> extends BaseAdapter<BaseViewHolder, ITEM, FOOT, DATA> {
    public DataWFootAdapter(Context context,  int layout_id, int foot_layout_id, List<DATA> datas) {
        super(context,0, layout_id, foot_layout_id, datas);
    }

    @Override
    protected BaseViewHolder createHeadView(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected void bindHeadView(BaseViewHolder holder, int position) {
    }
}
