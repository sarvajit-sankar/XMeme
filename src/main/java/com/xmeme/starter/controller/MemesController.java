package com.xmeme.starter.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmeme.starter.data.MemeEntity;
import com.xmeme.starter.exchange.MemePostResponseDto;
import com.xmeme.starter.service.MemesService;

@RestController
@RequestMapping("/memes/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MemesController {

  private final MemesService memesService;

  @PostMapping
  public ResponseEntity<MemePostResponseDto> createMeme(@Valid @RequestBody MemeEntity meme) {
    return ResponseEntity.status(HttpStatus.CREATED).body(memesService.postMeme(meme));
  }

  @GetMapping
  public ResponseEntity<List<MemeEntity>> getTopHundredMemes() {
    List<MemeEntity> memes = memesService.getTopHundredMemes();
    return ResponseEntity.ok(memes);
  }

  @GetMapping("{id}")
  public ResponseEntity<MemeEntity> getMemeById(@PathVariable String id) {
    MemeEntity meme = memesService.getMemeById(id);
    return ResponseEntity.ok(meme);
  }

}