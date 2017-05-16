package com.softworks.origami.velibfinder.AccessModel;

import android.util.Log;

import com.softworks.origami.velibfinder.Models.Station;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class StationFetcher
{
    private static final String TAG = "StationFetcher";

    private static StationFetcher fetcher = null;

    public BehaviorSubject<Station> stationList = BehaviorSubject.create();

    public static StationFetcher getInstance()
    {
        if (fetcher == null)
            fetcher = new StationFetcher();
        return fetcher;
    }

    /*
    public void fakeGenerator()
    {
        stations = new ArrayList<>();
        stations.add(new Station("Abbesses", "Paris 18e", 1, 4));
        stations.add(new Station("Alésia", "Paris 14e", 2, 4));
        stations.add(new Station("Alexandre Dumas", "Paris 11e, Paris 20e", 3, 4));
        stations.add(new Station("Alma - Marceau", "Paris 8e, Paris 16e", 2, 4));
        stations.add(new Station("Anatole France", "Levallois-Perret", 4, 4));
        stations.add(new Station("Anvers", "Paris 9e, Paris 18e", 2, 4));
        stations.add(new Station("Argentine", "Paris 16e, Paris 17e", 1, 4));
        stations.add(new Station("Arts et Métiers", "Paris 3e", 2, 4));
    }
    */

    public void getStations() {
        RetrofitFactory.getInstance().create(RetrofitService.class)
            .stationList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(stations -> stationList.onNext(stations));
    }
}
