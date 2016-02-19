package com.qf1514.wateractivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by Administrator on 2016/1/19.
 */
public class MyWaterAdapter extends RecyclerView.Adapter<MyWaterAdapter.MyHolder> {
    private List<Bitmap> list;
    private Context context;

    public MyWaterAdapter(List<Bitmap> list, Context context) {
        this.list = list;
        this.context = context;
    }

    /**
     * 给recyclerView绑定布局。
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    /**
     * 让图片显示在recyclerView上
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.iv.setImageBitmap(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        ImageView iv;
        LinearLayout ll;

        public MyHolder(View itemView) {
            super(itemView);
            ll = (LinearLayout) itemView;
            iv = (ImageView) itemView.findViewById(R.id.iv_item);
            ll.setOnLongClickListener(this);
        }

        /**
         * 长点击某张图片，然后实现删除该图片
         *
         * @param v
         * @return
         */
        @Override
        public boolean onLongClick(View v) {
            int position = getLayoutPosition();
            removeData(position);
            return false;
        }
    }

    /*
    *删除图片的方法
    * adapter一定是要实现notifyItemRemoved方法进行刷新，不是notifydatachange
     */
    private void removeData(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }
}
