package com.example.member.entity;

import com.example.member.dto.DiaryDTO;
import com.example.member.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Setter
@Getter
@Table(name = "diary_table")
public class DiaryEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 지정
    private Long id;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date date;

    @Column
    private String emotion;

    @Column String contents;

    public static DiaryEntity toDiaryEntity(DiaryDTO diaryDTO){
        DiaryEntity diaryEntity = new DiaryEntity();
        diaryEntity.setDate(diaryDTO.getDate());
        diaryEntity.setContents(diaryDTO.getContents());
        return diaryEntity;
    }
}
