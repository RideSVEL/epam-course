package ua.nure.vasilchenko.practice7.util;

import ua.nure.vasilchenko.practice7.entity.Gun;
import ua.nure.vasilchenko.practice7.entity.Guns;

import java.util.Comparator;

public final class Sorts {

    // //////////////////////////////////////////////////////////
    // these are comparators
    // //////////////////////////////////////////////////////////

    /**
     * Sorts questions by question model
     */

    private Sorts() {
        throw new IllegalStateException("Utility class");
    }


    public static final Comparator<Gun> SORT_GUNS_BY_MODEL = Comparator.comparing(Gun::getModel);

    public static final Comparator<Gun> SORT_GUNS_BY_ORIGIN =
            Comparator.comparing(Gun::getOrigin);

    public static final Comparator<Gun> SORT_GUNS_BY_SIGHTING_RANGE =
            Comparator.comparingInt(o -> o.getTTC().getDistance().getRange());

    public static void sortGunsByModel(Guns guns) {
        guns.getGun().sort(SORT_GUNS_BY_MODEL);
    }

    public static void sortGunsByOrigin(Guns guns) {
        guns.getGun().sort(SORT_GUNS_BY_ORIGIN);
    }

    public static void sortGunsBySightingRange(Guns guns) {
        guns.getGun().sort(SORT_GUNS_BY_SIGHTING_RANGE);
    }

}
