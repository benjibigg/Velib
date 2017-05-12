package com.softworks.origami.velibfinder.Models;

import java.util.Date;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class Station {
    private final String name;
    private final String adress;
    private final int nbPlace;
    private final Date lastUpdate;

    public Station(String name, String adress, int nbPlace, Date lastUpdate) {
        this.name = name;
        this.adress = adress;
        this.nbPlace = nbPlace;
        this.lastUpdate = lastUpdate;
    }
}
