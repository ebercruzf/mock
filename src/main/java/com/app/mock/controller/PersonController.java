package com.app.mock.controller;

import com.app.mock.request.PersonRequestDTO;
import com.app.mock.response.PersonResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class PersonController {

    @PostMapping(value = "/create/person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponseDTO> createPerson
            (@RequestBody (required = true) PersonRequestDTO requestBody){

        PersonResponseDTO responseTest = new PersonResponseDTO();
        responseTest.setResponseName("Hola Mundo: "+requestBody.getName());
        responseTest.setResponseMessage("Nuevo" +requestBody.getMessage());

        return ResponseEntity.ok().body(responseTest);
    }

    @GetMapping(value = "/get/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponseDTO> getPerson
            (@PathVariable (name = "name", required = true) String nombrep){

        PersonResponseDTO getPersonName = new PersonResponseDTO();
        getPersonName.setResponseName(nombrep);
        getPersonName.setResponseMessage("Respuesta-controller");
        return ResponseEntity.ok().body(getPersonName);

    }


}
