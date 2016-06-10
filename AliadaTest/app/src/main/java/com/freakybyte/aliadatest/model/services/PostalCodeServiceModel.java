package com.freakybyte.aliadatest.model.services;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class PostalCodeServiceModel {

    @SerializedName("zone_id")
    @Expose
    private int zoneId;
    @SerializedName("number")
    @Expose
    private String number;

    /**
     * @return The zoneId
     */
    public int getZoneId() {
        return zoneId;
    }

    /**
     * @param zoneId The zone_id
     */
    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    /**
     * @return The number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number The number
     */
    public void setNumber(String number) {
        this.number = number;
    }
}
