package pl.team.carrent.car_model;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 10.11.2019 10:04
 * *
 * @className: SearchCarModelOption
 * *
 * *
 ******************************************************/
public enum SearchCarModelOption {

    BY_MARK("po marce"), BY_MODEL("po modelu"), BY_PRODUCTION_YEAR("po roku produkcji"),
    BY_SEGMENT("po segmencie"), BY_TYPE("po typie"), BY_AGE("po wieku");

    private String description;

    SearchCarModelOption(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getDescription() {
        return description;
    }
}
