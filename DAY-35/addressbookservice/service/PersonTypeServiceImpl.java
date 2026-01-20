package addressbookservice.service;

import addressbookservice.dao.PersonTypeDAO;
import addressbookservice.model.PersonType;

import java.util.List;

public class PersonTypeServiceImpl implements PersonTypeService
{
    private final PersonTypeDAO dao;

    public PersonTypeServiceImpl(PersonTypeDAO dao) {
        this.dao = dao;
    }

    @Override
    public void assignType(PersonType pt) {
        dao.addPersonType(pt);
    }

    @Override
    public List<PersonType> viewMappings() {
        return dao.getAllPersonTypes();
    }

    @Override
    public void updateType(int personId, int oldTypeId, int newTypeId) {
        dao.updatePersonType(personId, oldTypeId, newTypeId);
    }

    @Override
    public void removeType(int personId, int typeId) {
        dao.deletePersonType(personId, typeId);
    }
}
