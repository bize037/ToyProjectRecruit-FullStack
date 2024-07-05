package com.example.toy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WRITE_IDX")
    private Long writeidx;

    @Column(name = "WRITE_TITLE")
    private String writetitle;

    @Column(name = "WRITE_CONTENT", length = 800)
    private String writecontent;

    @Column(name = "WRITE_RECRUIT")
    private String writerecruit;

    @Column(name = "WRITE_ONLINE")
    private String writeonline;

    @Column(name = "WRITE_OFFLINE")
    private String writeoffline;

    @Column(name = "WRITE_CALL")
    private String writecall;

    @Column(name = "WRITE_CALL_URL")
    private String writecallurl;

    @Column(name = "USER_ID", unique = true)
    private String userid;

    @Column(name = "WRITE_PW")
    private String writepw;

    @Column(name = "WRITE_TYPE")
    private String writetype;

    @Column(name = "WRITE_USE_LANG")
    private String writeuselang;

    @Column(name = "WRITE_PEOPLE_CNT")
    private String writepeoplecnt;

    @Column(name = "WRITE_CAREER")
    private String writecareer;

}
