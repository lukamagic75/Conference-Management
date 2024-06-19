package com.example.newconferencemanagement.service;

import com.example.newconferencemanagement.dto.NewsDTO;
import com.example.newconferencemanagement.exception.NewsNotFoundException;
import com.example.newconferencemanagement.model.News;
import com.example.newconferencemanagement.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 新闻服务类，处理新闻相关的业务逻辑
 */
@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<NewsDTO> getAllNews() {
        return newsRepository.findAll().stream()
                .map(NewsDTO::new)
                .collect(Collectors.toList());
    }

    public NewsDTO getNewsById(Long id) {
        News news = newsRepository.findById(id)
                .orElseThrow(() -> new NewsNotFoundException("News not found"));
        return new NewsDTO(news);
    }

    public void createNews(NewsDTO newsDTO) {
        newsRepository.save(newsDTO.toEntity());
    }

    public void updateNews(Long id, NewsDTO newsDTO) {
        if (newsRepository.existsById(id)) {
            newsRepository.save(newsDTO.toEntity());
        } else {
            throw new NewsNotFoundException("News not found");
        }
    }

    public void deleteNews(Long id) {
        if (newsRepository.existsById(id)) {
            newsRepository.deleteById(id);
        } else {
            throw new NewsNotFoundException("News not found");
        }
    }
}
