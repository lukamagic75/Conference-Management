package com.example.newconferencemanagement.dto;

import com.example.newconferencemanagement.model.News;

/**
 * 新闻数据传输对象，用于在应用层和服务层之间传输数据
 */
public class NewsDTO {
    private Long id;
    private String title;
    private String summary;
    private String content;
    private String author;
    private String imageUrl;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public News toEntity() {
        News news = new News();
        news.setId(this.id);
        news.setTitle(this.title);
        news.setSummary(this.summary);
        news.setContent(this.content);
        news.setAuthor(this.author);
        news.setImageUrl(this.imageUrl);
        return news;
    }

    public NewsDTO(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.summary = news.getSummary();
        this.content = news.getContent();
        this.author = news.getAuthor();
        this.imageUrl = news.getImageUrl();
    }
}
