package com.example.recyclerdemo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerdemo.R;
import com.example.recyclerdemo.database.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private List<Item> mList;
    private Context mContext;
    private final LayoutInflater layoutInflater;

    public ItemAdapter(Context mContext) {
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = layoutInflater.inflate(R.layout.list_item,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        if(mList!=null){
            Item item = mList.get(position);
            myViewHolder.setData(item.getmNote(), position);
        }else{
            myViewHolder.mTextItem.setText(mContext.getResources().getString(R.string.no_data));
        }
    }

    public void updateItems(List<Item> updatedList){
        this.mList = updatedList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList!=null?mList.size():0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
      private TextView mTextItem;
      private int mPosition;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextItem = itemView.findViewById(R.id.tv_item);
        }

        public void setData(String note, int position) {
          mTextItem.setText(note);
          mPosition = position;
        }
    }
}
