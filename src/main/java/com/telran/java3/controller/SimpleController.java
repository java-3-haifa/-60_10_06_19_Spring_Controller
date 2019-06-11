package com.telran.java3.controller;

import com.telran.java3.controller.dto.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//@Controller
@RestController
public class SimpleController {

    @RequestMapping(value = "/hello",
            method = RequestMethod.GET,
            produces = "*/*")
//    @ResponseBody
    public String sayHello(){
        return "Hello!";
    }

    @RequestMapping(value = "/getPerson",
            method = RequestMethod.GET,
            produces = "application/json")
//    @ResponseBody
    public PersonDto getPerson(){
        PersonDto res = new PersonDto();
        res.name = "Vasya";
        res.phone = "05555555";
//        return "{\"fullName\":\""+res.name+"\",\"phoneNumber\":\""+res.phone+"\"}";
        return res;
    }

//    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
//    public void addPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
//        String line;
//        StringBuilder sb = new StringBuilder();
//        while((line = br.readLine())!=null){
//            sb.append(line);
//        }
//        br.close();
//        System.out.println(sb);
//
//        response.setStatus(201);
//        response.setHeader("Content-Type","*/*");
//        response.getWriter().println("Person added");
//
//    }

    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
//    @ResponseBody
    public void addPerson(@RequestBody PersonDto person/*, HttpServletResponse res*/) {
        throw new OutOfMemoryError("Person is null");
//        System.out.println(person.name + " " + person.phone);
//        res.setStatus(204);
    }

//    @RequestMapping(value = "/person",method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity<String> setPerson(@RequestBody PersonDto person){
//        System.out.println(person.name + " " + person.phone);
////        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
//    }

//    @RequestMapping(value = "/person",method = RequestMethod.POST)
//    @ResponseBody
    @PostMapping("/person")
    public ResponseEntity<PersonDto> setPerson(@RequestBody PersonDto person){
        System.out.println(person.name + " " + person.phone);
//        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(person);
    }


    @DeleteMapping("/person/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") long id){
        System.out.println("id: " + id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/person")
    public PersonDto getPersonById(@RequestParam(value = "id", defaultValue = "555") int id){
        PersonDto res = new PersonDto();
        res.name = "Person " + id;
        res.phone = "123456789";
        return res;
    }



}
