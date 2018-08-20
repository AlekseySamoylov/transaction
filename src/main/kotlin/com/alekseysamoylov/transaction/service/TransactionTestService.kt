package com.alekseysamoylov.transaction.service

import com.alekseysamoylov.db.transaction.tables.Product.PRODUCT
import com.alekseysamoylov.db.transaction.tables.pojos.Product;
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional


@Service
class TransactionTestService {

    @Autowired
    @Qualifier("jooqFirst")
    private lateinit var dslContextFirst: DSLContext

    @Autowired
    @Qualifier("jooqSecond")
    private lateinit var dslContextSecond: DSLContext

    fun getProductName(productId: Int): String {
        return dslContextFirst.select(PRODUCT.NAME)
                .from(PRODUCT)
                .where(PRODUCT.ID.eq(1))
                .limit(1)
                .fetchOptionalInto(String::class.java).get()
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "txManagerFirst")
    fun transactionTestRollbackFirst() {
        for (i in 1..100) {
            val product = Product()
            product.name = "Product Rollback # $i"
            dslContextFirst.newRecord(PRODUCT, product).store()
            if (i == 50) {
                throw NullPointerException("Rollback Transaction")
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "txManagerSecond")
    fun transactionTestRollbackSecond() {
        for (i in 1..100) {
            val product = Product()
            product.name = "Product Second Rollback # $i"
            dslContextSecond.newRecord(PRODUCT, product).store()
            if (i == 50) {
                throw NullPointerException("Rollback Transaction")
            }
        }
    }

    fun transactionTestRollbackFailedSecond() {
        for (i in 1..100) {
            val product = Product()
            product.name = "Product Second Rollback Failed # $i"
            dslContextSecond.newRecord(PRODUCT, product).store()
            if (i == 50) {
                throw NullPointerException("Rollback Transaction")
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "txManagerFirst")
    fun transactionTestSuccessFirst() {
        for (i in 1..100) {
            val product = Product()
            product.name = "Product Success # $i"
            dslContextFirst.newRecord(PRODUCT, product).store()
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "txManagerSecond")
    fun transactionTestSuccessSecond() {
        for (i in 1..100) {
            val product = Product()
            product.name = "Product Success # $i"
            dslContextSecond.newRecord(PRODUCT, product).store()
        }
    }
}
