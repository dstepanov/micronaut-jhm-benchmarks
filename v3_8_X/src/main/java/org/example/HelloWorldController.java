package org.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class HelloWorldController {

    @Get
    String helloWorld() {
        return "Hello World!";
    }

}
