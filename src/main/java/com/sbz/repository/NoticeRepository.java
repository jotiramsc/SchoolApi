package com.sbz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbz.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

}
