package core.basesyntax.service.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.db.Storage;
import core.basesyntax.domain.FruitTransaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BalanceOperationTest {

    @AfterEach
    void afterEach_setUp() {
        Storage.getFruitTransactions().clear();
    }

    @Test
    @DisplayName("Balance operation test")
    void calculateQuantityBalanceOperation_ok() {
        BalanceOperation balanceOperation = new BalanceOperation();
        balanceOperation.calculateQuantity(FruitTransaction.FruitName.BANANA, 10);
        int expectedStorageSizeAfterBalanceOperation = 1;
        int actualStorageSizeAfterBalanceOperation = Storage.getFruitTransactions().size();
        assertEquals(expectedStorageSizeAfterBalanceOperation,
                     actualStorageSizeAfterBalanceOperation);
    }

    @Test
    @DisplayName("Balance operation validate fruitName")
    void calculateQuantityFruitNameNull_notOk() {
        BalanceOperation balanceOperation = new BalanceOperation();
        assertThrows(RuntimeException.class, () -> balanceOperation.validateFruitName(null));
    }

    @Test
    @DisplayName("Balance operation validate fruitName")
    void calculateQuantityNegative_notOk() {
        BalanceOperation balanceOperation = new BalanceOperation();
        assertThrows(RuntimeException.class, () -> balanceOperation.validateQuantity(-10));
    }
}
