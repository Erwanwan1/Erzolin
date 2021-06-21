package web.com.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import web.com.web.model.Manager;

public interface ManagerDao extends JpaRepository<Manager, Integer> {
    
}
