package banq.bmi.services;

import banq.bmi.Repository.DossierRepository;
import banq.bmi.entities.Dossier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DossierServiceImp implements DossierService {


    @Autowired
    private DossierRepository dossierRepository;

    @Override
    public Dossier saveDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    @Override
    public Dossier updateDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    @Override
    public List<Dossier> getAlDossierr() {
        return dossierRepository.findAll();
    }

    @Override
    public Dossier findUserByUsername(String Username) {
        return dossierRepository.findAllByNom(Username);
    }

    @Override
    public void deleteDossier(Long DossierId) {
        dossierRepository.deleteById(DossierId);
    }
}
