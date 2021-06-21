package web.com.web.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import web.com.web.model.Region;

public interface RegionDao extends JpaRepository<Region, Integer> {
    
}
