package com.softworks.origami.velibfinder.AccessModel;

import android.util.Log;

import com.softworks.origami.velibfinder.Models.Station;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class StationFetcher
{
    private static final String TAG = "StationFetcher";

    private static StationFetcher fetcher = null;

    public Station stations;

    public Call<Station> stationList;

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

    public void getStation()
    {
        RetrofitService retrofitService = RetrofitFactory.getInstance().create(RetrofitService.class);
        stationList = retrofitService.stationList();
        stationList.enqueue(new Callback<Station>() {
            @Override
            public void onResponse(Call<Station> call, Response<Station> response) {
                if(response.isSuccessful()) { stations = response.body(); }
                else { Log.e(TAG, "Error while fetching data. Swallowing the exception."); }
            }

            @Override
            public void onFailure(Call<Station> call, Throwable t) {
                Log.e(TAG, "Error while fetching data. Swallowing the exception.");
            }
        });
        try {
            stationList.execute();
        }
        catch (Exception e) {
            Log.e(TAG, "Error while fetching data. Swallowing the exception.");
        }


    }
}
