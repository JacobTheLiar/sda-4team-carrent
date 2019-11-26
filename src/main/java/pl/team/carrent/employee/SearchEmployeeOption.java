package pl.team.carrent.employee;

public enum SearchEmployeeOption {

    BY_FIRSTNAME("po imieniu"),
    BY_SURNAME("po nazwisku"),
    BY_ROLE("po funkcji"),
    BY_RENTPOINTNAME("po nazwie wypożyczalni"),
    BY_EMPLOYMENTDATE("po dacie zatrudnienia"),
    BY_RELEASEDATE("po dacie odejścia");

    private String description;

    SearchEmployeeOption(String description) {
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