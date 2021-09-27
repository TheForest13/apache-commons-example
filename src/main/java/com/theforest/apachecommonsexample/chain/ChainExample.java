package com.theforest.apachecommonsexample.chain;

import com.theforest.apachecommonsexample.beanutils.BeanUtilsExample;
import com.theforest.apachecommonsexample.chain.stuff.AtmCatalog;
import com.theforest.apachecommonsexample.chain.stuff.AtmRequestContext;
import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Apache Commons Chain - это библиотека, которая использует шаблон цепочки ответственности,
 * обычно используемый для организации сложных потоков обработки,
 * в которых несколько получателей могут обрабатывать запрос
 */
public class ChainExample {

    private final static Logger log = LoggerFactory.getLogger(ChainExample.class);


    public static void main(String[] args) throws Exception {
        Context context = new AtmRequestContext();
        context.put("totalAmountToBeWithdrawn", 460);
        context.put("amountLeftToBeWithdrawn", 460);

        Catalog catalog = new AtmCatalog();
        Command atmWithdrawalChain = catalog.getCommand("atmWithdrawalChain");

        atmWithdrawalChain.execute(context);

        log.debug("totalAmountToBeWithdrawn = {}", context.get("totalAmountToBeWithdrawn"));
        log.debug("amountLeftToBeWithdrawn = {}", (int) context.get("amountLeftToBeWithdrawn"));
        log.debug("noOfHundredsDispensed = {}", (int) context.get("noOfHundredsDispensed"));
        log.debug("noOfFiftiesDispensed = {}", (int) context.get("noOfFiftiesDispensed"));
        log.debug("noOfTensDispensed = {}", (int) context.get("noOfTensDispensed"));
    }
}
