package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class EqualsViolationExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(EqualsViolationExample.class);

    public static void main(String[] args) {
        new EqualsViolationExample().action();
    }

    private void action() {
        Money income = new Money(55, "USD");
        Money expenses = new Money(55, "USD");
        LOGGER.info("imcome equals expenses: {}", income.equals(expenses));

        Money cash = new Money(42, "USD");
        WrongVoucher voucher = new WrongVoucher(42, "USD", "Amazon");

        LOGGER.info("voucher equals cash: {}", voucher.equals(cash));
        LOGGER.info("cash equals voucher: {}", cash.equals(voucher));
    }
}

class Money {
    private int amount;
    private String currencyCode;

    public Money(int amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;

        return amount == money.amount &&
                Objects.equals(currencyCode, money.currencyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currencyCode);
    }
}

class WrongVoucher extends Money {

    private String store;

    public WrongVoucher(int amount, String currencyCode, String store) {
        super(amount, currencyCode);
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WrongVoucher)) return false;
        if (!super.equals(o)) return false;
        WrongVoucher that = (WrongVoucher) o;
        return Objects.equals(store, that.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), store);
    }
}

