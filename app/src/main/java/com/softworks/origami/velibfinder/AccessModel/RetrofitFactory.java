package com.softworks.origami.velibfinder.AccessModel;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class RetrofitFactory {
    //public static final String BASE_URL = "https://opendata.paris.fr";
    private static Retrofit retrofit = null;

    public static Retrofit getInstance()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(RetrofitService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
