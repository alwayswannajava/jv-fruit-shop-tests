package core.basesyntax.service;

import core.basesyntax.domain.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}