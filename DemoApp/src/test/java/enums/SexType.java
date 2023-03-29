package enums;

public enum SexType {
    FEMALE("Female"), MALE("Male"), OTHER("Other");
    private final String sexType;
    SexType(String sexType) {
        this.sexType = sexType;
    }

    public String getSexType() {
        return sexType;
    }
}
