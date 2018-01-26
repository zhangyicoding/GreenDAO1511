package net.bwie.greendao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.bwie.greendao.R;
import net.bwie.greendao.bean.UserBean;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context mContext;
    private List<UserBean> mDatas;

    public UserAdapter(Context context) {
        mContext = context;
    }

    // 添加数据
    public void addDatas(List<UserBean> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    // 替换数据
    public void setDatas(List<UserBean> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.item_user, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserBean user = mDatas.get(position);

        holder.mAccountTextView.setText(user.getAccount());
        holder.mPasswordTextView.setText(user.getPassword());
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mAccountTextView;
        TextView mPasswordTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            mAccountTextView = itemView.findViewById(R.id.account_tv);
            mPasswordTextView = itemView.findViewById(R.id.password_tv);
        }
    }

}
