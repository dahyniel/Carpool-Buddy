package com.example.carpoolbuddyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GreenRecyclerViewAdapter extends RecyclerView.Adapter<GreenRecyclerViewAdapter.GreenMyViewHolder>
{
    private ArrayList<GreenUser> usersList;
    private RecyclerViewAdapter.RecyclerViewClickListener listener;

    public GreenRecyclerViewAdapter(ArrayList<GreenUser> usersList, RecyclerViewAdapter.RecyclerViewClickListener listener)
    {
        this.usersList = usersList;
        this.listener = listener;
    }

    public class GreenMyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView greenText;

        public GreenMyViewHolder(final View view)
        {
            super(view);
            greenText = view.findViewById(R.id.greenTextView);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public GreenRecyclerViewAdapter.GreenMyViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.green_list_items,
                parent, false);
        return new GreenMyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GreenRecyclerViewAdapter.GreenMyViewHolder holder, int position)
    {
        String name = usersList.get(position).getUsername();
        holder.greenText.setText(name);
    }

    @Override
    public int getItemCount()
    {
        return usersList.size();
    }

    public interface RecyclerViewClickListener
    {
        void onClick(View v, int position);
    }
}
