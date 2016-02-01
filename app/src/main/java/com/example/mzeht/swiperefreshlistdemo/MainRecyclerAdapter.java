package com.example.mzeht.swiperefreshlistdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wpmac on 16/2/1.
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    private List<String> datas = null;
    private OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.mListener = listener;
    }
    public MainRecyclerAdapter(List<String> datas)
    {
        this.datas = datas;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mListener != null)
                {
                    mListener.OnItemClick(v, (String) itemView.getTag());
                }
            }
        });
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        String s = datas.get(position);
        holder.bindData(s);
        holder.itemView.setTag(s);
    }
    @Override
    public int getItemCount()
    {
        return datas.size();
    }
    /**
     * 批量增加
     * */
    public void addItems(List<String> items)
    {
        if (items == null)
            return;
        this.datas.addAll(0, items);
        this.notifyItemRangeInserted(0, items.size());
    }
    public interface OnItemClickListener
    {
        public void OnItemClick(View view,String data);
    }
    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mContent;
        public ViewHolder(View itemView)
        {
            super(itemView);
            mContent = (TextView) itemView.findViewById(R.id.tv);
        }
        public void bindData(String s)
        {
            if (s != null)
                mContent.setText(s);
        }
    }
}
