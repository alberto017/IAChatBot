package com.example.sanchez.iachatbot;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView user, message;
        ImageView image;

        public ViewHolder(View itemView){
            super(itemView);
            user = (TextView) itemView.findViewById(R.id.txtUser);
            message = (TextView) itemView.findViewById(R.id.txtMessage);
            image = (ImageView) itemView.findViewById(R.id.imageUser);
        }
    }

    public List<UserModelo> userList;

    public RecyclerViewAdapter(List<UserModelo> userList){
        this.userList = userList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_people,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.user.setText(userList.get(position).getUser());
        holder.message.setText(userList.get(position).getMessage());
        holder.image.setImageResource(userList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
