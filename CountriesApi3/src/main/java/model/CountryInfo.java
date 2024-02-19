package model;

import modeljsonschema.CountryResult;
import modeljsonschema.Name;

import java.util.List;
import java.util.Map;



public class CountryInfo {
    private Name name;
    private Map<String, Map<String, String>> currencies;
    private List<String> capital;
    
    private Integer population;
    private List<String> continents;
    private Map<String, Object> additionalProperties;
    
    private Map<String, String> languages;

    
    
    
    


	// Getters and setters
    public CountryInfo() {
        // You can initialize fields to default values if needed
    }

    // Constructor with parameters to initialize all fields
   

    
    public CountryInfo(Name name,  Map<String, Map<String, String>> currencies, List<String> capital,Map<String, String>  languages, Integer population,
			List<String> continents, Map<String, Object> additionalProperties) {
		super();
		this.name = name;
		this.currencies =  currencies;
		this.capital = capital;
		this.languages =  languages;
		this.population = population;
		this.continents = continents;
		this.additionalProperties = additionalProperties;
	}
    public  CountryInfo(CountryResult result) {
		super();
		this.name = result.getName();
		this.currencies = result.getCurrencies();
		this.capital = result.getCapital();
		this.languages = (Map<String, String>) result.getLanguages();
		this.population = result.getPopulation();
		this.continents = result.getContinents();
		this.additionalProperties = result.getAdditionalProperties();
	}
    
    
   


	public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }



    

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

  

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public List<String> getContinents() {
        return continents;
    }

    public void setContinents(List<String> continents) {
        this.continents = continents;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

	public Map<String, Map<String, String>> getCurrencies() {
		return currencies;
	}


    public void setCurrencies(Map<String, Map<String, String>> currencies) {
        this.currencies = currencies;}

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

	@Override
	public String toString() {
		return "CountryInfo [name=" + name.getCommon() + ", currencies=" + currencies + ", capital=" + capital + ", population="
				+ population + ", continents=" + continents 
				+ ", languages=" + languages + "]"+ "\r\n";
	}
   
    
    
    
	}




