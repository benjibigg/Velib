package com.softworks.origami.velibfinder.Components;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softworks.origami.velibfinder.R;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class RecyclerViewStations extends RecyclerView.Adapter<RecyclerViewStations.ViewHolder>
{
    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            //mTextView = (TextView) v.findViewById(R.id.list_text_item);
        }
    }

    @Override
    public RecyclerViewStations.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount()
    {
        return 0;
    }
}
