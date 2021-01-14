package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.services.DatabaseInitService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//DatabaseInitController maakt de service DatabaseInitService aan
public class DatabaseInitController {
    @Autowired
    private DatabaseInitService databaseInitService;

    @GetMapping("/initdatabase")
    public String initDatabase() {
        //De methode createAll in DatabaseInitService wordt aangeroepen om alle entiteiten aan te maken.
        databaseInitService.createAll();
        return "Succes";
    }
}
