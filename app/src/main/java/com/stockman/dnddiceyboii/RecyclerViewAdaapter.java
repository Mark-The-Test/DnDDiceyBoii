package com.stockman.dnddiceyboii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerViewAdaapter extends RecyclerView.Adapter<RecyclerViewAdaapter.ViewHolder>{
    ArrayList<Dice> mMyModels;
    Context mContext;
    private OnItemClickListener mListener;


    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener= listener;
    }


    public RecyclerViewAdaapter(ArrayList<Dice> myModels, Context context) {
        mMyModels = myModels;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,
                parent,false);

        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(mMyModels.get(position).getSide());
        holder.nmae.setText(mMyModels.get(position).getName());
        holder.mDiceName.setText("???");
    }

    @Override
    public int getItemCount() {
        return mMyModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView icon;
        TextView nmae, mDiceName;


        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            icon = itemView.findViewById(R.id.selector);
            nmae = itemView.findViewById(R.id.diceType);
            mDiceName = itemView.findViewById(R.id.rcDice);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
//                        mDiceName.setText(mMyModels.get(position)
//                                .rollDice(mMyModels.get(position).maxRoll));
                    }
                }
            });



        }

    }

}