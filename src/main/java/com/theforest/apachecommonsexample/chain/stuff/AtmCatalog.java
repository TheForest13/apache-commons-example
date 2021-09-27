package com.theforest.apachecommonsexample.chain.stuff;

import org.apache.commons.chain.impl.CatalogBase;

/**
 *  Каталог цепей
 * Это набор цепочек и команд с их логическими именами.
 *
 * В нашем случае наш Каталог будет содержать AtmWithdrawalChain.
 */
public class AtmCatalog extends CatalogBase {

    public AtmCatalog() {
        super();
        addCommand("atmWithdrawalChain", new AtmWithdrawalChain());
    }
}
