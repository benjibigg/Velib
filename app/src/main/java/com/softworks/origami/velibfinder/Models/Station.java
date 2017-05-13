package com.softworks.origami.velibfinder.Models;

import java.util.Date;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class Station {
    private final String name;
    private final String address;
    private final int nbPlace;

    public Station(String name, String address, int nbPlace) {
        this.name = name;
        this.address = address;
        this.nbPlace = nbPlace;
    }

    public String getAddress()
    {
        return address;
    }
}
