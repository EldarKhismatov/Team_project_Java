package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test // Пополнение баланса на сумму меньше максимальной допустимой
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test  // Пополнение баланса на сумму больше максимальной допустимой
    public void shouldAddAboveThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(11_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test  // Пополнение баланса до максимально допустимой суммы
    public void shouldAddUpToTheMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(10_000, account.getBalance());
    }

    @Test  // Оплата в диапазоне между минимальной и максимальной допустимой суммой
    public void shouldPayBetweenMaxAndMin() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertTrue(account.pay(500));
    }

    @Test  // Остаток после оплаты меньше минимально допустимой суммы
    public void shouldBalanceBelowTheMin() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertFalse(account.pay(5_000));
    }

    @Test // Остаток после оплаты равен минимально допустимой сумме
    public void shouldBalanceAboveTheMin() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertTrue(account.pay(2_000));
    }

    @Test  // Расчет процентной ставки при положительном балансе
    public void shouldCalculateRatePositiveBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(100, account.yearChange());
    }

    @Test  // Расчет процентной ставки при отрицательном балансе
    public void shouldCalculateRateNegativeBalance() {
        SavingAccount account = new SavingAccount(
                -2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test  // Положительная процентная ставка
    public void changeCalculatePositiveRate() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                25
        );

        Assertions.assertEquals(25, account.getRate());
    }

    @Test  // Отрицательная процентная ставка
    public void changeCalculateNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -25
            );
        });
    }
    }
