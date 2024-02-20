package com.example.esercizio1902.repository;

import it.epicode.w7d1t.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer>, PagingAndSortingRepository<BlogPost, Integer> {
}
