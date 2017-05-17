package base.clanner.meizhuo.base.adapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

import base.clanner.meizhuo.base.base.BaseAdapter;
import base.clanner.meizhuo.base.entity.DesignAdvice;
import base.clanner.meizhuo.base.viewholder.AdviceViewHolder;
import base.clanner.meizhuo.base.viewholder.FootViewHolder;
import base.clanner.meizhuo.base.viewholder.HeadViewHolder;

/**
 * Created by Clanner on 2017/5/17.
 */

public class DesignAdviceWithHeadAndFoot extends BaseAdapter<HeadViewHolder,AdviceViewHolder,FootViewHolder,DesignAdvice>{

    public DesignAdviceWithHeadAndFoot(Context context, int foot_layout_id, int head_layout_id, int layout_id, List<DesignAdvice> designAdvices) {
        super(context, foot_layout_id, head_layout_id, layout_id, designAdvices);
    }

    @Override
    protected AdviceViewHolder createItemView(ViewGroup parent, int viewType) {
        return new AdviceViewHolder(itemView);
    }

    @Override
    protected HeadViewHolder createHeadView(ViewGroup parent, int viewType) {
        return new HeadViewHolder(headView);
    }

    @Override
    protected FootViewHolder createFootView(ViewGroup parent, int viewType) {
        return new FootViewHolder(footView);
    }

    @Override
    protected void bindItemView(AdviceViewHolder holder, DesignAdvice designAdvice) {
        holder.title.setText(designAdvice.getTitle());
        holder.itemView.setTag(designAdvice);
    }

    @Override
    protected void bindHeadView(HeadViewHolder holder, int position) {

    }

    @Override
    protected void bindFootView(FootViewHolder holder, int position) {

    }
}
