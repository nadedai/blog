package com.hhtt.blog.controller;

import com.hhtt.blog.Constant;
import com.hhtt.blog.pojo.Type;
import com.hhtt.blog.service.TypeService;
import com.hhtt.blog.util.PageRequest;
import com.hhtt.blog.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author hhtt
 * @date 2020/5/19 15:11
 * description:
 */
@Controller
@Slf4j
public class TypeController {
    final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("mg/type")
    public Object findPage(Model  model,Integer page) {
        if(page == null){
            page = 1;
        }
        PageResult pageRes = typeService.findPage(new PageRequest(page,Constant.PAGE_DEFAULT_SIZE));
        model.addAttribute("page",pageRes);
        return Constant.MG_TYPE_HTML;
    }

    //标签管理页面
    @GetMapping("/mg/type/input")
    public String typeInput(Model model){
        model.addAttribute("type",new Type());
        return Constant.MG_TYPE_INPUT_HTML;
    }

    //添加类型
    @PostMapping("/mg/type/input")
    public String typeInput(@Valid Type type, BindingResult result, Model model,RedirectAttributes attributes){
        if(result.hasErrors()){
            return Constant.MG_TYPE_INPUT_HTML;
        }
        int res = typeService.saveType(type);
        if(res > 0){
            model.addAttribute("msg","类型添加成功");
        }
        else{
            model.addAttribute("msg","类型添加失败");
        }
        return Constant.MG_TYPE_INPUT_HTML;
    }

    @GetMapping("/mg/type/delete")
    public String deleteType(Type type,Model model,RedirectAttributes attributes){
        int res = typeService.deleteType(type);
        if(res > 0){
            attributes.addFlashAttribute("msg","删除成功");
            return "redirect:/mg/type";
        }
        model.addAttribute("msg","删除失败");
        return Constant.MG_TYPE_HTML;
    }

    @GetMapping("/mg/type/edit")
    public String editType(Type type, Model model, RedirectAttributes attributes){
        //已经存在该类型
        if(typeService.getType(type.getName()) != null){
            attributes.addFlashAttribute("msg","失败:此类型已存在");
            return "redirect:/mg/type";
        }
        int res = typeService.updateType(type);
        if(res > 0){
            attributes.addFlashAttribute("msg","编辑成功");
            return "redirect:/mg/type";
        }
        attributes.addFlashAttribute("msg","编辑失败-未知错误");
        return "redirect:/mg/type";
    }



}
