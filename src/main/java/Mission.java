import java.time.LocalDate;
class Mission {
    private LocalDate date;
    private TypeTravail typeTravail;
    private double quotaTemps;
    private String description;
    private String couleur;

    public Mission(LocalDate date, TypeTravail typeTravail, double quotaTemps,
                   String description, String couleur) {
        if (quotaTemps <= 0 || quotaTemps > 1) {
            throw new IllegalArgumentException("Le quota de temps doit être entre 0 et 1");
        }
        this.date = date;
        this.typeTravail = typeTravail;
        this.quotaTemps = quotaTemps;
        this.description = description;
        this.couleur = couleur;
    }

    // Getters
    public LocalDate getDate() { return date; }
    public TypeTravail getTypeTravail() { return typeTravail; }
    public double getQuotaTemps() { return quotaTemps; }
    public String getDescription() { return description; }
    public String getCouleur() { return couleur; }

    public boolean estAbsence() {
        return typeTravail == TypeTravail.ABS_PAYÉE || typeTravail == TypeTravail.ABS_NON_PAYÉE;
    }
}