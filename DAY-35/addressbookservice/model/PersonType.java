package addressbookservice.model;

public class PersonType
{
    private int personId;
    private int typeId;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "PersonType{" +
                "personId=" + personId +
                ", typeId=" + typeId +
                '}';
    }
}
