package com.example.member.dto;

import com.example.member.entity.DiaryEntity;
import com.example.member.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DiaryDTO {
    private Long id;
    private Date date;
    private String emotion;
    private String contents;

    public static DiaryDTO toDiaryDTO(DiaryEntity diaryEntity){
        DiaryDTO diaryDTO = new DiaryDTO();
        diaryDTO.setId(diaryEntity.getId());
        diaryDTO.setDate(diaryEntity.getDate());
        diaryDTO.setEmotion(diaryEntity.getEmotion());
        diaryDTO.setContents(diaryEntity.getContents());
        return diaryDTO;
    }

    // 추가
    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "DiaryDTO{" +
                "emotion='" + emotion + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }

}
