package pl.team.carrent.car;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 09.11.2019 12:05
 * *
 * @className: SearchCarOption
 * *
 * *
 ******************************************************/
public enum SearchCarOption {
    BY_CAR_MODEL("po modelu"),BY_PLATE_NR("po nr rej."), BY_VIN("po nr VIN"), BY_COLOR("po kolorze"), BY_TYPE("po type"), BY_SEGMENT("po segmencie");

    private String description;

    SearchCarOption(String description){
        this.description=description;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getDescription() {
        return description;
    }
}
