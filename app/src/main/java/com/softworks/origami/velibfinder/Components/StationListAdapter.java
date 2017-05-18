package com.softworks.origami.velibfinder.Components;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softworks.origami.velibfinder.Models.*;
import com.softworks.origami.velibfinder.R;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class StationListAdapter extends RecyclerView.Adapter<StationListAdapter.ViewHolder>
{
    private Station items;
    private final View.OnClickListener listener;



    public StationListAdapter(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    public void setStations(Station items)
    {
        this.items = items;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView address;
        private TextView name;
        private TextView places;
        private TextView status;

        public ViewHolder(View v) {
            super(v);
            address = (TextView) v.findViewById(R.id.item_address);
            name = (TextView) v.findViewById(R.id.item_name);
            places = (TextView) v.findViewById(R.id.item_place);
            status = (TextView) v.findViewById(R.id.item_status);
        }
    }

    @Override
    public StationListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        v.setOnClickListener(listener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fields item = items.records.get(position).fields;
        holder.address.setText(item.getAddress());
        holder.name.setText(item.getName());
        holder.places.setText(item.getBike_stands());

        if (item.isOpen())
        {
            holder.status.setText("\u2714");
            holder.status.setTextColor(Color.parseColor("#2ecc71"));
        }
        else
        {
            holder.status.setText("\u2716");
            holder.status.setTextColor(Color.parseColor("#e74c3c"));
        }

        // save information in holder, we have one type in this adapter
    }

    @Override
    public int getItemCount()
    {
        if (items == null)
            return 0;
        return items.records.size();
    }
}
