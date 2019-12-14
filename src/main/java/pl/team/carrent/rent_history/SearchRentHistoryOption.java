package pl.team.carrent.rent_history;

public enum SearchRentHistoryOption {
    BY_CAR_PLATE_NR("po nr rej."),
    BY_CLIENT_EMAIL("po mailu klienta"),
    BY_INVOICE_NUMBER("po numerze faktury"),
    BY_EMPLOYEESTART_USERNAME("kto wydawał"),
    BY_EMPLOYEEEND_USERNAME("kto odbierał"),
    BY_RENTPOINTSTART_NAME("skad wypożyczał"),
    BY_RENTPOINTEND_NAME("gdzie oddawał");

    private String description;

    SearchRentHistoryOption(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
