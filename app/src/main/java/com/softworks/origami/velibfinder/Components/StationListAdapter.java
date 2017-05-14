package com.softworks.origami.velibfinder.Components;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softworks.origami.velibfinder.Models.Station;
import com.softworks.origami.velibfinder.R;

import java.util.List;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class StationListAdapter extends RecyclerView.Adapter<StationListAdapter.ViewHolder>
{
    private List<Station> items;
    private final View.OnClickListener listener;

    public StationListAdapter(List<Station> items, View.OnClickListener listener)
    {
        this.items = items;
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView address;
        public ViewHolder(View v) {
            super(v);
            address = (TextView) v.findViewById(R.id.item_address);
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
        Station item = items.get(position);
        // save information in holder, we have one type in this adapter
        holder.address.setText(item.getAddress());
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }
}
