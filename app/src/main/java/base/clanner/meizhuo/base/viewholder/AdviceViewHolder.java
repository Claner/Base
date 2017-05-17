package base.clanner.meizhuo.base.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import base.clanner.meizhuo.base.R;
import base.clanner.meizhuo.base.base.BaseViewHolder;
import butterknife.BindView;

/**
 * Created by Clanner on 2017/5/17.
 */

public class AdviceViewHolder extends BaseViewHolder {

    @BindView(R.id.advice_title)
    public TextView title;
    @BindView(R.id.advice_cover)
    public ImageView cover;
    @BindView(R.id.advice_time)
    public TextView time;

    public AdviceViewHolder(View itemView) {
        super(itemView);
    }
}
