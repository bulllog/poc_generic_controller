package com.dlab.demo.controller;


import com.dlab.demo.model.RequestInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class TestController {
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public ResponseEntity<String> check(@RequestBody RequestInterface request){
        try {
            ObjectMapper o = new ObjectMapper();
            return new ResponseEntity<String>(o.writeValueAsString(request), HttpStatus.ACCEPTED);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>("Error occured while execution", HttpStatus.BAD_GATEWAY);
        }
    }
}
