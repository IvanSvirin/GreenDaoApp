package com.example.isvirin.greendaoapp.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.isvirin.greendaoapp.R;
import com.example.isvirin.greendaoapp.model.User;
import com.example.isvirin.greendaoapp.model.User2;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<User2> users = new ArrayList<>();

    public UsersAdapter(ArrayList<User2> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new LocationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LocationViewHolder holder1 = ((LocationViewHolder) holder);
        holder1.tvFirstName.setText(users.get(position).getFirstName());
        holder1.tvLastName.setText(users.get(position).getLastName());
        holder1.tvLastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class LocationViewHolder extends RecyclerView.ViewHolder {
        TextView tvFirstName;
        TextView tvLastName;
        public LocationViewHolder(View itemView) {
            super(itemView);
            tvFirstName = itemView.findViewById(R.id.text_view_first_name);
            tvLastName = itemView.findViewById(R.id.text_view_last_name);
        }
    }
}
