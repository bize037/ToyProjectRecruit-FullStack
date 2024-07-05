package com.example.toy.dto;


import com.example.toy.entity.Board;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardDTO {
    private Long writeidx;
    private String writetitle;
    private String writecontent;
    private String writerecruit;
    private String writeonline;
    private String writeoffline;
    private String writecall;
    private String writecallurl;
    private String userid;
    private String writepw;
    private String writetype;
    private String writeuselang;
    private String writepeoplecnt;
    private String writecareer;

    @Builder
    public BoardDTO(Long writeidx, String writetitle, String writecontent,
                    String writerecruit, String writeonline, String writeoffline,
                    String writecall, String writecallurl, String userid, String writepw,
                    String writetype, String writeuselang, String writepeoplecnt, String writecareer) {
        this.writeidx = writeidx;
        this.writetitle = writetitle;
        this.writecontent = writecontent;
        this.writerecruit = writerecruit;
        this.writeonline = writeonline;
        this.writeoffline = writeoffline;
        this.writecall = writecall;
        this.writecallurl = writecallurl;
        this.userid = userid;
        this.writepw = writepw;
        this.writetype = writetype;
        this.writeuselang = writeuselang;
        this.writepeoplecnt = writepeoplecnt;
        this.writecareer = writecareer;
    }

    public Board toEntity() {
        return new Board(writeidx, writetitle, writecontent, writerecruit,
            writeonline, writeoffline, writecall, writecallurl, userid, writepw, writetype, writeuselang, writepeoplecnt, writecareer);
    }
}
