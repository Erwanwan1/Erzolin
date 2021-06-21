package web.com.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import web.com.web.model.Directeur;

public interface DirecteurDao extends JpaRepository<Directeur, Integer> {

}
