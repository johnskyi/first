import java.time.LocalDate;

public class Individual extends Client{
    public Individual(double bankAccount) {
        super(bankAccount , 0,0);
    }

    @Override
    public String toString() {
        return super.toString() + "Условия пополнения: комиссия  " + putCommission + "%" + "\n"
                + "Условия снятия: комиссия  " + takeCommission + "%";
    }
}
