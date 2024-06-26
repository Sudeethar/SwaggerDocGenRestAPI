package com.radium.test.controller;

import com.radium.test.service.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/radium")
public class MusicController {
    private final ArtistService artistService;
    Logger log = LoggerFactory.getLogger(MusicController.class);
    public MusicController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping(path = "/artists/mostProductive",produces = {MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<List<String>> mostProductiveArtists(@RequestParam(name = "topn", defaultValue = "1") Integer topn) {
        log.info("getting top {} most productive artists", topn);
        return ResponseEntity.ok(artistService.getMostProductiveArtists(topn));

    }

     @GetMapping(value = "/artists/mostProductiveSQL")
    public ResponseEntity<List<String>> mostProductiveSQL(@RequestParam(name = "topn", defaultValue = "1") Integer topn) {
        log.info("getting top {} most productive artists", topn);
        return ResponseEntity.ok(artistService.mostProductiveSQL(topn));

    }

}
