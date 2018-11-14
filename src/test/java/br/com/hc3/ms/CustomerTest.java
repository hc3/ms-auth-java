package br.com.hc3.ms;

import br.com.hc3.ms.controller.CustomerController;

import br.com.hc3.ms.repository.CustomerRepository;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


import static io.restassured.RestAssured.given;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBootWebApplication.class)
@TestPropertySource(value={"classpath:application-test.properties"})
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTest {

    private String token = null;
    JSONObject userJson = new JSONObject();
    JSONObject customer = new JSONObject();

    private static CustomerRepository customerRepository;

    @Autowired
    public void setRepository(CustomerRepository customerRepository) {
        CustomerTest.customerRepository = customerRepository;
    }

    @Before
    public void setup() throws JSONException {
        userJson.put("email","jose@mail.com");
        userJson.put("firstName","Jose");
        userJson.put("lastName","da Silva");
        userJson.put("username","jose");
        userJson.put("password","123456");
        userJson.put("active",true);
        userJson.put("online",false);
        customer.put("user",userJson);
        RestAssured.port = 8080;
        RestAssured.baseURI = "http://localhost";
    }

    @AfterClass
    public static void drop() {
        customerRepository.deleteAll();
    }


    @Test
    public void a_createCustomer() {

        given()
            .contentType("application/json")
            .body(customer.toString())
            .when()
                .post("/v1/customer")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .response();
    }

    @Test
    public void b_login() throws JSONException {

        JSONObject credentialsJson = new JSONObject();

        credentialsJson.put("username","jose");
        credentialsJson.put("password","123456");

        given()
            .contentType("application/json")
            .body(credentialsJson.toString())
            .when()
                .post("/v1/auth/signin")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .response();
    }

    @Test
    public void c_loginFalha() throws JSONException {

        JSONObject credentialsJson = new JSONObject();

        credentialsJson.put("username","jose");
        credentialsJson.put("password","1234567");

        given()
            .contentType("application/json")
            .body(credentialsJson.toString())
            .when()
                .post("/v1/auth/signin")
                .then()
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .extract()
                .response();
    }

}
