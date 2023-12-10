package com.example.BookMyShow_Application.Controllers;

import com.example.BookMyShow_Application.RequestDtos.AddTheatreRequest;
import com.example.BookMyShow_Application.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theatre")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("/addTheatre")
    public ResponseEntity addTheatre(@RequestBody AddTheatreRequest addTheatreRequest) {
        String result = theatreService.addTheatre(addTheatreRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
