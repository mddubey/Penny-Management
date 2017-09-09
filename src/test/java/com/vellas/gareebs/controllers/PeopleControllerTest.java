package com.vellas.gareebs.controllers;


import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.vellas.gareebs.controller.HealthController;
import com.vellas.gareebs.launch.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
public class PeopleControllerTest {
    @Before
    public void before() {
        RestAssuredMockMvc.standaloneSetup(new HealthController());
    }

    @Test
    public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {
        given().
                when().
                get("http://localhost:8080/health").
                then()
                .assertThat()
                .statusCode(200)
                .body("", equalTo(""));
    }
}
