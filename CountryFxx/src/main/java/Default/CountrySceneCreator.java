package Default;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


import exception.CountryApiException;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.CountryInfo;
import services.CountryApiService;

public class CountrySceneCreator extends SceneCreator implements EventHandler<MouseEvent>{
	   VBox mainVBox;
	    HBox searchHBox;

    FlowPane buttonFlowPane;
    GridPane rootGridPane, inputFieldsPane;
    Button backButton, searchBtn,searchBtnC, searchBtnL,searchBtnAll,HistoryBtn;
    Label NameLbl, CurrencyLbl, LanguageLbl, CapitalLbl, PopulationLbl;
    TextField whatyousearchfor;
	TableView<CountryInfo> countryTableView;
	ArrayList<CountryInfo> countryList;
    private Deque<String> searchHistory;

    @SuppressWarnings("unchecked")
	public CountrySceneCreator(double width, double height) {
        super(width, height);
        searchHistory = new ArrayDeque<>();

		countryList = new ArrayList<CountryInfo>();
		 mainVBox = new VBox();
	        searchHBox = new HBox();
        buttonFlowPane = new FlowPane();
        rootGridPane = new GridPane();
        inputFieldsPane = new GridPane();
        backButton = new Button("Back");
        searchBtn = new Button("Search for Name");
        searchBtnL = new Button("Search for Language");
        searchBtnAll = new Button("See all countries");
        searchBtnC = new Button("Search for currency");
        HistoryBtn=new Button("See history");
        NameLbl = new Label("Searching bar");
        CurrencyLbl = new Label("Currency");
        LanguageLbl = new Label("Language");
        CapitalLbl = new Label("Capital");
        PopulationLbl = new Label("Population");
        whatyousearchfor = new TextField("Just type the thing");

		countryTableView= new TableView<CountryInfo>();
		buttonFlowPane.setAlignment(Pos.TOP_RIGHT);
        buttonFlowPane.setHgap(5);
        buttonFlowPane.getChildren().addAll(backButton,searchBtn,searchBtnL,searchBtnAll,searchBtnC, HistoryBtn);
        inputFieldsPane.setAlignment(Pos.TOP_CENTER);
        searchHBox.getChildren().addAll(inputFieldsPane, buttonFlowPane);
        searchHBox.setPadding(new Insets(10, 0, 10, 0)); // 10 pixels padding top and bottom, 0 pixels left and right

        mainVBox.getChildren().addAll( countryTableView);

        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);

        inputFieldsPane.add(NameLbl, 0, 0);
        inputFieldsPane.add(whatyousearchfor, 1, 0);

        rootGridPane.setAlignment(Pos.TOP_CENTER);

        rootGridPane.add(mainVBox,0,0);
        rootGridPane.add(searchHBox,0,1);


        
        TableColumn<CountryInfo,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<CountryInfo,String> capitalColumn = new TableColumn<>("Capital");
        capitalColumn.setCellValueFactory(new PropertyValueFactory<>("capital"));

        TableColumn<CountryInfo,String> languageColumn = new TableColumn<>("Language");
        languageColumn.setCellValueFactory(new PropertyValueFactory<>("languages"));

        TableColumn<CountryInfo,String> currencyColumn = new TableColumn<>("Currency");
        currencyColumn.setCellValueFactory(new PropertyValueFactory<>("currencies"));

        TableColumn<CountryInfo,String> populationColumn = new TableColumn<>("Population");
        populationColumn.setCellValueFactory(new PropertyValueFactory<>("population"));

        TableColumn<CountryInfo,String> continentColumn = new TableColumn<>("Continents");
        continentColumn.setCellValueFactory(new PropertyValueFactory<>("continents"));

        countryTableView.getColumns().addAll(nameColumn, capitalColumn, languageColumn, currencyColumn, populationColumn, continentColumn);

        backButton.setOnMouseClicked(this);
        searchBtn.setOnMouseClicked(this); 
        searchBtnL.setOnMouseClicked(this);
        searchBtnC.setOnMouseClicked(this);
        searchBtnAll.setOnMouseClicked(this);
        HistoryBtn.setOnMouseClicked(this);




    }

	@Override
	Scene createScene() {
		return new Scene(rootGridPane,width,height);
	}
//back
	@Override
	public void handle(MouseEvent event) {
	    if(event.getSource()==backButton) {
	        Main.primaryStage.setTitle("CountriesWebapp");
	        Main.primaryStage.setScene(Main.mainScene);

	    }
//bycurrency
	    if(event.getSource()==searchBtnC) {
	        String name = whatyousearchfor.getText();
	        searchHistory.push(name);

	        
	        System.out.println("Search by currency button clicked");
	        CountryApiService countryApiService = new CountryApiService("https://restcountries.com");
	        try {
	            List<CountryInfo> countries = countryApiService.searchForCountriesByCurrency(name);
	            if (countries.isEmpty()) {
                    AlertBox.display("No Results", "No results found for the provided query.");
                }
	            else{tableSync(countries);}
	            

	        } catch (CountryApiException e) {
	        	 System.out.println("Caught exception: " + e.getMessage());
	             showErrorDialog("An error occurred", "Can't find countries with this currency");
	             }}
	   //bylanguage
	     else if (event.getSource()==searchBtnL) {
	        String language = whatyousearchfor.getText();
	        searchHistory.push(language);

	        System.out.println("Search by language button clicked");

	        CountryApiService countryApiService = new CountryApiService("https://restcountries.com");
	        try {
	            List<CountryInfo> countries = countryApiService.searchForCountriesByLanguage(language);
	            if (countries.isEmpty()) {
                    AlertBox.display("No Results", "The language you searched doesn't exist");
                }
	            else{tableSync(countries);}
	            

	        } catch (CountryApiException e) {
	        	 System.out.println("Caught exception: " + e.getMessage());
	             showErrorDialog("An error occurred", "Can't find countries with this language");
	             }}
	    
	    
	  //bylanguage
	     else if(event.getSource()==searchBtnAll) {
		        String language = "Searched for all";

		        searchHistory.push(language);

	        System.out.println("Search for all button clicked");

	        CountryApiService countryApiService = new CountryApiService("https://restcountries.com");
	        try {
	            List<CountryInfo> countries = countryApiService.searchForCountries();
	            if (countries.isEmpty()) {
                    AlertBox.display("No Results", "No results found for the provided query.");
                }
	            else{tableSync(countries);}
	            

	        } catch (CountryApiException e) {
	        	 System.out.println("Caught exception: " + e.getMessage());
	             showErrorDialog("An error occurred", "There was an error while fetching country data. Please try again later");
	             }}
	    
	    
	    
	    
	    //byname
	     else if(event.getSource()==searchBtn) {
	        String name = whatyousearchfor.getText();
	        searchHistory.push(name);

	        System.out.println("Search for  button clicked");

	        CountryApiService countryApiService = new CountryApiService("https://restcountries.com");
	        try {
	            List<CountryInfo> countries = countryApiService.searchForCountriesByName(name);
	            if (countries.isEmpty()) {
                    AlertBox.display("No Results", "No results found for the provided query.");
                }
	            else{tableSync(countries);}
	            

	        } catch (CountryApiException e) {
	        	 System.out.println("Caught exception: " + e.getMessage());
	             showErrorDialog("Error","Can't find country with this name");
	             }}
	   
	     else if (event.getSource()==HistoryBtn) {
		        System.out.println("Search for history button clicked");
               try {	            

	    	    showSearchHistory();
              }
            catch(Exception e) {
                System.out.println(e);}

	    	 
	              }
	           if (searchHistory.size() > 5) {
                     searchHistory.removeLast();
        }
	    
	    
	}
	 public Deque<String> getSearchHistory() {
		    return searchHistory;
	    }
		 public void showSearchHistory() {
		        StringBuilder sb = new StringBuilder();
		        sb.append("Search History:\n");
		        for (String search : searchHistory) {
		            sb.append(search).append("\n");
		        }
		        Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setTitle("Search History");
		        alert.setHeaderText(null);
		        alert.setContentText(sb.toString());
		        alert.showAndWait();
		    }
	        
	    private void showErrorDialog(String title, String content) {
	    	    Platform.runLater(() -> {
	    	        Alert dialog = new Alert(AlertType.ERROR);
	    	        dialog.setTitle(title);
	    	        dialog.setHeaderText(null);
	    	        dialog.setContentText(content);
	    	        dialog.showAndWait();
	    	    });
	    	}
	
	    
	    
	
	
	public void clearTextFields() {
	    whatyousearchfor.clear();
	}
	
	
	public void tableSync(List<CountryInfo> countries) {
	    countryTableView.getItems().clear();
	    countryTableView.getItems().addAll(countries);
        clearTextFields();

	}
	}


