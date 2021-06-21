package web.com.web.model;

import java.sql.Date;

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
@Table(name="Vente")
@Data
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vet_id", nullable = false)
    private int id;

    @Column(name="vet_numero")
    private String numero;

    @Column(name="vet_dateFactu")
    private Date dateFacturatiob;

    @ManyToOne()
    @JoinColumn(name="reg_id")
    private Region regId;

    @ManyToOne()
    @JoinColumn(name="ven_id")
    private Vendeur venId;
}
