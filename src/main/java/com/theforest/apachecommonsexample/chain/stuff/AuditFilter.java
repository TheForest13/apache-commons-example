package com.theforest.apachecommonsexample.chain.stuff;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;

/**
 * Фильтр
 * Фильтр также команды , но с постобработки метод , который вызывается после выполнения цепочки.
 *
 * Наш Фильтр отправит уведомление клиенту и банку:
 */
public class AuditFilter implements Filter {

    @Override
    public boolean postprocess(Context context, Exception exception) {
        // send notification to bank and user
        return false;
    }

    @Override
    public boolean execute(Context context) throws Exception {
        return false;
    }
}
