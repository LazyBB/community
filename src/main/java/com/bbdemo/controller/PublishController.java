package com.bbdemo.controller;

import com.bbdemo.cache.TagCache;
import com.bbdemo.dto.QuestionDTO;
import com.bbdemo.model.Question;
import com.bbdemo.model.User;
import com.bbdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") long id, Model model) {
        QuestionDTO question = questionService.findById(id);

        model.addAttribute("title", question.getTitle());
        model.addAttribute("description", question.getDescription());
        model.addAttribute("tag", question.getTag());
        model.addAttribute("id",question.getId());
        model.addAttribute("tags", TagCache.get());
        return "publish";
    }

    @GetMapping("/publish")
    public String publish(Model model) {
        model.addAttribute("tags", TagCache.get());
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "tag", required = false) String tag,
//            @RequestParam(value = "id", required = false) long id,
            HttpServletRequest request,
            Model model) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        model.addAttribute("tags", TagCache.get());

        if (title == null || title == "") {
            model.addAttribute("error", "内容不能为空");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "内容不能为空");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }


        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
        tag=tag.replace('，',',');
        Question question = new Question();
        question.setTitle(title);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setDescription(description);
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
//        question.setId(id);
        questionService.CreateOrUpdate(question);
        return "redirect:/";
    }
}
