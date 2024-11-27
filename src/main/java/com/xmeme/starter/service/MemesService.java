package com.xmeme.starter.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmeme.starter.data.MemeEntity;
import com.xmeme.starter.exceptions.DuplicateResourceException;
import com.xmeme.starter.exceptions.MemeNotFoundException;
import com.xmeme.starter.exchange.MemePostResponseDto;
import com.xmeme.starter.repository.MemesRepository;

@Service
@RequiredArgsConstructor
public class MemesService {
  @Autowired
  private final MemesRepository memesRepository;

  public MemePostResponseDto postMeme(MemeEntity meme) {
    // Check for duplicate memes
    if (memesRepository.existsByNameOrCaptionOrUrl(
        meme.getName(), 
        meme.getCaption(), 
        meme.getUrl()
    )) {
      throw new DuplicateResourceException("Duplicate meme found");
    }

    MemeEntity savedMeme = memesRepository.save(meme);
    return new MemePostResponseDto(savedMeme.getId());
  }

  public List<MemeEntity> getTopHundredMemes() {
    return memesRepository.findTop100ByOrderByIdDesc();
  }

  public MemeEntity getMemeById(String id) {
    return memesRepository.findById(id).orElseThrow(() -> new MemeNotFoundException(id));
  }
}