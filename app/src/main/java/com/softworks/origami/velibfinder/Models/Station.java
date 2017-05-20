package com.softworks.origami.velibfinder.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class Station {

    @SerializedName("records")
    public List<Records> records;

    public static Station copy (Station target){
        Station newStation = new Station();
        newStation.records = new ArrayList<>();
        for (Records record : target.records)
        {
            Records newRecord = new Records();
            Fields f = new Fields(
                    record.fields.name,
                    record.fields.address,
                    record.fields.status,
                    record.fields.available_bike_stands,
                    record.fields.bike_stands,
                    record.fields.lastUpdate
            );
            newRecord.fields = f;
            newStation.records.add(newRecord);
        }
        return newStation;
    }

    //public Station(LRecords records) { this.records = records; }
    /*
    public Station(String name, String address, boolean open, int bike_stands, int available_bike_stands, Date lastUpdate) {
        this.name = name;
        this.address = address;
        this.open = open;
        this.bike_stands = bike_stands;
        this.available_bike_stands = available_bike_stands;
        this.lastUpdate = lastUpdate;
    }
    */
}



