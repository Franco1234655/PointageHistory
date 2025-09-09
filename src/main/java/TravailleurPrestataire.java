import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class TravailleurPrestataire extends Travailleur {
    private double tjmInitial;
    private List<Promotion> promotions;

    public TravailleurPrestataire(int id, String nom, String prenom, String email,
                                  String numeroTelephone, double tjmInitial) {
        super();
        this.tjmInitial = tjmInitial;
        this.promotions = new ArrayList<>();
    }

    public void ajouterPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public double getTjmActuel(LocalDate date) {
        double tjm = tjmInitial;

        for (Promotion promotion : promotions) {
            if (!promotion.getDate().isAfter(date)) {
                tjm = promotion.getNouveauMontant();
            }
        }

        return tjm;
    }

    @Override
    public double calculerSalaire(LocalDate dateDebut, LocalDate dateFin) {
        double joursPreste = getDaysRed(dateDebut, dateFin);
                double tjm = getTjmActuel(dateFin);
                return joursPreste * tjm;
            }
        
            private double getDaysRed(LocalDate dateDebut, LocalDate dateFin) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getDaysRed'");
            }
}


