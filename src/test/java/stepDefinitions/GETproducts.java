package stepDefinitions;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.contains;

import java.util.List;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GETproducts {
	RequestSpecification request;
	Response response;

	@Before
	public void setUp() {
		baseURI = "http://35.231.82.144"; // default is localhost
		basePath = "/products";
		port = 8080; // default is 8080
	}

	@Given("^The endpoint is already configured$")
	public void the_endpoint_is_already_configured() throws Throwable {
		request = given().accept(ContentType.JSON);

	}

	@When("^perform GET request with name \"([^\"]*)\"$")
	public void perform_GET_request_with_name(String name) throws Throwable {
		response = request.get("/name/" + name);
	}

	@Then("^status code (\\d+) OK should be returned$")
	public void status_code_OK_should_be_returned(int statusCode) throws Throwable {
		response.then().statusCode(statusCode);
	}

	@Then("^the return body \"([^\"]*)\" should have \"([^\"]*)\"$")
	public void the_return_body_should_have(String key, String value) throws Throwable {
		response.then().assertThat().body(key, hasItem(value));
	}

	@When("^I input a valid product name \"([^\"]*)\"$")
	public void i_input_a_valid_product_name(String name) throws Throwable {
		response = request.when().get("/name/" + name);
		response.then().log().all();
	}

	@Then("^I should have the status code (\\d+)$")
	public void i_should_have_the_status_code(int statusCode) throws Throwable {
		response.then().statusCode(statusCode);
	}

	@Then("^content type should be in \"([^\"]*)\" format$")
	public void content_type_should_be_in_format(String format) throws Throwable {
		if (format.equals("JSON")) {
			response.then().assertThat().contentType(ContentType.JSON);
			// .body(matchesJsonSchemaInClasspath("productsJson.json"));
		}
	}

	@Then("^the body response content should be matched$")
	public void the_body_response_content_should_be_matched(DataTable table) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<List<String>> data = table.raw();

		for (int i = 1; i < data.size(); i++) {
			response.then().assertThat().body(data.get(i).get(0), hasItem(data.get(i).get(1).toString()));

		}
	}

	@Then("^\"([^\"]*)\": \"([^\"]*)\" message should be returned$")
	public void message_should_be_returned(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// response.then().assertThat().body(contains(""), null);
	}

}
