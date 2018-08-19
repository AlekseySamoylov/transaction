package com.alekseysamoylov.transaction.service

import com.alekseysamoylov.db.transaction.tables.Product.PRODUCT
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


@Service
class TransactionTestService {

    @Autowired
    @Qualifier("jooqFirst")
    private lateinit var dslContext: DSLContext

    fun getProductName(productId: Int): String {
        return dslContext.select(PRODUCT.NAME)
                .from(PRODUCT)
                .where(PRODUCT.ID.eq(1))
                .limit(1)
                .fetchOptionalInto(String::class.java).get()
    }
}
