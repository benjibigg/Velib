package com.softworks.origami.velibfinder.AccessModel;

import com.softworks.origami.velibfinder.Models.Station;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class StationFetcher
{
    private static StationFetcher fetcher = null;

    public final BehaviorSubject<Station> stationList = BehaviorSubject.create();

    public static StationFetcher getInstance()
    {
        if (fetcher == null)
            fetcher = new StationFetcher();
        return fetcher;
    }

    public void getStations() {
        RetrofitFactory.getInstance().create(RetrofitService.class)
            .stationList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(stationList::onNext);
    }
}
