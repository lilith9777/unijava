package services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import exception.CountryApiException;
import model.CountryInfo;
import modeljsonschema.CountryResult;



public class CountryApiService {
	
	private String API_URL;
	
	
	public  CountryApiService(String aPI_URL) {
		API_URL = aPI_URL;
	}
	
	

	//Ανάκτηση λίστας όλων των χωρών.
	//https://restcountries.com/v3.1/all
	
	public List<CountryInfo> searchForCountries() throws CountryApiException{
		List<CountryResult>countryresults = getAPIData("all","");
		 List<CountryInfo> countryInfos = new ArrayList<>();	
		 for (CountryResult countryResult : countryresults) {
            if (countryResult != null ) {
                // Create a new CountryInfo object
            	CountryInfo countryInfo = new CountryInfo(countryResult);
                countryInfos.add(countryInfo);
		}}
		return countryInfos;
		}
	
	//Ανάκτηση πληροφοριών  με χρήση του ονόματός της. 
	//https://restcountries.com/v3.1/name/{name}
	public List<CountryInfo> searchForCountriesByName(String param) throws CountryApiException{
		List<CountryResult>countryresults = getAPIData("name",param);
		 List<CountryInfo> countryInfos = new ArrayList<>();	
		 for (CountryResult countryResult : countryresults) {
            if (countryResult != null ) {
                // Create a new CountryInfo object
            	CountryInfo countryInfo = new CountryInfo(countryResult);
                countryInfos.add(countryInfo);
		}}
		return countryInfos;
		}
		
		
	// Ανάκτηση λίστας χωρών που χρησιμοποιούν ένα συγκεκριμένο νόμισμα..
		//https://restcountries.com/v3.1/currency/{currency}
		//GETAPI
	public List<CountryInfo> searchForCountriesByCurrency(String param) throws CountryApiException{
		List<CountryResult>countryresults = getAPIData("currency",param);
		 List<CountryInfo> countryInfos = new ArrayList<>();	
		 for (CountryResult countryResult : countryresults) {
            if (countryResult != null ) {
                // Create a new CountryInfo object
            	CountryInfo countryInfo = new CountryInfo(countryResult);
                countryInfos.add(countryInfo);
		}}
		return countryInfos;
		}
	
	//Ανάκτηση λίστας χωρών που μιλούν μία συγκεκριμένη γλώσσα.
	//https://restcountries.com/v3.1/lang/{language}
	//?fields=capital&fields=continents&fields=languages&fields=currencies&fields=name&fields=population
	public List<CountryInfo> searchForCountriesByLanguage(String param) throws CountryApiException{
		List<CountryResult>countryresults = getAPIData("lang",param);
		 List<CountryInfo> countryInfos = new ArrayList<>();	
		 for (CountryResult countryResult : countryresults) {
            if (countryResult != null ) {
                // Create a new CountryInfo object
            	CountryInfo countryInfo = new CountryInfo(countryResult);
                countryInfos.add(countryInfo);
		}}
		return countryInfos;
		}
		


	

	
	private List<CountryResult> getAPIData(String characteristic, String specific) throws CountryApiException {
        String fields = "capital,continents,languages,currencies,name,population";
        try {
            URIBuilder uribuilder = new URIBuilder(API_URL).setPathSegments("v3.1", characteristic, specific);
            if (!"all".equals(characteristic)) {
                uribuilder.addParameter("fields", fields);
            }
            URI url = uribuilder.build();
            // Use the URI for making the API request
            HttpGet getRequest = new HttpGet(url);
            // Create an HttpClient
            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                    CloseableHttpResponse response = httpClient.execute(getRequest)) {
                // Check if the response is successful (status code 200)
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    // Get the response entity
                    HttpEntity entity = response.getEntity();
                    // Create an ObjectMapper to parse JSON
                    ObjectMapper mapper = new ObjectMapper();
                    // Convert the JSON response to a List of CountryResult objects
                    return mapper.readValue(entity.getContent(), new TypeReference<List<CountryResult>>() {});
                } else {
                    // If the response status is not OK, handle the error
                    // You can choose to throw an exception or handle it differently
                    throw new CountryApiException("Error occurred on the API call: " + response.getStatusLine().getReasonPhrase());
                }
            } catch (IOException e) {
                throw new CountryApiException("Problem with HTTP request", e);
            }
        } catch (URISyntaxException e) {
            throw new CountryApiException("Unable to build URL", e);
        }
    }
}
   

