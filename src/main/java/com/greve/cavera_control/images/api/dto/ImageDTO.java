package com.greve.cavera_control.images.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {

    private Long idImage;

    @NotNull
    private byte[] imageData;

    private Long createIdUser;

    private LocalDateTime createDate = LocalDateTime.now();

    private Long modifyIdUser;

    private LocalDateTime modifyDate = LocalDateTime.now();

}
