package com.spireon.hackthon.kahuweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetDto {

    private String id;

    private Boolean active;
    private String description;
    private String name;
    private String type;
    private AssetTypeRefDto assetTypeRef;
    private String make;
    private String model;
    private Integer year;
    private String vin;
    private Double initialOdometer;
    private Double odometer;
    private Double distanceDriven;
    private Double odometerAdjustment;
    private Double initialEngineHours;
    private Double engineHours;
    private Double engineHoursAdjustment;
    private Double recordedEngineHours;
    private String assetGroupName;
    private String assetGroupGlobalId;
    private java.util.Map<String, String> attributes;
    private List<String> tags;
    private LocationDto lastLocation;
    private java.util.Date locationLastReported;
    private Integer speed;
    private String status;
    private Date statusStartDate;
    private Double batteryVoltage;
    private Double fuelLevel;
    private String createdBy;
    private String updatedBy;
    private java.util.Date dateCreated;
    private java.util.Date lastUpdated;
    private Date lastCargoTemperatureTime;
    private Double cargoTemperature;  // This is in degrees Celsius

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Deprecated
    public Boolean isActive() {
        return active;
    }

    /**
     * @return the active flag
     */
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Double getInitialOdometer() {
        return initialOdometer;
    }

    public void setInitialOdometer(Double initialOdometer) {
        this.initialOdometer = initialOdometer;
    }

    public Double getOdometer() {
        return odometer;
    }

    public void setOdometer(Double odometer) {
        this.odometer = odometer;
    }

    public String getAssetGroupName() {
        return assetGroupName;
    }

    public void setAssetGroupName(String assetGroupName) {
        this.assetGroupName = assetGroupName;
    }

    public LocationDto getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(LocationDto lastLocation) {
        this.lastLocation = lastLocation;
    }

    public java.util.Date getLocationLastReported() {
        return locationLastReported;
    }

    public void setLocationLastReported(java.util.Date locationLastReported) {
        this.locationLastReported = locationLastReported;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusStartDate() {
        return statusStartDate;
    }

    public void setStatusStartDate(Date statusStartDate) {
        this.statusStartDate = statusStartDate;
    }

    public Double getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(Double batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(java.util.Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public java.util.Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(java.util.Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public java.util.Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(java.util.Map<String, String> attributes) {
        this.attributes = attributes;
    }

    /**
     * @return the initialEngineHours in hours, oddly enough.
     */
    public Double getInitialEngineHours() {
        return initialEngineHours;
    }

    /**
     * @param initialEngineHours the initialEngineHours to set.
     */
    public void setInitialEngineHours(Double initialEngineHours) {
        this.initialEngineHours = initialEngineHours;
    }

    /**
     * @return the engineHours in hours, oddly enough.
     */
    public Double getEngineHours() {
        return engineHours;
    }

    /**
     * @param engineHours the engineHours to set.
     */
    public void setEngineHours(Double engineHours) {
        this.engineHours = engineHours;
    }

    public Double getEngineHoursAdjustment() {
        return engineHoursAdjustment;
    }

    public void setEngineHoursAdjustment(Double engineHoursAdjustment) {
        this.engineHoursAdjustment = engineHoursAdjustment;
    }

    public Double getRecordedEngineHours() {
        return recordedEngineHours;
    }

    public void setRecordedEngineHours(Double recordedEngineHours) {
        this.recordedEngineHours = recordedEngineHours;
    }

    public Double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(Double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * @return the assetGroupGlobalId
     */
    public String getAssetGroupGlobalId() {
        return assetGroupGlobalId;
    }

    /**
     * @param assetGroupGlobalId the assetGroupGlobalId to set
     */
    public void setAssetGroupGlobalId(String assetGroupGlobalId) {
        this.assetGroupGlobalId = assetGroupGlobalId;
    }

    /**
     * @return the lastCargoTemperatureTime
     */
    public Date getLastCargoTemperatureTime() {
        return lastCargoTemperatureTime;
    }

    /**
     * @param lastCargoTemperatureTime the lastCargoTemperatureTime to set
     */
    public void setLastCargoTemperatureTime(Date lastCargoTemperatureTime) {
        this.lastCargoTemperatureTime = lastCargoTemperatureTime;
    }

    /**
     * @return the cargoTemperature
     */
    public Double getCargoTemperature() {
        return cargoTemperature;
    }

    /**
     * @param cargoTemperature the cargoTemperature to set
     */
    public void setCargoTemperature(Double cargoTemperature) {
        this.cargoTemperature = cargoTemperature;
    }

    public Double getDistanceDriven() {
        return distanceDriven;
    }

    public void setDistanceDriven(Double distanceDriven) {
        this.distanceDriven = distanceDriven;
    }

    public Double getOdometerAdjustment() {
        return odometerAdjustment;
    }

    public void setOdometerAdjustment(Double odometerAdjustment) {
        this.odometerAdjustment = odometerAdjustment;
    }

    public AssetTypeRefDto getAssetTypeRef() {
        return assetTypeRef;
    }

    public void setAssetTypeRef(AssetTypeRefDto assetTypeRef) {
        this.assetTypeRef = assetTypeRef;
    }
}