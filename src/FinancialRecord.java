public class FinancialRecord {
    private int incomes, outcomes;

    //конструктор
    public FinancialRecord(int incomes, int outcomes) {
        this.incomes = incomes;
        this.outcomes = outcomes;
    }

    //геттеры
    public int getIncomes() {
        return incomes;
    }

    public int getOutcomes() {
        return outcomes;
    }

    //сеттеры
    public void setIncomes(int incomes) {
        this.incomes = incomes;
    }

    public void setOutcomes(int outcomes) {
        this.outcomes = outcomes;
    }

    @Override
    public String toString() {
        return this.incomes + ":" + this.outcomes;
    }
}
