package addressbookservice.dao;

import addressbookservice.model.PersonType;

import java.util.List;

public interface PersonTypeDAO
{
    void addPersonType(PersonType pt);
    List<PersonType> getAllPersonTypes();
    void updatePersonType(int personId, int oldTypeId, int newTypeId);
    void deletePersonType(int personId, int typeId);
}
