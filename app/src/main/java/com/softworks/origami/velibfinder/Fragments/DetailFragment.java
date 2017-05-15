package com.softworks.origami.velibfinder.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softworks.origami.velibfinder.AccessModel.StationFetcher;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int pos = 0;
        if (bundle != null) {
            pos = bundle.getInt("pos", 0);
        }
        this.station = StationFetcher.getInstance().stations.get(pos);

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.details_page, container, false);
        TextView text = (TextView)rootView.getRootView().findViewById(R.id.name);
        text.setText(station.getAddress());
        return rootView;
    }
}
