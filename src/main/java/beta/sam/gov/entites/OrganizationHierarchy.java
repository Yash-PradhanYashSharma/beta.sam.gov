
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
    "organizationId",
    "address",
    "level",
    "name",
    "type",
    "status"
})
public class OrganizationHierarchy {

    @JsonProperty("organizationId")
    private String organizationId;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("status")
    private Object status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("organizationId")
    public String getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("organizationId")
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("status")
    public Object getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Object status) {
        this.status = status;
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
