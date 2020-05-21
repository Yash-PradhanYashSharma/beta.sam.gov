
package beta.sam.gov.entites;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "zip",
    "country",
    "city",
    "streetAddress",
    "streetAddress2",
    "state"
})
public class Address {

    @JsonProperty("zip")
    private String zip;
    @JsonProperty("country")
    private String country;
    @JsonProperty("city")
    private String city;
    @JsonProperty("streetAddress")
    private String streetAddress;
    @JsonProperty("streetAddress2")
    private Object streetAddress2;
    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("streetAddress")
    public String getStreetAddress() {
        return streetAddress;
    }

    @JsonProperty("streetAddress")
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @JsonProperty("streetAddress2")
    public Object getStreetAddress2() {
        return streetAddress2;
    }

    @JsonProperty("streetAddress2")
    public void setStreetAddress2(Object streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
