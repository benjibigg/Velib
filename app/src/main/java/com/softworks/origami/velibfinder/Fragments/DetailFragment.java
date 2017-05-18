package com.softworks.origami.velibfinder.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softworks.origami.velibfinder.AccessModel.StationFetcher;
import com.softworks.origami.velibfinder.MembersActivity;
import com.softworks.origami.velibfinder.Models.Station;
import com.softworks.origami.velibfinder.R;

/**
 * Created by Benjamin on 14/05/2017.
 */

public class DetailFragment extends Fragment
{
    Station station;

    public DetailFragment()
    {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.members:
                showMembers();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showMembers()
    {
        Intent intent = new Intent(getActivity(), MembersActivity.class);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int pos = 0;
        if (bundle != null) {
            pos = bundle.getInt("pos", 0);
        }
        this.station = StationFetcher.getInstance().stationList.getValue();

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.details_page, container, false);

        setFragment(rootView, pos);
        return rootView;
    }

    private void setFragment(ViewGroup rootView, int pos)
    {
        TextView name = (TextView) rootView.getRootView().findViewById(R.id.name);
        name.setText(station.records.get(pos).fields.getAddress());

        TextView status = (TextView)rootView.getRootView().findViewById(R.id.status);
        status.setText(station.records.get(pos).fields.isOpen().toString());

        TextView bike_stands = (TextView)rootView.getRootView().findViewById(R.id.bike_stands);
        bike_stands.setText(station.records.get(pos).fields.getAvailableBikeStand());

        TextView address = (TextView)rootView.getRootView().findViewById(R.id.address);
        address.setText(station.records.get(pos).fields.getAddress());

        TextView last_update  = (TextView)rootView.getRootView().findViewById(R.id.last_update);
        last_update.setText(station.records.get(pos).fields.getLastUpdate());

    }
}
