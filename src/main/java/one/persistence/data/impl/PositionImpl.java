package one.persistence.data.impl;

import one.persistence.data.IPosition;
import one.persistence.entity.Position;
import one.persistence.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PositionImpl implements IPosition {
    @Autowired
   private PositionRepository positionRepo;

    @Override
    public Position getPosition(String position) {
        return positionRepo.findPositionByPosition(position);
    }
}
