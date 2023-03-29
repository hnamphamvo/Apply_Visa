package enums;

public enum ApplicationType {
    FIRST_WORK("First Work and Holiday visa (subclass 462)"), SECOND_WORK("Second Work and Holiday visa (subclass 462)"),
    THIRD_WORK("Third Work and Holiday visa (subclass 462)");

    private final String applicationType;

    ApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getTypeName() {
        return applicationType;
    }
}

