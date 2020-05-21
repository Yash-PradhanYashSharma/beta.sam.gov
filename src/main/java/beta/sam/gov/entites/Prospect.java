
package beta.sam.gov.entites;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "isCanceled",
    "_rScore",
    "_type",
    "publishDate",
    "isActive",
    "title",
    "type",
    "descriptions",
    "solicitationNumber",
    "responseDate",
    "parentNoticeId",
    "award",
    "modifiedDate",
    "organizationHierarchy",
    "_id",
    "modifications"
})
public class Prospect {

    @JsonProperty("isCanceled")
    private Boolean isCanceled;
    @JsonProperty("_rScore")
    private Integer rScore;
    @JsonProperty("_type")
    private String oppertunity_type;
    @JsonProperty("publishDate")
    private String publishDate;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("descriptions")
    private List<Description> descriptions = null;
    @JsonProperty("solicitationNumber")
    private String solicitationNumber;
    @JsonProperty("responseDate")
    private String responseDate;
    @JsonProperty("parentNoticeId")
    private String parentNoticeId;
    @JsonProperty("award")
    private Award award;
    @JsonProperty("modifiedDate")
    private String modifiedDate;
    @JsonProperty("organizationHierarchy")
    private List<OrganizationHierarchy> organizationHierarchy = null;
    @JsonProperty("_id")
    private String id;
    @JsonProperty("modifications")
    private Modifications modifications;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isCanceled")
    public Boolean getIsCanceled() {
        return isCanceled;
    }

    @JsonProperty("isCanceled")
    public void setIsCanceled(Boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    @JsonProperty("_rScore")
    public Integer getRScore() {
        return rScore;
    }

    @JsonProperty("_rScore")
    public void setRScore(Integer rScore) {
        this.rScore = rScore;
    }

    @JsonProperty("_type")
    public String getOppertunityType() {
        return oppertunity_type;
    }

    @JsonProperty("_type")
    public void setOppertunityType(String oppertunity_type) {
        this.oppertunity_type = oppertunity_type;
    }

    @JsonProperty("publishDate")
    public String getPublishDate() {
        return publishDate;
    }

    @JsonProperty("publishDate")
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Type type) {
        this.type = type;
    }

    @JsonProperty("descriptions")
    public List<Description> getDescriptions() {
        return descriptions;
    }

    @JsonProperty("descriptions")
    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    @JsonProperty("solicitationNumber")
    public String getSolicitationNumber() {
        return solicitationNumber;
    }

    @JsonProperty("solicitationNumber")
    public void setSolicitationNumber(String solicitationNumber) {
        this.solicitationNumber = solicitationNumber;
    }

    @JsonProperty("responseDate")
    public String getResponseDate() {
        return responseDate;
    }

    @JsonProperty("responseDate")
    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    @JsonProperty("parentNoticeId")
    public String getParentNoticeId() {
        return parentNoticeId;
    }

    @JsonProperty("parentNoticeId")
    public void setParentNoticeId(String parentNoticeId) {
        this.parentNoticeId = parentNoticeId;
    }

    @JsonProperty("award")
    public Award getAward() {
        return award;
    }

    @JsonProperty("award")
    public void setAward(Award award) {
        this.award = award;
    }

    @JsonProperty("modifiedDate")
    public String getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("organizationHierarchy")
    public List<OrganizationHierarchy> getOrganizationHierarchy() {
        return organizationHierarchy;
    }

    @JsonProperty("organizationHierarchy")
    public void setOrganizationHierarchy(List<OrganizationHierarchy> organizationHierarchy) {
        this.organizationHierarchy = organizationHierarchy;
    }

    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("modifications")
    public Modifications getModifications() {
        return modifications;
    }

    @JsonProperty("modifications")
    public void setModifications(Modifications modifications) {
        this.modifications = modifications;
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
