package com.example.mzeht.swiperefreshlistdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wpmac on 16/2/1.
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    private List<String> datas = null;
    private OnListClickListener mListener;

    public MainRecyclerAdapter(List<String> datas,OnListClickListener l)
    {
        this.datas = datas;
        this.mListener=l;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
//        itemView.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                if(mListener != null)
//                {
//                    mListener.OnItemClick(v, (String) itemView.getTag());
//                }
//            }
//        });
        ViewHolder viewHolder= new ViewHolder(itemView);




        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        String s = datas.get(position);
        holder.bindData(s);
        holder.itemView.setTag(s);
        holder.mContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnItemTextClick(holder.mContent, (String) holder.itemView.getTag());
            }
        });

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnItemIconClick(holder.mImageView, (String) holder.itemView.getTag());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnItemClick(v, (String) holder.itemView.getTag());
            }
        });


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

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mContent;
        private ImageView mImageView;
        public ViewHolder(View itemView)
        {
            super(itemView);
            mContent = (TextView) itemView.findViewById(R.id.tv);
            mImageView= (ImageView) itemView.findViewById(R.id.image);
        }
        public void bindData(String s)
        {
            if (s != null)
                mContent.setText(s);
        }

    }
}
