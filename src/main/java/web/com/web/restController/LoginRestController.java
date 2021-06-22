package web.com.web.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.com.web.dao.DirecteurDao;
import web.com.web.dao.ManagerDao;
import web.com.web.dao.UtilisateurDao;
import web.com.web.model.Directeur;
import web.com.web.model.Manager;
import web.com.web.model.Utilisateur;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping({"/api/login/"})
@CrossOrigin
public class LoginRestController {
    
    @Autowired
    private UtilisateurDao daoUtilisateur;
    
    @Autowired
    private ManagerDao daoManager;
    
    @Autowired
    private DirecteurDao daoDirecteur;

    @PostMapping("")
    public Object verifyCredentials(@RequestBody Utilisateur utilisateur) {
        Object connectedUtilisateur = new Object();
        List<Utilisateur> utilisateurs = this.daoUtilisateur.findAll();

        for (Utilisateur utilisateur2 : utilisateurs) {
            if (utilisateur.getEmail().equals(utilisateur2.getEmail()) && utilisateur.getMdp().equals(utilisateur2.getMdp())) {
                for (Manager manager : this.daoManager.findAll()) {
                    if (manager.getUtiId().getId() == utilisateur2.getId()) {
                        connectedUtilisateur=manager;
                    }
                }
                
                for (Directeur directeur : this.daoDirecteur.findAll()) {
                    if (directeur.getUtiId().getId() == utilisateur2.getId()) {
                        connectedUtilisateur=directeur;
                    }
                }
            }
        }

        return connectedUtilisateur;
    }


    @PostMapping("/fonction")
    public String getFonction(@RequestBody Utilisateur utilisateur) {
        String fonction = "";
        List<Utilisateur> utilisateurs = this.daoUtilisateur.findAll();

        for (Utilisateur utilisateur2 : utilisateurs) {
            if (utilisateur.getEmail().equals(utilisateur2.getEmail()) && utilisateur.getMdp().equals(utilisateur2.getMdp())) {
                for (Manager manager : this.daoManager.findAll()) {
                    if (manager.getUtiId().getId() == utilisateur2.getId()) {
                        fonction="manager";
                    }
                }
                
                for (Directeur directeur : this.daoDirecteur.findAll()) {
                    if (directeur.getUtiId().getId() == utilisateur2.getId()) {
                        fonction="directeur";
                    }
                }
            }
        }

        return fonction;
    }
    
}
