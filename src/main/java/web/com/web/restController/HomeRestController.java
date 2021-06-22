package web.com.web.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.com.web.dao.RegionDao;
import web.com.web.dao.VendeurDao;
import web.com.web.dao.VenteDao;
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

    @GetMapping("")
    public List<Vente> getListeVentes() {
        return this.daoVente.findAll();
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
    public List<Vente> getListeVentesFiltrer(@RequestBody List<Region> regions, @RequestBody List<Vendeur> vendeurs) {
        return this.daoVente.findByRegIdAndVenId(0, 0);
    }
    
}
