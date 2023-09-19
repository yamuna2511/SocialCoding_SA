package com.sa.socialcoding.sms.repository;

import com.sa.socialcoding.sms.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module,Integer> {
    Module findByModuleId(int moduleId);

}
