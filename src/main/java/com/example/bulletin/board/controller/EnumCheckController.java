package com.example.bulletin.board.controller;

import com.example.bulletin.board.constant.CountryEnum;
import com.example.bulletin.board.constant.OnePeaceEnum;
import com.example.bulletin.board.model.dto.ClueDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/enum")
public class EnumCheckController {

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        List<String> clueList = OnePeaceEnum.getClueNameList();
        mav.addObject("clueList", clueList);
        mav.setViewName("enum/index");
        return mav;
    }

    @PostMapping("/check1")
    public ModelAndView check1(@RequestParam String country, ModelAndView mav) {
        String countryName = "";
        try {
            CountryEnum countryEnum = CountryEnum.valueOf(country);
            countryName = countryEnum.toString();
        } catch (IllegalArgumentException e) {
            // Enumに存在しない値が渡された場合はIllegalArgumentExceptionが発生する
            countryName = "国名が不正なのでIllegalArgumentExceptionが発生しました";
        }
        mav.addObject("country", countryName);
        mav.setViewName("enum/check1");
        return mav;
    }

    @PostMapping("/check2")
    public ModelAndView check2(@RequestParam CountryEnum country, ModelAndView mav) {
        // CountryEnumの列挙子以外が渡された場合はBad Request（400エラー）になる
        String message = country.toString();
        mav.addObject("message", message);
        mav.setViewName("enum/check2");
        return mav;
    }

    @PostMapping("/check3")
    public ModelAndView check3(@RequestParam OnePeaceEnum onePeaceClue, ModelAndView mav) {
        // 船員名はリクエストパラメータのString化
        String clueName = onePeaceClue.toString();
        // 選択された船員の情報はEnumで設定した定数を使用
        int clueNum = onePeaceClue.getNum();
        String clueRole = onePeaceClue.getRole();
        String clueSpecialMove = onePeaceClue.getSpecialMove();
        // DTOに格納してビューに渡す
        var clueDto = new ClueDto(clueName, clueNum, clueRole, clueSpecialMove);
        mav.addObject("clueDto", clueDto);
        mav.setViewName("enum/check3");
        return mav;
    }

    @GetMapping("/check4")
    public ModelAndView check4(ModelAndView mav) {
        List<ClueDto> list = OnePeaceEnum.getClueInfoList();
        mav.addObject("clueList", list);
        mav.setViewName("enum/check4");
        return mav;
    }

    @PostMapping("/check5")
    public ModelAndView check5(@RequestParam OnePeaceEnum onePeaceClue, ModelAndView mav) {
        String message = "3強メンバーではありません";
        if (OnePeaceEnum.isLuffyZoroSanji(onePeaceClue)) {
            message = "3強メンバーです";
        }
        mav.addObject("message", message);
        mav.setViewName("enum/check5");
        return mav;
    }

    @PostMapping("/check6")
    public ModelAndView check6(@RequestParam OnePeaceEnum onePeaceClue, ModelAndView mav) {
        String message = onePeaceClue.hasEatenDevilFruits() ? "悪魔の実を食べています" : "悪魔の実を食べていません";
        mav.addObject("message", message);
        mav.setViewName("enum/check6");
        return mav;
    }

}
