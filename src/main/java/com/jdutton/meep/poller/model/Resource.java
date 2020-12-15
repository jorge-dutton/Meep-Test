package com.jdutton.meep.poller.model;


import com.google.common.base.Objects;

import java.io.Serializable;

public class Resource implements Serializable {

    private static final long serialVersionUID = 3326992751508105184L;

    private String id;
    private String name;
    private double x;
    private double y;
    private String licencePlate;
    private int range;
    private int batteryLevel;
    private int helmets;
    private String model;
    private String resourceImageId;
    private boolean realtimeData;
    private String resourceType;
    private int companyZoneId;

    public Resource() {
    }


    public Resource(String id,
                    String name,
                    double x,
                    double y,
                    String licencePlate,
                    int range,
                    int batteryLevel,
                    int helmets,
                    String model,
                    String resourceImageId,
                    boolean realtimeData,
                    String resourceType,
                    int companyZoneId) {
        super();
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.licencePlate = licencePlate;
        this.range = range;
        this.batteryLevel = batteryLevel;
        this.helmets = helmets;
        this.model = model;
        this.resourceImageId = resourceImageId;
        this.realtimeData = realtimeData;
        this.resourceType = resourceType;
        this.companyZoneId = companyZoneId;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public int getHelmets() {
        return helmets;
    }

    public void setHelmets(int helmets) {
        this.helmets = helmets;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getResourceImageId() {
        return resourceImageId;
    }

    public void setResourceImageId(String resourceImageId) {
        this.resourceImageId = resourceImageId;
    }

    public boolean isRealtimeData() {
        return realtimeData;
    }

    public void setRealtimeData(boolean realtimeData) {
        this.realtimeData = realtimeData;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getCompanyZoneId() {
        return companyZoneId;
    }

    public void setCompanyZoneId(int companyZoneId) {
        this.companyZoneId = companyZoneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource)) return false;
        Resource resource = (Resource) o;
        return Double.compare(resource.x, x) == 0 &&
                Double.compare(resource.y, y) == 0 &&
                batteryLevel == resource.batteryLevel &&
                helmets == resource.helmets &&
                range == resource.range &&
                realtimeData == resource.realtimeData &&
                companyZoneId == resource.companyZoneId &&
                Objects.equal(id, resource.id) &&
                Objects.equal(name, resource.name) &&
                Objects.equal(licencePlate, resource.licencePlate) &&
                Objects.equal(model, resource.model) &&
                Objects.equal(resourceImageId, resource.resourceImageId) &&
                Objects.equal(resourceType, resource.resourceType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, x, y, licencePlate, batteryLevel, range, helmets, model, resourceImageId, realtimeData, resourceType, companyZoneId);
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", licencePlate='" + licencePlate + '\'' +
                ", batteryLevel=" + batteryLevel +
                ", helmets=" + helmets +
                ", model='" + model + '\'' +
                ", resourceImageId='" + resourceImageId + '\'' +
                ", realtimeData=" + realtimeData +
                ", resourceType='" + resourceType + '\'' +
                ", companyZoneId=" + companyZoneId +
                '}';
    }
}
