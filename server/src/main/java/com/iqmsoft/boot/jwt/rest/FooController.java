package com.iqmsoft.boot.jwt.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.springframework.web.bind.annotation.RequestMethod.GET;



@RestController
@RequestMapping( value = "/api/foo", produces = MediaType.APPLICATION_JSON_VALUE )
public class FooController {


    @RequestMapping( method = GET, value= "")
    public Map<String, String> getFoo() {
        Map<String, String> fooObj = new LinkedHashMap<>();
        fooObj.put("foo", "bar");
        fooObj.put("foo1", "bar1");
        fooObj.put("foo2", "bar2");
        return fooObj;
    }
    
    @RequestMapping( method = GET, value= "/sorted")
    public Map<String, String> getFooTest() {
        Map<String, String> fooObj = new TreeMap<>();
        fooObj.put("afoo", "bar");
        fooObj.put("bfoo1", "bar1");
        fooObj.put("rfoo2", "bar2");
        return fooObj;
    }

}
