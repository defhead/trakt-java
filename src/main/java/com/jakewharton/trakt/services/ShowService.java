package com.jakewharton.trakt.services;

import com.jakewharton.trakt.entities.Checkin;
import com.jakewharton.trakt.entities.CheckinResponse;
import com.jakewharton.trakt.entities.Response;
import com.jakewharton.trakt.entities.TvShow;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Endpoints for Show.
 */
public interface ShowService {

    /**
     * Notify trakt that a user wants to cancel their current check in. <br/>
     * <br/>
     * <em>Warning</em>: This method requires a developer API key.
     */
    @POST("/show/cancelcheckin/{apikey}")
    Response cancelcheckin();

    /**
     * Notify trakt that a user has stopped watching a show.<br/>
     * <br/>
     * <em>Warning</em>: This method requires a developer API key.
     */
    @POST("/show/cancelwatching/{apikey}")
    Response cancelwatching();

    /**
     * Check into a show on trakt. Think of this method as in between a seen and a scrobble.
     * After checking in, trakt will automatically display it as watching then switch
     * over to watched status once the duration has elapsed.<br/>
     * <br/>
     * <em>Warning</em>: This method requires a developer API key.
     */
    @POST("/show/checkin/{apikey}")
    CheckinResponse checkin(
            @Body Checkin checkin
    );

    @GET("/show/summary.json/{apikey}/{title}")
    TvShow summary(
            @Path("title") String slug
    );

    @GET("/show/summary.json/{apikey}/{title}")
    TvShow summary(
            @Path("title") int tvdbId
    );

    @GET("/show/summary.json/{apikey}/{title}/extended")
    TvShow summaryExtended(
            @Path("title") String slug
    );

    @GET("/show/summary.json/{apikey}/{title}/extended")
    TvShow summaryExtended(
            @Path("title") int tvdbId
    );

}
