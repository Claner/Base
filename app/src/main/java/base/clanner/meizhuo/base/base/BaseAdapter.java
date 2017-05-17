package base.clanner.meizhuo.base.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Clanner on 2017/5/17.
 */

public abstract class BaseAdapter<HEAD extends BaseViewHolder, ITEM extends BaseViewHolder, FOOT extends BaseViewHolder, DATA> extends RecyclerView.Adapter<BaseViewHolder> {
    private final int TYPE_HEAD = 1;
    private final int TYPE_NORMAL = 2;
    private final int TYPE_FOOT = 3;
    private final int TYPE_NULL = 4;

    protected Context context;
    protected LayoutInflater inflater;
    protected int normal_layout_id;
    protected int head_layout_id;
    protected int foot_layout_id;
    protected List<DATA> dataList;
    protected View headView;
    protected View itemView;
    protected View footView;
    protected OnLoadMoreListener onLoadMoreListener;

    public BaseAdapter(Context context, int head_layout_id, int layout_id, int foot_layout_id, List<DATA> dataList) {
        this.context = context;
        this.foot_layout_id = foot_layout_id;
        this.head_layout_id = head_layout_id;
        this.normal_layout_id = layout_id;
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEAD:
                headView = inflater.inflate(head_layout_id, parent, false);
                return createHeadView(parent, viewType);
            case TYPE_NORMAL:
                itemView = inflater.inflate(normal_layout_id, parent, false);
                return createItemView(parent, viewType);
            case TYPE_FOOT:
                footView = inflater.inflate(foot_layout_id, parent, false);
                return createFootView(parent, viewType);
            default:
                return new BaseViewHolder(new View(context));
        }
    }

    protected abstract ITEM createItemView(ViewGroup parent, int viewType);

    protected abstract HEAD createHeadView(ViewGroup parent, int viewType);

    protected abstract FOOT createFootView(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (position == 0) {
            if (head_layout_id != 0) bindHeadView((HEAD) holder, 0);
        } else if (position + 1 == getItemCount()) {
            if (foot_layout_id != 0) bindFootView((FOOT) holder, position);
        } else {
            bindItemView((ITEM) holder, dataList.get(position - 1));
        }
    }

    protected abstract void bindItemView(ITEM holder, DATA data);

    protected abstract void bindHeadView(HEAD holder, int position);

    protected abstract void bindFootView(FOOT holder, int position);

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            if (head_layout_id != 0) {
                return TYPE_HEAD;
            } else {
                return TYPE_NULL;
            }
        }
        if (position + 1 == getItemCount()) {
            if (foot_layout_id != 0) {
                return TYPE_FOOT;
            } else {
                return TYPE_NULL;
            }
        }
        return TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return dataList.size() + 2;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public void clearData() {
        if (dataList != null) dataList.clear();
    }

    public void addData(List<DATA> moreList) {
        dataList.addAll(moreList);
    }

    //可手动添加一个加载更多失败的回调
    public interface OnLoadMoreListener {
        void loadMore(BaseViewHolder footHolder);
    }
}
