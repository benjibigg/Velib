package com.softworks.origami.velibfinder.Components;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softworks.origami.velibfinder.Models.Fields;
import com.softworks.origami.velibfinder.Models.Station;
import com.softworks.origami.velibfinder.R;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class StationListAdapter extends RecyclerView.Adapter<StationListAdapter.ViewHolder>
{
    private Station items;
    private final View.OnClickListener listener;
    private Context context;

    public Station original;

    public StationListAdapter(View.OnClickListener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    public void setStations(Station items)
    {
        this.items = items;
        notifyDataSetChanged();
    }

    public Station getStations()
    {
        return this.items;
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
        holder.address.setText(item.address);
        holder.name.setText(item.name);
        holder.places.setText(item.getAvailableBikeStand());

        if (item.isOpen())
        {
            holder.status.setText(context.getString(R.string.open));
            holder.status.setTextColor(context.getResources().getColor(R.color.green));
        }
        else
        {
            holder.status.setText(context.getString(R.string.close));
            holder.status.setTextColor(context.getResources().getColor(R.color.red));
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
