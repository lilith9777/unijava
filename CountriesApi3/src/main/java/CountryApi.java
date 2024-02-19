import services.CountryApiService;

public class CountryApi {


public static CountryApiService getCountryApi() {
	return new CountryApiService("https://restcountries.com");
}
}