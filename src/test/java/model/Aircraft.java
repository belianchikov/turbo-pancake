package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Aircraft {
    private String manufacturer;
    private String model;
    @JsonProperty("range_km")
    private Integer rangeKm;
    @JsonProperty("max_passengers")
    private Integer maxPassengers;
    private String engines;
    private AircraftDimensions dimensions;
    private List<String> features;


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRangeKm() {
        return rangeKm;
    }

    public void setRangeKm(Integer rangeKm) {
        this.rangeKm = rangeKm;
    }

    public Integer getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(Integer maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public String getEngines() {
        return engines;
    }

    public void setEngines(String engines) {
        this.engines = engines;
    }

    public AircraftDimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(AircraftDimensions dimensions) {
        this.dimensions = dimensions;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }
}
