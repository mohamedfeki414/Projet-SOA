package projet.plane;

import java.util.ArrayList;
import java.util.List;

public class BookPlaneBD {
	private static List<Plane> planes = new ArrayList<>();

    static {
        planes.add(new Plane("PL123", "Paris", "London", 800));
        planes.add(new Plane("PL127", "Paris", "Berlin", 930));
        planes.add(new Plane("PL129", "Rome", "Madrid", 1130));
    }

    public static List<Plane> getPlanes() {
        return planes;
    }

}
