package one.persistence.repositories;

import one.persistence.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    Language findByLanguage(String language);
}
