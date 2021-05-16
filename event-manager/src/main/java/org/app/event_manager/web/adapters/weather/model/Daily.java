package org.app.event_manager.web.adapters.weather.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
public class Daily {

    @JsonProperty("data")
    private List<Datum_> data = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Daily() {
    }

    /**
     *
     * @param data
     */
    public Daily(List<Datum_> data) {
        super();
        this.data = data;
    }

    @JsonProperty("data")
    public List<Datum_> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum_> data) {
        this.data = data;
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
        return new ToStringBuilder(this).append("data", data).append("additionalProperties", additionalProperties).toString();
    }

}
