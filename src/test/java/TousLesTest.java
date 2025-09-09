import java.time.LocalDate;

// Classe principale pour tester le système
public class TousLesTest {
    public static void main(String[] args) {
        // Tests
        testPointageRouge();
        testGetDaysRed();
        testCalculerSalairePrestataire();
    }

    public static void testPointageRouge() {
        System.out.println("=== Test pointageRouge ===");

        TravailleurSalarie travailleur = new TravailleurSalarie(1, "Dupont", "Jean",
                "jean.dupont@hei.fr", "0123456789", 3000.0);

        LocalDate date = LocalDate.of(2024, 3, 15);

        // Test 1: Pointage correct (total = 1)
        travailleur.ajouterPointage(new Mission(date, TypeTravail.ENSEIGNEMENT, 0.5,
                "Cours Java", "bleu"));
        travailleur.ajouterPointage(new Mission(date, TypeTravail.ADMINISTRATION, 0.3,
                "Réunion", "rouge"));
        travailleur.ajouterPointage(new Mission(date, TypeTravail.RD, 0.2,
                "Recherche", "vert"));

        System.out.println("Test 1 (total = 1): " + travailleur.pointageRouge(date)); // true

        // Test 2: Pointage incorrect (total != 1)
        LocalDate date2 = LocalDate.of(2024, 3, 16);
        travailleur.ajouterPointage(new Mission(date2, TypeTravail.ENSEIGNEMENT, 0.4,
                "Cours", "bleu"));

        System.out.println("Test 2 (total = 0.4): " + travailleur.pointageRouge(date2)); // false

        // Test 3: Exception pour quota invalide
        try {
            LocalDate date3 = LocalDate.of(2024, 3, 17);
            travailleur.ajouterPointage(new Mission(date3, TypeTravail.ENSEIGNEMENT, 1.5,
                    "Cours", "bleu"));
        } catch (IllegalArgumentException e) {
            System.out.println("Test 3 (quota > 1): Exception capturée - " + e.getMessage());
        }
    }

    public static void testGetDaysRed() {
        System.out.println("\n=== Test getDaysRed ===");

        TravailleurPrestataire prestataire = new TravailleurPrestataire(2, "Martin", "Sophie",
                "sophie.martin@hei.fr", "0987654321", 500.0);

        // Ajouter des missions sur plusieurs jours
        prestataire.ajouterPointage(new Mission(LocalDate.of(2024, 3, 1),
                TypeTravail.ENSEIGNEMENT, 1.0, "Cours", "bleu"));
        prestataire.ajouterPointage(new Mission(LocalDate.of(2024, 3, 2),
                TypeTravail.ADMINISTRATION, 1.0, "Admin", "rouge"));
        prestataire.ajouterPointage(new Mission(LocalDate.of(2024, 3, 3),
                TypeTravail.ABS_NON_PAYÉE, 1.0, "Absence", "gris"));
        prestataire.ajouterPointage(new Mission(LocalDate.of(2024, 3, 4),
                TypeTravail.RD, 1.0, "Recherche", "vert"));

        double jours = prestataire.getDaysRed(LocalDate.of(2024, 3, 1),
                LocalDate.of(2024, 3, 4));
        System.out.println("Jours prestés (hors absences): " + jours); // 3.0
    }

    public static void testCalculerSalairePrestataire() {
        System.out.println("\n=== Test calculerSalairePrestataire ===");

        TravailleurPrestataire prestataire = new TravailleurPrestataire(3, "Durand", "Pierre",
                "pierre.durand@hei.fr", "0156789234", 400.0);

        // Ajouter des missions
        prestataire.ajouterPointage(new Mission(LocalDate.of(2024, 3, 1),
                TypeTravail.ENSEIGNEMENT, 1.0, "Cours", "bleu"));
        prestataire.ajouterPointage(new Mission(LocalDate.of(2024, 3, 2),
                TypeTravail.COMMUNICATION, 1.0, "Présentation", "jaune"));
        prestataire.ajouterPointage(new Mission(LocalDate.of(2024, 3, 3),
                TypeTravail.ABS_PAYÉE, 1.0, "Congé", "gris"));

        // Ajouter une promotion
        prestataire.ajouterPromotion(new Promotion(LocalDate.of(2024, 2, 15), 450.0,
                "Augmentation de performance"));

        double salaire = prestataire.calculerSalaire(LocalDate.of(2024, 3, 1),
                LocalDate.of(2024, 3, 3));
        System.out.println("Salaire calculé: " + salaire + " euros"); // 2 jours * 450€ = 900€
    }
}
