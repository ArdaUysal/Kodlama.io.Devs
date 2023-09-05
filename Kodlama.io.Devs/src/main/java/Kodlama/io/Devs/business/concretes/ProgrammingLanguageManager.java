package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguagesRepository;
import Kodlama.io.Devs.entities.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    ProgrammingLanguagesRepository programmingLanguagesRepository;

    public ProgrammingLanguageManager(ProgrammingLanguagesRepository programmingLanguagesRepository){
        this.programmingLanguagesRepository = programmingLanguagesRepository;
    }



    @Override
    public void add(ProgrammingLanguage programmingLanguage) throws Exception {
        if(programmingLanguage.getName() == null ){
            throw new Exception("Programlama dili ismi boş olamaz.");
        }
        for (ProgrammingLanguage otherProgrammingLanguage : programmingLanguagesRepository.getAll()) {
            if(otherProgrammingLanguage.getName().equalsIgnoreCase(programmingLanguage.getName())){
                throw new Exception("Programlama dili ismi tekrar edemez.");
            }
        }
        programmingLanguagesRepository.add(programmingLanguage);
        
    }

    @Override
    public void delete(ProgrammingLanguage programmingLanguage) {
        programmingLanguagesRepository.delete(programmingLanguage);
        
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        
        return programmingLanguagesRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        
        return programmingLanguagesRepository.getById(id);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        programmingLanguagesRepository.update(programmingLanguage);
        
    }
    
}
