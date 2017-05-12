package com.softworks.origami.velibfinder.AccessModel;

import com.softworks.origami.velibfinder.Models.Station;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Benjamin on 12/05/2017.
 */

public interface RetrofitService {
    public static final String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}/repos")
    Call<List<Station>> listRepos(@Path("user") String user);

    @GET("/search/repositories")
    Call<List<Station>> searchRepos(@Query("q") String query);
}
