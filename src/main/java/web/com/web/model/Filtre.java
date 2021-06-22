package web.com.web.model;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class Filtre {
    List<Integer> regions;
    List<Integer> vendeurs;
    Date dateDebut;
    Date dateFin;
}
