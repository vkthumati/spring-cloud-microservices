package com.spring.restws.controller;

import com.spring.restws.model.v1.Person;
import com.spring.restws.model.v2.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/v1/person")
    public Person getPersonV1(){
        return new Person("Vasantha Kumar Thumati");
    }

    @GetMapping("/v2/person")
    public com.spring.restws.model.v2.Person getPersonV2(){
        return new com.spring.restws.model.v2.Person(new Name("Vasantha", "Kumar", "Thumati"));
    }

    @GetMapping(value = "/person/param", params = "version=v1")
    public Person getPersonParamV1(){
        return new Person("Vasantha Kumar Thumati");
    }

    @GetMapping(value = "/person/param", params = "version=v2")
    public com.spring.restws.model.v2.Person getPersonParamV2(){
        return new com.spring.restws.model.v2.Person(new Name("Vasantha", "Kumar", "Thumati"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=v1")
    public Person getPersonHeaderV1(){
        return new Person("Vasantha Kumar Thumati");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=v2")
    public com.spring.restws.model.v2.Person getPersonHeaderV2(){
        return new com.spring.restws.model.v2.Person(new Name("Vasantha", "Kumar", "Thumati"));
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.thumati.app-v1+json")
    public Person getPersonProducesV1(){
        return new Person("Vasantha Kumar Thumati");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.thumati.app-v2+json")
    public com.spring.restws.model.v2.Person getPersonProducesV2(){
        return new com.spring.restws.model.v2.Person(new Name("Vasantha", "Kumar", "Thumati"));
    }
}
