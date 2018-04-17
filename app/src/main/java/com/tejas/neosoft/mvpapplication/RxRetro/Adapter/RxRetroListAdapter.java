package com.tejas.neosoft.mvpapplication.RxRetro.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tejas.neosoft.mvpapplication.R;
import com.tejas.neosoft.mvpapplication.RxRetro.RxRetroContract;
import com.tejas.neosoft.mvpapplication.RxRetro.nw.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webwerks1 on 15/1/18.
 */
public class RxRetroListAdapter extends RecyclerView.Adapter<RxRetroListAdapter.MyViewHolder>  {
    private Context context;
    private RxRetroContract.onItemClickListener listener;
    private List<Data> list = new ArrayList<>();
    public RxRetroListAdapter(Context context, List<Data> list, RxRetroContract.onItemClickListener listener){
        this.context = context;
        this.list = list;
        this.listener=listener;

    }
    @Override
    public RxRetroListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_1,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RxRetroListAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getName());
        Log.d("onBindViewHolder", "onBindViewHolder: "+list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView tvName;
        public MyViewHolder(final View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position

                    int pos = getAdapterPosition();
                    String clickedDataItem = list.get(pos).getName();
                    Log.d("MyViewHolder", "onClick: "+clickedDataItem);
                    listener.showClick("You clicked "+clickedDataItem);
                }
            });
        }



    }
}