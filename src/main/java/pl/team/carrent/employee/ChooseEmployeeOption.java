package pl.team.carrent.employee;

public enum ChooseEmployeeOption {

    ALL("wszyscy"),
    ACTIVE("zatrudnieni"),
    RELEASED("zwolnieni");

    private String description;

    ChooseEmployeeOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}