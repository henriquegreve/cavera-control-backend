package com.greve.cavera_control.images.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "gimages", schema = "public")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idimage", nullable = false)
    private Long idImage;

    @Lob
    @Column(name = "image")
    private byte[] imageData;

    @Column(name = "createiduser")
    private Long createIdUser;

    @Column(name = "createdate", nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "modifyiduser")
    private Long modifyIdUser;

    @Column(name = "modifydate", nullable = false)
    private LocalDateTime modifyDate = LocalDateTime.now();

}
