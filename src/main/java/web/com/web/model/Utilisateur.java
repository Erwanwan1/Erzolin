package web.com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Utilisateur")
@Data
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uti_id", nullable = false)
    private int id;

    @Column(name="uti_email", nullable = false)
    private String email;

    @Column(name="uti_mdp", nullable = false)
    private String mdp;
}
