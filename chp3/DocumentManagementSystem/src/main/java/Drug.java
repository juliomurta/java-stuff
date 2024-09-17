public class Drug {
    final private String name;
    final private String quantity;
    final private String dosage;

    Drug(final String name, final String quantity, final String dosage) {
        this.name = name;
        this.quantity = quantity;
        this.dosage = dosage;
    }

    public String getName() {
        return this.name;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public String getDosage() {
        return this.dosage;
    }
}