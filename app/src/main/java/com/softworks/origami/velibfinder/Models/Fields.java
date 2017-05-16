package com.softworks.origami.velibfinder.Models;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by franckzhang on 0516//2017.
 */

public class Fields {
    @SerializedName("name")
    private final String name;

    @SerializedName("address")
    private final String address;

    @SerializedName("status")
    private final boolean open;

    @SerializedName("available_bike_stands")
    private final int bike_stands;

    @SerializedName("available_bikes")
    private final int available_bike_stands;

    @SerializedName("last_update")
    private final Date lastUpdate;

    public Fields(String name, String address, boolean open, int bike_stands,
                  int available_bike_stands, Date lastUpdate) {
        this.name = name;
        this.address = address;
        this.open = open;
        this.bike_stands = bike_stands;
        this.available_bike_stands = available_bike_stands;
        this.lastUpdate = lastUpdate;
    }

    public String getDate() {
        SimpleDateFormat simpleDate =  new SimpleDateFormat("dd/MM/yyyy");
        return simpleDate.format(lastUpdate);
    }

    public String getOpen() { return open ? "Ouvert" : "Fermé"; }

    public String getAddress()
    {
        return address;
    }

    public String getName() { return name; }

    public String getBike_stands() { return bike_stands + "/" + available_bike_stands; }
}