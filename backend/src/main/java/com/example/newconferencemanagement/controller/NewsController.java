package com.example.newconferencemanagement.controller;

import com.example.newconferencemanagement.dto.NewsDTO;
import com.example.newconferencemanagement.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 新闻控制器类，处理新闻相关的HTTP请求
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<NewsDTO> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/{id}")
    public NewsDTO getNewsById(@PathVariable Long id) {
        return newsService.getNewsById(id);
    }

    @PostMapping
    public void createNews(@RequestBody NewsDTO newsDTO) {
        newsService.createNews(newsDTO);
    }

    @PutMapping("/{id}")
    public void updateNews(@PathVariable Long id, @RequestBody NewsDTO newsDTO) {
        newsService.updateNews(id, newsDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
    }
}
