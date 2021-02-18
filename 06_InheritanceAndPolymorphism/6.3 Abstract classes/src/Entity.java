public class Entity extends Client {
    public Entity(double bankAccount) {
        super(bankAccount,0,1.0);
    }

    @Override
    public String toString() {
        return super.toString()
                + "Условия пополнения: комиссия  " + putCommission+ "%" + "\n"
                + "Условия снятия: комиссия  " + takeCommission + "%";

    }
}
