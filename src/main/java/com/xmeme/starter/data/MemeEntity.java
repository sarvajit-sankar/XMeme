package com.xmeme.starter.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "memes")
@NoArgsConstructor
public class MemeEntity {
  @Id
  private String id;

  @NotBlank(message = "Name is required")
  private String name;
  
  @NotBlank(message = "URL is required")
  private String url;

  @NotBlank(message = "Caption is required")
  private String caption;
}
