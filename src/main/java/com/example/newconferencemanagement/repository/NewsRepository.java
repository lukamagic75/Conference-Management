package com.example.newconferencemanagement.repository;

import com.example.newconferencemanagement.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 新闻仓库接口，提供基本的CRUD操作
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
