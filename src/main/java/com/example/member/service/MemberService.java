package com.example.member.service;

import com.example.member.dto.DiaryDTO;
import com.example.member.dto.MemberDTO;
import com.example.member.entity.DiaryEntity;
import com.example.member.entity.MemberEntity;
import com.example.member.repository.DiaryRepository;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final DiaryRepository diaryRepository;

    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);

    }

    public void saveDiary(DiaryDTO diaryDTO) {
        DiaryEntity diaryEntity = DiaryEntity.toDiaryEntity(diaryDTO);
        diaryRepository.save(diaryEntity);
    }

    public List<DiaryDTO> findAll(){
        List<DiaryEntity> diaryEntityList = diaryRepository.findAll();
        List<DiaryDTO> diaryDTOList = new ArrayList<>();
        for(DiaryEntity diaryEntity : diaryEntityList){
            diaryDTOList.add(DiaryDTO.toDiaryDTO(diaryEntity));

        }
        return diaryDTOList;
    }

    public MemberDTO login(MemberDTO memberDTO){
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if(byMemberEmail.isPresent()){
            MemberEntity memberEntity = byMemberEmail.get();
            if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

}
