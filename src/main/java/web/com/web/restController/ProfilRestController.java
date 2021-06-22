package web.com.web.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.com.web.dao.UtilisateurDao;
import web.com.web.model.Utilisateur;

@RestController
@RequestMapping({"/api/profil/"})
@CrossOrigin
public class ProfilRestController {
    
    @Autowired
    private UtilisateurDao daoUtilisateur;
    
    @GetMapping("{id}")
    public Utilisateur getUtilisateur(@PathVariable int id) {
        return this.daoUtilisateur.getById(id);
    }

    @PostMapping("")
    public void saveUtilisateur(@RequestBody Utilisateur utilisateur) {
        this.daoUtilisateur.save(utilisateur);
    }
}
