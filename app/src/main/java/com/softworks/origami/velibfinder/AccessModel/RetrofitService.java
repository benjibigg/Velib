package com.softworks.origami.velibfinder.AccessModel;

import com.softworks.origami.velibfinder.Models.Station;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Benjamin on 12/05/2017.
 */

public interface RetrofitService {
    public static final String ENDPOINT = "https://opendata.paris.fr";

    @GET("/api/records/1.0/search/?dataset=stations-velib-disponibilites-en-temps-reel&rows=100&facet=banking&facet=bonus&facet=status&facet=contract_name")
    Observable<Station> stationList();
}

