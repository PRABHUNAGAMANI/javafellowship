package addressbookservice.service;

import addressbookservice.model.PersonType;
import java.util.List;

public interface PersonTypeService
{
    void assignType(PersonType pt);
    List<PersonType> viewMappings();
    void updateType(int personId, int oldTypeId, int newTypeId);
    void removeType(int personId, int typeId);
}
