package com.reactproject.reactProject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "daum")
@ToString
public class BoardVO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int docNum;
    private String docTitle;
    private String docContent;
    private String docGenre;
    private LocalDateTime docDate;
    private String docLink;
    private String docThumbnail;

    @UpdateTimestamp
    private LocalDateTime docUpdated;
}
