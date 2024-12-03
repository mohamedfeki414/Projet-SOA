package projet.plane;

import java.util.List;

public class TestBookPlaneSimple {
	public static void main(String[] args) {
        // a)
        List<Plane> planes = BookPlaneBD.getPlanes();
        System.out.println("Liste des avions:");
        for (Plane plane : planes) {
            System.out.println(plane);
        }

        // b)
        Plane newPlane = new Plane("PL130", "London", "Paris", 1430);
        BookPlaneBD.getPlanes().add(newPlane);
        System.out.println("\nNouvel avion ajouté: " + newPlane);

        // c)
        Plane planePL127 = planes.stream().filter(p -> "PL127".equals(p.getNumPlane())).findFirst().orElse(null);
        if (planePL127 != null) {
            System.out.println("\nAvion avec identifiant PL127: " + planePL127);
        } else {
            System.out.println("\nAvion avec identifiant PL127 non trouvé.");
        }

        // d)
        System.out.println("\nAvions partant de Paris vers Berlin:");
        for (Plane plane : planes) {
            if ("Paris".equals(plane.getVilleDepart()) && "Berlin".equals(plane.getVilleArrivee())) {
                System.out.println(plane);
            }
        }

        // e)
        if (planePL127 != null) {
            planePL127.setHeureDepart(900);
            System.out.println("\nHeure de départ de l'avion PL127 modifiée: " + planePL127);
        }

        // f)
        Plane planePL129 = planes.stream().filter(p -> "PL129".equals(p.getNumPlane())).findFirst().orElse(null);
        if (planePL129 != null) {
            planes.remove(planePL129);
            System.out.println("\nAvion PL129 supprimé.");
        }

        System.out.println("\nListe finale des avions:");
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }

}
