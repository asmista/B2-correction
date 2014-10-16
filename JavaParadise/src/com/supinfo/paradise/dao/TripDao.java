package com.supinfo.paradise.dao;

import com.supinfo.paradise.model.Trip;

/**
 * @author Kevin Valfin <valfin.kevin@gmail.com>
 */
public interface TripDao {

    Long createTrip(Trip trip);

    Trip findTripById(Long id);

    boolean removeTrip(Trip trip);
}
