package com.freakybyte.aliadatest.model.services;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */

public class AddressServiceModel {


    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("interior_number")
    @Expose
    private String interiorNumber;
    @SerializedName("colony")
    @Expose
    private String colony;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("postal_code")
    @Expose
    private PostalCodeServiceModel postalCode;

    /**
     * @return The street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street The street
     */
    public void setStreet(String street) {
        this.street = street;
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

    /**
     * @return The interiorNumber
     */
    public String getInteriorNumber() {
        return interiorNumber;
    }

    /**
     * @param interiorNumber The interior_number
     */
    public void setInteriorNumber(String interiorNumber) {
        this.interiorNumber = interiorNumber;
    }

    /**
     * @return The colony
     */
    public String getColony() {
        return colony;
    }

    /**
     * @param colony The colony
     */
    public void setColony(String colony) {
        this.colony = colony;
    }

    /**
     * @return The city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return The postalCode
     */
    public PostalCodeServiceModel getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode The postal_code
     */
    public void setPostalCode(PostalCodeServiceModel postalCode) {
        this.postalCode = postalCode;
    }

}