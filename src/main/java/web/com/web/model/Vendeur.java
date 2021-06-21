package web.com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Vendeur")
@Data
public class Vendeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ven_id", nullable = false)
    private int id;

    @Column(name="ven_nom")
    private String nom;

    @Column(name="ven_prenom")
    private String prenom;

    @Column(name="ven_matricule", nullable = false)
    private String matricule;
    
    @ManyToOne()
    @JoinColumn(name="man_id")
    private Manager manId;
    
    @ManyToOne()
    @JoinColumn(name="reg_id")
    private Region regId;
}
