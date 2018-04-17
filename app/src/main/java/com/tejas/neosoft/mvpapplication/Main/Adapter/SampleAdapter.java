package com.tejas.neosoft.mvpapplication.Main.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tejas.neosoft.mvpapplication.Main.MainContract;
import com.tejas.neosoft.mvpapplication.Main.model.Datum;
import com.tejas.neosoft.mvpapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webwerks1 on 15/1/18.
 */
public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.MyViewHolder>  {
    private Context context;
    private MainContract.onItemClickListener listener;
    private List<Datum> list = new ArrayList<>();
    public SampleAdapter(Context context, List<Datum> list, MainContract.onItemClickListener listener){
        this.context = context;
        this.list = list;
        this.listener=listener;

    }
    @Override
    public SampleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_1,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(SampleAdapter.MyViewHolder holder, int position) {
        holder.tvCountryName.setText(list.get(position).getFirstName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView tvCountryName;
        public MyViewHolder(final View itemView) {
            super(itemView);
            tvCountryName = (TextView)itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();
                    String clickedDataItem = list.get(pos).getFirstName();
                    listener.showClick("You clicked "+clickedDataItem);
                }
            });
        }



    }
}