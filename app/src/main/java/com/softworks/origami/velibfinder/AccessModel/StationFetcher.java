package com.softworks.origami.velibfinder.AccessModel;

import android.util.Log;

import com.softworks.origami.velibfinder.Models.Station;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class StationFetcher
{
    private static final String TAG = "StationFetcher";

    public void getStation()
    {
        RetrofitService retrofitService = RetrofitFactory.getInstance().create(RetrofitService.class);
        Call<List<Station>> stationList = retrofitService.listRepos("square");

        stationList.enqueue(new Callback<List<Station>>() {
            @Override
            public void onResponse(Call<List<Station>> call, Response<List<Station>> response) {
                if(response.isSuccessful())
                {
                    List<Station> repoList = response.body();
                }
                else
                {
                    Log.e(TAG, "Error while fetching data. Swallowing the exception.");
                }
            }

            @Override
            public void onFailure(Call<List<Station>> call, Throwable t) {
                Log.e(TAG, "Error while fetching data. Swallowing the exception.");
            }
        });
    }
}
