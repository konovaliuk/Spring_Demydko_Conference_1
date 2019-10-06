package one.persistence.data;

import one.persistence.entity.Position;

/**
 * Used for access to data base
 */
public interface IPosition {
    Position getPosition(String position);
}
