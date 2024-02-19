import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import exception.CountryApiException;
import model.CountryInfo;
import services.CountryApiService;


 
public class CountryApiTest {
	 
//	@Test
//	public void testSearchAPI() throws CountryApiException {
//		final CountryApiService nameSearchService = CountryApi.getCountryApi();
//	final List<CountryInfo> results = nameSearchService.searchForCountriesByName("Sweden");
//		Assert.assertFalse(results.isEmpty());
//		results.forEach(System.out::println);
//	}
@Test
	public void testSearchAPI1() throws CountryApiException {
		final CountryApiService currencySearchService = CountryApi.getCountryApi();
		final List<CountryInfo> results = currencySearchService.searchForCountriesByCurrency("EUR");
		Assert.assertFalse(results.isEmpty());
		results.forEach(System.out::println);
}
		@Test
	public void testSearchAPI2() throws CountryApiException {
		final CountryApiService currencySearchService = CountryApi.getCountryApi();
		final List<CountryInfo> results = currencySearchService.searchForCountries();
		Assert.assertFalse(results.isEmpty());
		results.forEach(System.out::println);
}
}
