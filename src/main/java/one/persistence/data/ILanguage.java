package one.persistence.data;

import one.persistence.entity.Language;

/**
 * Used for access to data base
 */
public interface ILanguage {
     Language getLanguage(String language);
}
