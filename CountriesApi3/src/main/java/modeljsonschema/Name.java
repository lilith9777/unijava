
package modeljsonschema;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Name {
    private String common;
    private String official;
    private Map<String, Map<String, String>> nativeName;
    private Map<String, Object> additionalProperties;

    @JsonProperty("common")
    public String getCommon() {
        return common;
    }

    @JsonProperty("common")
    public void setCommon(String common) {
        this.common = common;
    }

    @JsonProperty("official")
    public String getOfficial() {
        return official;
    }

    @JsonProperty("official")
    public void setOfficial(String official) {
        this.official = official;
    }

    @JsonProperty("nativeName")
    public Map<String, Map<String, String>> getNativeName() {
        return nativeName;
    }

    @JsonProperty("nativeName")
    public void setNativeName(Map<String, Map<String, String>> nativeName) {
        this.nativeName = nativeName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    public String toString() {
        return "[common=" + common + ", official=" + official + ", nativeName=" + nativeName + "]";
    }
}
