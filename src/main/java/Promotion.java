import java.time.LocalDate;

class Promotion {
    private LocalDate date;
    private double nouveauMontant;
    private String raison;

    public Promotion(LocalDate date, double nouveauMontant, String raison) {
        this.date = date;
        this.nouveauMontant = nouveauMontant;
        this.raison = raison;
    }

    // Getters
    public LocalDate getDate() { return date; }
    public double getNouveauMontant() { return nouveauMontant; }
    public String getRaison() { return raison; }
}