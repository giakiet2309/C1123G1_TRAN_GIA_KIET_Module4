package com.example.thim4p2.controller;


import com.example.thim4p2.dto.ThanhPhoDto;
import com.example.thim4p2.model.QuocGia;
import com.example.thim4p2.model.ThanhPho;
import com.example.thim4p2.service.IQuocGiaService;
import com.example.thim4p2.service.IThanhPhoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/thanhPho")
public class ThanhPhoController {
    @Autowired
    IThanhPhoService iThanhPhoService;
    @Autowired
    IQuocGiaService iQuocGiaService;
    @GetMapping("")
    public String hienThiThanhPho(Model model){
        List<ThanhPho> thanhPhos = iThanhPhoService.hienThiThanhPho();
        model.addAttribute("thanhPhos",thanhPhos);
        return "home";
    }
    @GetMapping("/them")
    public String hienThiFormThem(Model model){
        ThanhPhoDto thanhPhoDto = new ThanhPhoDto();
        List<QuocGia> quocGias = iQuocGiaService.hienThiTatCa();
        model.addAttribute("thanhPhoDto",thanhPhoDto);
        model.addAttribute("quocGias",quocGias);
        return "/add";
    }
    @PostMapping("/them")
    public String themMoiThanhPho(@Valid @ModelAttribute("thanhPhoDto") ThanhPhoDto thanhPhoDto , BindingResult bindingResult ,Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            List<QuocGia> quocGias = iQuocGiaService.hienThiTatCa();
            model.addAttribute("quocGias",quocGias);
            return "/add";
        }else {
            ThanhPho thanhPho = new ThanhPho();
            BeanUtils.copyProperties(thanhPhoDto,thanhPho);
            iThanhPhoService.luu(thanhPho);
            redirectAttributes.addFlashAttribute("msg",1);
            return "redirect:/thanhPho";
        }
    }
    @GetMapping("/chinhSua/{id}")
    public String hienThiFormChinhSua(Model model , @PathVariable int id){
        ThanhPho thanhPho = new ThanhPho();
        ThanhPhoDto thanhPhoDto = new ThanhPhoDto();
        thanhPho = iThanhPhoService.chiTiet(id);
        BeanUtils.copyProperties(thanhPho,thanhPhoDto);
        List<QuocGia> quocGias = iQuocGiaService.hienThiTatCa();
        model.addAttribute("thanhPhoDto",thanhPhoDto);
        model.addAttribute("quocGias",quocGias);
        return "/edit";
    }
    @PostMapping("/chinhSua")
    public String chinhSua(@Valid @ModelAttribute("thanhPhoDto") ThanhPhoDto thanhPhoDto,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){
        if (bindingResult.hasFieldErrors()){
            List<QuocGia> quocGias = iQuocGiaService.hienThiTatCa();
            model.addAttribute("quocGias",quocGias);
            return "/edit";
        }else {
            ThanhPho thanhPho = new ThanhPho();
            BeanUtils.copyProperties(thanhPhoDto,thanhPho);
            iThanhPhoService.luu(thanhPho);
            redirectAttributes.addFlashAttribute("msg",2);
            return "redirect:/thanhPho";
        }
    }
    @GetMapping("/chiTiet/{id}")
    public String chiTiet(@PathVariable int id,Model model){
        ThanhPho thanhPho = iThanhPhoService.chiTiet(id);
        model.addAttribute("thanhPho",thanhPho);
        return "/detail";
    }
//    @GetMapping("/xoa/{id}")
//    public String xoa(@PathVariable int id,RedirectAttributes redirectAttributes){
//        iThanhPhoService.xoaThanhPho(id);
//        redirectAttributes.addFlashAttribute("msg",3);
//        return "redirect:/thanhPho";
//    }
    @GetMapping("/xoa")
    public String xoa(@RequestParam("id") int id,RedirectAttributes redirectAttributes){
        iThanhPhoService.xoaThanhPho(id);
        redirectAttributes.addFlashAttribute("msg",3);
        return "redirect:/thanhPho";
    }
}
