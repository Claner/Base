package base.clanner.meizhuo.base.adapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

import base.clanner.meizhuo.base.base.DataAdapter;
import base.clanner.meizhuo.base.entity.DesignAdvice;
import base.clanner.meizhuo.base.viewholder.AdviceViewHolder;

/**
 * Created by Clanner on 2017/5/17.
 */

public class DesignAdviceAdapter extends DataAdapter<AdviceViewHolder, DesignAdvice> {
    public DesignAdviceAdapter(Context context, int layout_id, List<DesignAdvice> designAdvices) {
        super(context, layout_id, designAdvices);
    }

    @Override
    protected AdviceViewHolder createItemView(ViewGroup parent, int viewType) {
        return new AdviceViewHolder(itemView);
    }

    @Override
    protected void bindItemView(AdviceViewHolder holder, DesignAdvice designAdvice) {
        holder.title.setText(designAdvice.getTitle());
        holder.itemView.setTag(designAdvice);
    }
}
