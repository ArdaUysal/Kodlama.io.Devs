package Kodlama.io.Devs.dataAccess.concretes;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguagesRepository;
import Kodlama.io.Devs.entities.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguagesRepository implements ProgrammingLanguagesRepository{

    List<ProgrammingLanguage> programmingLanguages;

    public InMemoryProgrammingLanguagesRepository(){
        programmingLanguages = new ArrayList<ProgrammingLanguage>();
        programmingLanguages.add(new ProgrammingLanguage(1, "JAVA"));
        programmingLanguages.add(new ProgrammingLanguage(2, "PYTHON"));
        programmingLanguages.add(new ProgrammingLanguage(3, "C#"));
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        programmingLanguages.add(programmingLanguage);
        
    }

    @Override
    public void delete(ProgrammingLanguage programmingLanguage) {
        for (ProgrammingLanguage otherProgrammingLanguage : programmingLanguages) {
            if(otherProgrammingLanguage.getId() == programmingLanguage.getId()){
                programmingLanguages.remove(programmingLanguage);
            }
        }
    } 
        
    

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage currentProgrammingLanguage = getById(programmingLanguage.getId());
        if(currentProgrammingLanguage != null){
            currentProgrammingLanguage.setName(programmingLanguage.getName());
        }
        
    }


    @Override
    public List<ProgrammingLanguage> getAll() {
        
        return programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if(programmingLanguage.getId() == id){
                return programmingLanguage;
            }
        }
        return null;
    }

    
    
}
