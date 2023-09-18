package com.sa.socialcoding.sms.repository;

import com.sa.socialcoding.sms.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {
}
