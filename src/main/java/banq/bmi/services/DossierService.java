package banq.bmi.services;

import banq.bmi.entities.Dossier;

import java.util.List;

public interface DossierService {


    public Dossier saveDossier(Dossier dossier);

    public Dossier updateDossier(Dossier dossier);

    public List<Dossier> getAlDossierr();

    public Dossier findUserByUsername(String Username);
    void deleteDossier(Long DossierId);
}
