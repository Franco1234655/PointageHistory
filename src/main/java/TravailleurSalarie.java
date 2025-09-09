import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class TravailleurSalarie extends Travailleur {
    private double salaireInitial;
    private List<Promotion> promotions;

    public TravailleurSalarie(int id, String nom, String prenom, String email,
                              String numeroTelephone, double salaireInitial) {
        super();
        this.salaireInitial = salaireInitial;
        this.promotions = new ArrayList<>();
    }

    public void ajouterPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public double getSalaireActuel(LocalDate date) {
        double salaire = salaireInitial;

        for (Promotion promotion : promotions) {
            if (!promotion.getDate().isAfter(date)) {
                salaire = promotion.getNouveauMontant();
            }
        }

        return salaire;
    }

    @Override
    public double calculerSalaire(LocalDate dateDebut, LocalDate dateFin) {
        // le salaire mensuel reste le même pour un salarié
        return getSalaireActuel(dateFin);
    }
}
