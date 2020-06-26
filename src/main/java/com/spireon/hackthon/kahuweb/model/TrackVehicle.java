package com.spireon.hackthon.kahuweb.model;

import java.util.Date;

public class TrackVehicle {
    private int id;
    private String user;
    private String assetVin;
    private String deviceId;
    private String deviceSerialNumber;
    private LocationDto locationDTO;
    private Date eventDate;

    public TrackVehicle() {
    		super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAssetVin() {
        return assetVin;
    }

    public void setAssetVin(String assetVin) {
        this.assetVin = assetVin;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    public LocationDto getLocationDTO() {
        return locationDTO;
    }

    public void setLocationDTO(LocationDto locationDTO) {
        this.locationDTO = locationDTO;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TrackVehicle other = (TrackVehicle) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrackVehicle{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", assetVin='" + assetVin + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceSerialNumber='" + deviceSerialNumber + '\'' +
                ", locationDTO=" + locationDTO +
                ", eventDate=" + eventDate +
                '}';
    }
}