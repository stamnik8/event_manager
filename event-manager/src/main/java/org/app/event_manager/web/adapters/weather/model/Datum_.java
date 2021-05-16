package org.app.event_manager.web.adapters.weather.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "time",
        "summary",
        "icon",
        "sunriseTime",
        "sunsetTime",
        "moonPhase",
        "precipIntensity",
        "precipIntensityMax",
        "precipIntensityMaxTime",
        "precipProbability",
        "precipAccumulation",
        "precipType",
        "temperatureHigh",
        "temperatureHighTime",
        "temperatureLow",
        "temperatureLowTime",
        "apparentTemperatureHigh",
        "apparentTemperatureHighTime",
        "apparentTemperatureLow",
        "apparentTemperatureLowTime",
        "dewPoint",
        "humidity",
        "pressure",
        "windSpeed",
        "windBearing",
        "cloudCover",
        "uvIndex",
        "uvIndexTime",
        "visibility",
        "temperatureMin",
        "temperatureMinTime",
        "temperatureMax",
        "temperatureMaxTime",
        "apparentTemperatureMin",
        "apparentTemperatureMinTime",
        "apparentTemperatureMax",
        "apparentTemperatureMaxTime"
})
public class Datum_ {

    @JsonProperty("time")
    private Long time;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("sunriseTime")
    private Long sunriseTime;
    @JsonProperty("sunsetTime")
    private Long sunsetTime;
    @JsonProperty("moonPhase")
    private Double moonPhase;
    @JsonProperty("precipIntensity")
    private Double precipIntensity;
    @JsonProperty("precipIntensityMax")
    private Double precipIntensityMax;
    @JsonProperty("precipIntensityMaxTime")
    private Long precipIntensityMaxTime;
    @JsonProperty("precipProbability")
    private Long precipProbability;
    @JsonProperty("precipAccumulation")
    private Double precipAccumulation;
    @JsonProperty("precipType")
    private String precipType;
    @JsonProperty("temperatureHigh")
    private Double temperatureHigh;
    @JsonProperty("temperatureHighTime")
    private Long temperatureHighTime;
    @JsonProperty("temperatureLow")
    private Double temperatureLow;
    @JsonProperty("temperatureLowTime")
    private Long temperatureLowTime;
    @JsonProperty("apparentTemperatureHigh")
    private Double apparentTemperatureHigh;
    @JsonProperty("apparentTemperatureHighTime")
    private Long apparentTemperatureHighTime;
    @JsonProperty("apparentTemperatureLow")
    private Double apparentTemperatureLow;
    @JsonProperty("apparentTemperatureLowTime")
    private Long apparentTemperatureLowTime;
    @JsonProperty("dewPoint")
    private Double dewPoint;
    @JsonProperty("humidity")
    private Double humidity;
    @JsonProperty("pressure")
    private Double pressure;
    @JsonProperty("windSpeed")
    private Double windSpeed;
    @JsonProperty("windBearing")
    private Long windBearing;
    @JsonProperty("cloudCover")
    private Double cloudCover;
    @JsonProperty("uvIndex")
    private Long uvIndex;
    @JsonProperty("uvIndexTime")
    private Long uvIndexTime;
    @JsonProperty("visibility")
    private Double visibility;
    @JsonProperty("temperatureMin")
    private Double temperatureMin;
    @JsonProperty("temperatureMinTime")
    private Long temperatureMinTime;
    @JsonProperty("temperatureMax")
    private Double temperatureMax;
    @JsonProperty("temperatureMaxTime")
    private Long temperatureMaxTime;
    @JsonProperty("apparentTemperatureMin")
    private Double apparentTemperatureMin;
    @JsonProperty("apparentTemperatureMinTime")
    private Long apparentTemperatureMinTime;
    @JsonProperty("apparentTemperatureMax")
    private Double apparentTemperatureMax;
    @JsonProperty("apparentTemperatureMaxTime")
    private Long apparentTemperatureMaxTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum_() {
    }

    /**
     *
     * @param temperatureMinTime
     * @param sunsetTime
     * @param summary
     * @param precipIntensityMaxTime
     * @param visibility
     * @param temperatureLowTime
     * @param temperatureHighTime
     * @param temperatureLow
     * @param precipIntensity
     * @param precipIntensityMax
     * @param time
     * @param apparentTemperatureMaxTime
     * @param uvIndex
     * @param apparentTemperatureHighTime
     * @param temperatureHigh
     * @param precipAccumulation
     * @param icon
     * @param apparentTemperatureLowTime
     * @param temperatureMaxTime
     * @param pressure
     * @param cloudCover
     * @param apparentTemperatureMinTime
     * @param temperatureMin
     * @param precipType
     * @param apparentTemperatureLow
     * @param dewPoint
     * @param sunriseTime
     * @param windSpeed
     * @param humidity
     * @param apparentTemperatureMax
     * @param windBearing
     * @param moonPhase
     * @param precipProbability
     * @param apparentTemperatureMin
     * @param uvIndexTime
     * @param temperatureMax
     * @param apparentTemperatureHigh
     */
    public Datum_(Long time, String summary, String icon, Long sunriseTime, Long sunsetTime, Double moonPhase, Double precipIntensity, Double precipIntensityMax, Long precipIntensityMaxTime, Long precipProbability, Double precipAccumulation, String precipType, Double temperatureHigh, Long temperatureHighTime, Double temperatureLow, Long temperatureLowTime, Double apparentTemperatureHigh, Long apparentTemperatureHighTime, Double apparentTemperatureLow, Long apparentTemperatureLowTime, Double dewPoint, Double humidity, Double pressure, Double windSpeed, Long windBearing, Double cloudCover, Long uvIndex, Long uvIndexTime, Double visibility, Double temperatureMin, Long temperatureMinTime, Double temperatureMax, Long temperatureMaxTime, Double apparentTemperatureMin, Long apparentTemperatureMinTime, Double apparentTemperatureMax, Long apparentTemperatureMaxTime) {
        super();
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.moonPhase = moonPhase;
        this.precipIntensity = precipIntensity;
        this.precipIntensityMax = precipIntensityMax;
        this.precipIntensityMaxTime = precipIntensityMaxTime;
        this.precipProbability = precipProbability;
        this.precipAccumulation = precipAccumulation;
        this.precipType = precipType;
        this.temperatureHigh = temperatureHigh;
        this.temperatureHighTime = temperatureHighTime;
        this.temperatureLow = temperatureLow;
        this.temperatureLowTime = temperatureLowTime;
        this.apparentTemperatureHigh = apparentTemperatureHigh;
        this.apparentTemperatureHighTime = apparentTemperatureHighTime;
        this.apparentTemperatureLow = apparentTemperatureLow;
        this.apparentTemperatureLowTime = apparentTemperatureLowTime;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windBearing = windBearing;
        this.cloudCover = cloudCover;
        this.uvIndex = uvIndex;
        this.uvIndexTime = uvIndexTime;
        this.visibility = visibility;
        this.temperatureMin = temperatureMin;
        this.temperatureMinTime = temperatureMinTime;
        this.temperatureMax = temperatureMax;
        this.temperatureMaxTime = temperatureMaxTime;
        this.apparentTemperatureMin = apparentTemperatureMin;
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
        this.apparentTemperatureMax = apparentTemperatureMax;
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    @JsonProperty("time")
    public Long getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Long time) {
        this.time = time;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("sunriseTime")
    public Long getSunriseTime() {
        return sunriseTime;
    }

    @JsonProperty("sunriseTime")
    public void setSunriseTime(Long sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    @JsonProperty("sunsetTime")
    public Long getSunsetTime() {
        return sunsetTime;
    }

    @JsonProperty("sunsetTime")
    public void setSunsetTime(Long sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    @JsonProperty("moonPhase")
    public Double getMoonPhase() {
        return moonPhase;
    }

    @JsonProperty("moonPhase")
    public void setMoonPhase(Double moonPhase) {
        this.moonPhase = moonPhase;
    }

    @JsonProperty("precipIntensity")
    public Double getPrecipIntensity() {
        return precipIntensity;
    }

    @JsonProperty("precipIntensity")
    public void setPrecipIntensity(Double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    @JsonProperty("precipIntensityMax")
    public Double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    @JsonProperty("precipIntensityMax")
    public void setPrecipIntensityMax(Double precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    @JsonProperty("precipIntensityMaxTime")
    public Long getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    @JsonProperty("precipIntensityMaxTime")
    public void setPrecipIntensityMaxTime(Long precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    @JsonProperty("precipProbability")
    public Long getPrecipProbability() {
        return precipProbability;
    }

    @JsonProperty("precipProbability")
    public void setPrecipProbability(Long precipProbability) {
        this.precipProbability = precipProbability;
    }

    @JsonProperty("precipAccumulation")
    public Double getPrecipAccumulation() {
        return precipAccumulation;
    }

    @JsonProperty("precipAccumulation")
    public void setPrecipAccumulation(Double precipAccumulation) {
        this.precipAccumulation = precipAccumulation;
    }

    @JsonProperty("precipType")
    public String getPrecipType() {
        return precipType;
    }

    @JsonProperty("precipType")
    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    @JsonProperty("temperatureHigh")
    public Double getTemperatureHigh() {
        return temperatureHigh;
    }

    @JsonProperty("temperatureHigh")
    public void setTemperatureHigh(Double temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    @JsonProperty("temperatureHighTime")
    public Long getTemperatureHighTime() {
        return temperatureHighTime;
    }

    @JsonProperty("temperatureHighTime")
    public void setTemperatureHighTime(Long temperatureHighTime) {
        this.temperatureHighTime = temperatureHighTime;
    }

    @JsonProperty("temperatureLow")
    public Double getTemperatureLow() {
        return temperatureLow;
    }

    @JsonProperty("temperatureLow")
    public void setTemperatureLow(Double temperatureLow) {
        this.temperatureLow = temperatureLow;
    }

    @JsonProperty("temperatureLowTime")
    public Long getTemperatureLowTime() {
        return temperatureLowTime;
    }

    @JsonProperty("temperatureLowTime")
    public void setTemperatureLowTime(Long temperatureLowTime) {
        this.temperatureLowTime = temperatureLowTime;
    }

    @JsonProperty("apparentTemperatureHigh")
    public Double getApparentTemperatureHigh() {
        return apparentTemperatureHigh;
    }

    @JsonProperty("apparentTemperatureHigh")
    public void setApparentTemperatureHigh(Double apparentTemperatureHigh) {
        this.apparentTemperatureHigh = apparentTemperatureHigh;
    }

    @JsonProperty("apparentTemperatureHighTime")
    public Long getApparentTemperatureHighTime() {
        return apparentTemperatureHighTime;
    }

    @JsonProperty("apparentTemperatureHighTime")
    public void setApparentTemperatureHighTime(Long apparentTemperatureHighTime) {
        this.apparentTemperatureHighTime = apparentTemperatureHighTime;
    }

    @JsonProperty("apparentTemperatureLow")
    public Double getApparentTemperatureLow() {
        return apparentTemperatureLow;
    }

    @JsonProperty("apparentTemperatureLow")
    public void setApparentTemperatureLow(Double apparentTemperatureLow) {
        this.apparentTemperatureLow = apparentTemperatureLow;
    }

    @JsonProperty("apparentTemperatureLowTime")
    public Long getApparentTemperatureLowTime() {
        return apparentTemperatureLowTime;
    }

    @JsonProperty("apparentTemperatureLowTime")
    public void setApparentTemperatureLowTime(Long apparentTemperatureLowTime) {
        this.apparentTemperatureLowTime = apparentTemperatureLowTime;
    }

    @JsonProperty("dewPoint")
    public Double getDewPoint() {
        return dewPoint;
    }

    @JsonProperty("dewPoint")
    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    @JsonProperty("humidity")
    public Double getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("pressure")
    public Double getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("windSpeed")
    public Double getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("windSpeed")
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("windBearing")
    public Long getWindBearing() {
        return windBearing;
    }

    @JsonProperty("windBearing")
    public void setWindBearing(Long windBearing) {
        this.windBearing = windBearing;
    }

    @JsonProperty("cloudCover")
    public Double getCloudCover() {
        return cloudCover;
    }

    @JsonProperty("cloudCover")
    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
    }

    @JsonProperty("uvIndex")
    public Long getUvIndex() {
        return uvIndex;
    }

    @JsonProperty("uvIndex")
    public void setUvIndex(Long uvIndex) {
        this.uvIndex = uvIndex;
    }

    @JsonProperty("uvIndexTime")
    public Long getUvIndexTime() {
        return uvIndexTime;
    }

    @JsonProperty("uvIndexTime")
    public void setUvIndexTime(Long uvIndexTime) {
        this.uvIndexTime = uvIndexTime;
    }

    @JsonProperty("visibility")
    public Double getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("temperatureMin")
    public Double getTemperatureMin() {
        return temperatureMin;
    }

    @JsonProperty("temperatureMin")
    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    @JsonProperty("temperatureMinTime")
    public Long getTemperatureMinTime() {
        return temperatureMinTime;
    }

    @JsonProperty("temperatureMinTime")
    public void setTemperatureMinTime(Long temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    @JsonProperty("temperatureMax")
    public Double getTemperatureMax() {
        return temperatureMax;
    }

    @JsonProperty("temperatureMax")
    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    @JsonProperty("temperatureMaxTime")
    public Long getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    @JsonProperty("temperatureMaxTime")
    public void setTemperatureMaxTime(Long temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    @JsonProperty("apparentTemperatureMin")
    public Double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    @JsonProperty("apparentTemperatureMin")
    public void setApparentTemperatureMin(Double apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    @JsonProperty("apparentTemperatureMinTime")
    public Long getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    @JsonProperty("apparentTemperatureMinTime")
    public void setApparentTemperatureMinTime(Long apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    @JsonProperty("apparentTemperatureMax")
    public Double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    @JsonProperty("apparentTemperatureMax")
    public void setApparentTemperatureMax(Double apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    @JsonProperty("apparentTemperatureMaxTime")
    public Long getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    @JsonProperty("apparentTemperatureMaxTime")
    public void setApparentTemperatureMaxTime(Long apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("time", time).append("summary", summary).append("icon", icon).append("sunriseTime", sunriseTime).append("sunsetTime", sunsetTime).append("moonPhase", moonPhase).append("precipIntensity", precipIntensity).append("precipIntensityMax", precipIntensityMax).append("precipIntensityMaxTime", precipIntensityMaxTime).append("precipProbability", precipProbability).append("precipAccumulation", precipAccumulation).append("precipType", precipType).append("temperatureHigh", temperatureHigh).append("temperatureHighTime", temperatureHighTime).append("temperatureLow", temperatureLow).append("temperatureLowTime", temperatureLowTime).append("apparentTemperatureHigh", apparentTemperatureHigh).append("apparentTemperatureHighTime", apparentTemperatureHighTime).append("apparentTemperatureLow", apparentTemperatureLow).append("apparentTemperatureLowTime", apparentTemperatureLowTime).append("dewPoint", dewPoint).append("humidity", humidity).append("pressure", pressure).append("windSpeed", windSpeed).append("windBearing", windBearing).append("cloudCover", cloudCover).append("uvIndex", uvIndex).append("uvIndexTime", uvIndexTime).append("visibility", visibility).append("temperatureMin", temperatureMin).append("temperatureMinTime", temperatureMinTime).append("temperatureMax", temperatureMax).append("temperatureMaxTime", temperatureMaxTime).append("apparentTemperatureMin", apparentTemperatureMin).append("apparentTemperatureMinTime", apparentTemperatureMinTime).append("apparentTemperatureMax", apparentTemperatureMax).append("apparentTemperatureMaxTime", apparentTemperatureMaxTime).append("additionalProperties", additionalProperties).toString();
    }

}

