package com.freakybyte.aliadatest.model.services;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class ServiceModel {


    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("services")
    @Expose
    private List<ServiceItemModel> services = new ArrayList<>();

    /**
     * @return The page
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page The page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return The services
     */
    public List<ServiceItemModel> getServices() {
        return services;
    }

    /**
     * @param services The services
     */
    public void setServices(List<ServiceItemModel> services) {
        this.services = services;
    }
}
