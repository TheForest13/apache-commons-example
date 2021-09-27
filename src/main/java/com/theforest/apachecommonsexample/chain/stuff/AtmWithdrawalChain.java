package com.theforest.apachecommonsexample.chain.stuff;

import org.apache.commons.chain.impl.ChainBase;

/**
 * Цепь
 * Цепь представляет собой набор команд , которые должны выполняться в указанном порядке.
 * Наша цепочка будет состоять из вышеуказанных команд, а также из AuditFilter в конце:
 * Когда любая команда в цепочке возвращает истину, это приводит к завершению цепочки.
 */
public class AtmWithdrawalChain extends ChainBase {

    public AtmWithdrawalChain() {
        super();
        addCommand(new HundredDenominationDispenser());
        addCommand(new FiftyDenominationDispenser());
        addCommand(new TenDenominationDispenser());
        addCommand(new AuditFilter());
    }
}