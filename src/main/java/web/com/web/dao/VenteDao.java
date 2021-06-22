package web.com.web.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.com.web.model.Vente;

public interface VenteDao extends JpaRepository<Vente, Integer>  {
    public List<Vente> findByRegIdIdInAndVenIdIdInAndDateFacturationBetween(List<Integer> regIds, List<Integer> venIds, Date start, Date end);
}
