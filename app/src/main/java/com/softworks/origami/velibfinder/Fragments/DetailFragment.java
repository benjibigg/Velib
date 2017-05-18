package com.softworks.origami.velibfinder.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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
        TextView text = (TextView)rootView.getRootView().findViewById(R.id.name);
        text.setText(station.records.get(pos).fields.getAddress());
        return rootView;
    }
}
