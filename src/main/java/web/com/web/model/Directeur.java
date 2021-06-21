package web.com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Directeur")
@Data
public class Directeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dir_id", nullable = false)
    private int id;

    @Column(name="dir_nom")
    private String nom;

    @Column(name="vdir_prenom")
    private String prenom;

    @Column(name="dir_email")
    private String email;

    @Column(name="dir_mdp", nullable = false)
    private String mdp;

}
