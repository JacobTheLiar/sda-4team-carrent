package pl.team.carrent.rent;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 10.11.2019 11:56
 * *
 * @className: SearchRentOption
 * *
 * *
 ******************************************************/
public enum  SearchRentOption {
    BY_CAR_PLATE_NR("po nr rej."), BY_CAR_VIN("po VIN"), BY_CLIENT_NAME("po nazwie klienta"),
    BY_CLIENT_ID("po id klienta"), BY_CLIENT_EMAIL("po mailu klienta"), BY_CLIENT_PHONE("po telefonie klienta"),
    BY_CLIENT_TAX_NUMBER("po NIPie klienta"), BY_PROMOTION_ID("po id promocji"), BY_PROMOTION_NAME("po nazwie promocji"),
    BY_RENT_POINT_START_ID("po id punktu wypożyczenia"), BY_RENT_POINT_START_NAME("po nazwie punktu wypożyczenia"),
    BY_RENT_NUMBER_OF_WEEKS("po długości wypożyczenia w il.tygodni"), BY_EMPLOYEE_USERNAME_START("po username pracownika"),
    BY_NOTES_START("po polu uwagi");

    private String description;

    SearchRentOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
