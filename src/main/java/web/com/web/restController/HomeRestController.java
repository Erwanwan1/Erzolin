package web.com.web.restController;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.com.web.dao.RegionDao;
import web.com.web.dao.VendeurDao;
import web.com.web.dao.VenteDao;
import web.com.web.model.Filtre;
import web.com.web.model.Region;
import web.com.web.model.Vendeur;
import web.com.web.model.Vente;

@RestController
@RequestMapping({"/api/home/"})
@CrossOrigin
public class HomeRestController {
    
    @Autowired
    private VenteDao daoVente;

    @Autowired
    private RegionDao daoRegion;

    @Autowired
    private VendeurDao daoVendeur;

    @GetMapping("/directeur")
    public List<Vente> getListeVentesDirector() {
        return this.daoVente.findAll();
    }
    
    @GetMapping("/manager/{id}")
    public List<Vente> getListeVentesManager(@PathVariable int id) {
        List<Vente> ventes = new ArrayList<Vente>();

        for (Vente vente : this.daoVente.findAll()) {
            if (vente.getRegId().getId() == id) {
                ventes.add(vente);
            }
        }

        return ventes;
    }

    @GetMapping("/region")
    public List<Region> getListeRegions() {
        return this.daoRegion.findAll();
    }

    @GetMapping("/vendeur")
    public List<Vendeur> getListeVendeurs() {
        return this.daoVendeur.findAll();
    }

    @PostMapping("/filtre")
    public List<Vente> getListeVentesFiltrer(@RequestBody Filtre filtres) {
        List<Vente> ventes = new ArrayList<Vente>();
        if((filtres.getDateDebut() == null || filtres.getDateFin() == null) && filtres.getVendeurs().size() == 0){
            ventes = this.daoVente.findByRegIdIdIn(filtres.getRegions());
        }
        else if((filtres.getDateDebut() == null || filtres.getDateFin() == null) && filtres.getRegions().size() == 0){
            ventes = this.daoVente.findByVenIdIdIn(filtres.getVendeurs());
        }
        else if(filtres.getRegions().size() == 0 && filtres.getVendeurs().size() == 0){
            ventes = this.daoVente.findByDateFacturationBetween(filtres.getDateDebut(), filtres.getDateFin());
        }
        else if(filtres.getRegions().size() == 0){
            ventes = this.daoVente.findByVenIdIdInAndDateFacturationBetween(filtres.getVendeurs(), filtres.getDateDebut(), filtres.getDateFin());
        }
        else if(filtres.getVendeurs().size() == 0){
            ventes = this.daoVente.findByRegIdIdInAndDateFacturationBetween(filtres.getRegions(), filtres.getDateDebut(), filtres.getDateFin());
        } 
        else if(filtres.getDateDebut() == null || filtres.getDateFin() == null){
            ventes = this.daoVente.findByRegIdIdInAndVenIdIdIn(filtres.getRegions(), filtres.getVendeurs());
        }       
        else{
            ventes =  this.daoVente.findByRegIdIdInAndVenIdIdInAndDateFacturationBetween(filtres.getRegions(), filtres.getVendeurs(), filtres.getDateDebut(), filtres.getDateFin());
        }
        return ventes;
    }
    
}
