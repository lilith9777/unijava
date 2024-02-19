
package modeljsonschema;

import java.util.LinkedHashMap;
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
    "name",
    "currencies",
    "capital",
    "languages",
    "population",
    "continents"
})
public class CountryResult {

    @JsonProperty("name")
    private Name name;
    @JsonProperty("currencies")
    private Map<String, Map<String, String>> currencies;
  



	@JsonProperty("capital")
    private List<String> capital;
    @JsonProperty("languages")
    private Map<String, String> languages;
    @JsonProperty("population")
    private Integer population;
    @JsonProperty("continents")
    private List<String> continents;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

  
    

    @JsonProperty("capital")
    public List<String> getCapital() {
        return capital;
    }

    @JsonProperty("capital")
    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

   
    

    @JsonProperty("population")
    public Integer getPopulation() {
        return population;
    }

    @JsonProperty("population")
    public void setPopulation(Integer population) {
        this.population = population;
    }

    @JsonProperty("continents")
    public List<String> getContinents() {
        return continents;
    }

    @JsonProperty("continents")
    public void setContinents(List<String> continents) {
        this.continents = continents;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	
public Map<String, Map<String, String>> getCurrencies() {
	return currencies;
	
}
public void setCurrencies(Map<String, Map<String, String>> currencies) {
    this.currencies = currencies;
}
public Map<String, String> getLanguages() {
	return languages;
}

public void setLanguages(Map<String, String> languages) {
	this.languages = languages;
}

public void setAdditionalProperties(Map<String, Object> additionalProperties) {
	this.additionalProperties = additionalProperties;
}}



