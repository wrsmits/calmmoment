package wesley.calmmoment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wesley.calmmoment.model.Tip;
import wesley.calmmoment.repositories.TipRepository;

import java.util.List;

@Service
public class TipService {
    @Autowired
    private TipRepository tipRepository;

    public List<Tip> getTips() {
        return tipRepository.findAll();
    }
}
