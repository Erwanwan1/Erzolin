package web.com.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import web.com.web.model.Vendeur;

public interface VendeurDao extends JpaRepository<Vendeur, Integer> {
    
}
