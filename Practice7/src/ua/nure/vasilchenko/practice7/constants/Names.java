package ua.nure.vasilchenko.practice7.constants;

public enum Names {
    GUNS("Guns"), GUN("Gun"), MODEL("Model"), HANDY("Handy"), ORIGIN("Origin"),
    TTC("TTC"), DISTANCE("Distance"), SHORT("short"), MIDDLE("middle"), LONG("long"),
    SIGHTING_RANGE("SightingRange"), CLIP("Clip"), OPTICS("Optics"), MATERIAL("Material");

    private String value;

    Names(String value) {
        this.value = value;
    }

    public boolean equalsTo(String name) {
        return value.equals(name);
    }

    public String value() {
        return value;
    }
}
