package com.example.member.controller;

import com.example.member.dto.DiaryDTO;
import com.example.member.dto.MemberDTO;
import com.example.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    // 생성자 주입
    private final MemberService memberService;

    // 회원가입 페이지 출력요청
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }

    // 회원가입 저장
    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "login";
    }
    //로그인
    @GetMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        MemberDTO loginResult = memberService.login(memberDTO);
        if(loginResult != null) {
            session.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "main";
        }else{
            return "login";
        }
    }

    //일기 내용 저장
    @PostMapping("/member/saveDiary")
    public String save(@ModelAttribute DiaryDTO diaryDTO) {
        System.out.println("memberDTO = " + diaryDTO);
        System.out.println("Emotion: " + diaryDTO.getEmotion());
        System.out.println("Contents: " + diaryDTO.getContents());
        memberService.saveDiary(diaryDTO);
        return "main";
    }

    //일기 리스트
    @GetMapping("/member/diary")
    public String findAll(Model model){
        List<DiaryDTO> diaryDTOList = memberService.findAll();
        model.addAttribute("diaryList", diaryDTOList);
        return "diary";
    }

    // main으로
    @GetMapping("/member/main")
    public String main() {
        return "main";
    }

    // calendar로
    @GetMapping("/member/calendar")
    public String calendar() {
        return "calendar";
    }



}
