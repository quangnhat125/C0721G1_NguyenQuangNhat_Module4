package com.codegym.validatemusicinfo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "song")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(max = 800)
    @Pattern(regexp = "[A-z0-9]*", message = "Please enter correct format!")
    private String nameSong;
    @NotEmpty
    @Size(max = 300)
    @Pattern(regexp = "[A-z0-9]*", message = "Please enter correct format!")
    private String nameSinger;
    @NotEmpty
    @Size(max = 1000)
    @Pattern(regexp = "[A-z0-9,]*", message = "Please enter correct format!")
    private String typeSong;

    public Music() {
    }

    public Music(Long id, @NotEmpty @Size(max = 800) @Pattern(regexp = "[A-z0-9]*") String nameSong, @NotEmpty @Size(max = 300) @Pattern(regexp = "[A-z0-9]*") String nameSinger, @NotEmpty @Size(max = 1000) @Pattern(regexp = "[A-z0-9,]*") String typeSong) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.typeSong = typeSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getTypeSong() {
        return typeSong;
    }

    public void setTypeSong(String typeSong) {
        this.typeSong = typeSong;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
