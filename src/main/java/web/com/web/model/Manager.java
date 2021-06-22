package web.com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Manager")
@Data
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="man_id", nullable = false)
    private int id;

    @Column(name="man_nom")
    private String nom;

    @Column(name="man_prenom")
    private String prenom;

    @Column(name="man_matricule", nullable = false)
    private String matricule;

    @ManyToOne()
    @JoinColumn(name="dir_id")
    private Directeur dirId;

    @ManyToOne()
    @JoinColumn(name="reg_id")
    private Region regId;
    
    @OneToOne()
    @JoinColumn(name="uti_id")
    private Utilisateur utiReg;
}
