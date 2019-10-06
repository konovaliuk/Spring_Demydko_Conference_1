package one.persistence.data.impl;

import one.persistence.data.ILanguage;
import one.persistence.entity.Language;
import one.persistence.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LanguageImpl implements ILanguage {
    @Autowired
   private LanguageRepository languageRepo;

    @Override
    public Language getLanguage(String language) {
        return languageRepo.findByLanguage(language);
    }
}
