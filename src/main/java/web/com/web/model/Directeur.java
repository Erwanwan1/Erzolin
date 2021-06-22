package web.com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

    @Column(name="dir_prenom")
    private String prenom;

    @Column(name="dir_mdp", nullable = false)
    private String mdp;

    @OneToOne()
    @JoinColumn(name="uti_id")
    private Utilisateur utiReg;
}
