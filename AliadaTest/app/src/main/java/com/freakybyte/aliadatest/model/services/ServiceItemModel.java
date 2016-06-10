package com.freakybyte.aliadatest.model.services;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class ServiceItemModel {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("confirmed")
    @Expose
    private boolean confirmed;
    @SerializedName("estimated_hours")
    @Expose
    private String estimatedHours;
    @SerializedName("hours_worked")
    @Expose
    private Object hoursWorked;
    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("ending_datetime")
    @Expose
    private String endingDatetime;
    @SerializedName("special_instructions")
    @Expose
    private String specialInstructions;
    @SerializedName("garbage_instructions")
    @Expose
    private String garbageInstructions;
    @SerializedName("equipment_instructions")
    @Expose
    private String equipmentInstructions;
    @SerializedName("forbidden_instructions")
    @Expose
    private String forbiddenInstructions;
    @SerializedName("cleaning_supplies_instructions")
    @Expose
    private String cleaningSuppliesInstructions;
    @SerializedName("attention_instructions")
    @Expose
    private String attentionInstructions;
    @SerializedName("service_type")
    @Expose
    private String serviceType;
    @SerializedName("address")
    @Expose
    private AddressServiceModel address;
    @SerializedName("user")
    @Expose
    private UserServiceModel user;
    @SerializedName("aliada")
    @Expose
    private AliadaServiceModel aliada;

    /**
     * @return The id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The confirmed
     */
    public boolean isConfirmed() {
        return confirmed;
    }

    /**
     * @param confirmed The confirmed
     */
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    /**
     * @return The estimatedHours
     */
    public String getEstimatedHours() {
        return estimatedHours;
    }

    /**
     * @param estimatedHours The estimated_hours
     */
    public void setEstimatedHours(String estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    /**
     * @return The hoursWorked
     */
    public Object getHoursWorked() {
        return hoursWorked;
    }

    /**
     * @param hoursWorked The hours_worked
     */
    public void setHoursWorked(Object hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * @return The datetime
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     * @param datetime The datetime
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * @return The endingDatetime
     */
    public String getEndingDatetime() {
        return endingDatetime;
    }

    /**
     * @param endingDatetime The ending_datetime
     */
    public void setEndingDatetime(String endingDatetime) {
        this.endingDatetime = endingDatetime;
    }

    /**
     * @return The specialInstructions
     */
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    /**
     * @param specialInstructions The special_instructions
     */
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    /**
     * @return The garbageInstructions
     */
    public String getGarbageInstructions() {
        return garbageInstructions;
    }

    /**
     * @param garbageInstructions The garbage_instructions
     */
    public void setGarbageInstructions(String garbageInstructions) {
        this.garbageInstructions = garbageInstructions;
    }

    /**
     * @return The equipmentInstructions
     */
    public String getEquipmentInstructions() {
        return equipmentInstructions;
    }

    /**
     * @param equipmentInstructions The equipment_instructions
     */
    public void setEquipmentInstructions(String equipmentInstructions) {
        this.equipmentInstructions = equipmentInstructions;
    }

    /**
     * @return The forbiddenInstructions
     */
    public String getForbiddenInstructions() {
        return forbiddenInstructions;
    }

    /**
     * @param forbiddenInstructions The forbidden_instructions
     */
    public void setForbiddenInstructions(String forbiddenInstructions) {
        this.forbiddenInstructions = forbiddenInstructions;
    }

    /**
     * @return The cleaningSuppliesInstructions
     */
    public String getCleaningSuppliesInstructions() {
        return cleaningSuppliesInstructions;
    }

    /**
     * @param cleaningSuppliesInstructions The cleaning_supplies_instructions
     */
    public void setCleaningSuppliesInstructions(String cleaningSuppliesInstructions) {
        this.cleaningSuppliesInstructions = cleaningSuppliesInstructions;
    }

    /**
     * @return The attentionInstructions
     */
    public String getAttentionInstructions() {
        return attentionInstructions;
    }

    /**
     * @param attentionInstructions The attention_instructions
     */
    public void setAttentionInstructions(String attentionInstructions) {
        this.attentionInstructions = attentionInstructions;
    }

    /**
     * @return The serviceType
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * @param serviceType The service_type
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * @return The address
     */
    public AddressServiceModel getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    public void setAddress(AddressServiceModel address) {
        this.address = address;
    }

    /**
     * @return The user
     */
    public UserServiceModel getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(UserServiceModel user) {
        this.user = user;
    }

    /**
     * @return The aliada
     */
    public AliadaServiceModel getAliada() {
        return aliada;
    }

    /**
     * @param aliada The aliada
     */
    public void setAliada(AliadaServiceModel aliada) {
        this.aliada = aliada;
    }
}
