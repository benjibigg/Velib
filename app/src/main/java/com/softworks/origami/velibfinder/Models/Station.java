package com.softworks.origami.velibfinder.Models;

import java.util.Date;

/**
 * Created by Benjamin on 12/05/2017.
 */

public class Station {
    private final String name;
    private final String address;
    private final int nbPlace;
    private final int nbPlaceDispo;

    public Station(String name, String address, int nbPlace, int nbPlaceDispo) {
        this.name = name;
        this.address = address;
        this.nbPlace = nbPlace;
        this.nbPlaceDispo = nbPlaceDispo;
    }

    public String getAddress()
    {
        return address;
    }

    public String getName() { return name; }

    public String getNbPlace() { return nbPlace + "/" + nbPlaceDispo; }
}
