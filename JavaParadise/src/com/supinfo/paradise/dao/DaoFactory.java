package com.supinfo.paradise.dao;

import com.supinfo.paradise.dao.jdbc.JdbcPlaceDao;
import com.supinfo.paradise.dao.jdbc.JdbcTripDao;
import com.supinfo.paradise.util.ConnectionManager;

/**
 * @author Kevin Valfin <valfin.kevin@gmail.com>
 */
public class DaoFactory {

    private DaoFactory() {

    }

    public static PlaceDao getPlaceDao() {
        return new JdbcPlaceDao(ConnectionManager.getConnection());
    }

    public static TripDao getTripDao() {
        return new JdbcTripDao(ConnectionManager.getConnection());
    }
}
