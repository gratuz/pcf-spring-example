package com.example.customer;

import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;



//Rest Assured
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import io.restassured.module.jsv.JsonSchemaValidator.*;

import java.io.IOException;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
