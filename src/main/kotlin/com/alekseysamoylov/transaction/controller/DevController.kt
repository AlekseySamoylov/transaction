package com.alekseysamoylov.transaction.controller

import com.alekseysamoylov.transaction.service.TransactionTestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class DevController {
    @Autowired
    private lateinit var transactionTestService: TransactionTestService

    @RequestMapping("/product/{id}")
    fun getProduct(@PathVariable id: Int): String {
        return transactionTestService.getProductName(id)
    }

    @RequestMapping("/txr1")
    fun startTransactionRollback(): String {
        transactionTestService.transactionTestRollbackFirst()
        return "ok"
    }

    @RequestMapping("/txs1")
    fun startTransactionSuccess(): String {
        transactionTestService.transactionTestSuccessFirst()
        return "ok"
    }

    @RequestMapping("/txr2")
    fun startTransactionRollbackSecond(): String {
        transactionTestService.transactionTestRollbackSecond()
        return "ok"
    }

    @RequestMapping("/txrf2")
    fun startTransactionRollbackFailedSecond(): String {
        transactionTestService.transactionTestRollbackFailedSecond()
        return "ok"
    }

    @RequestMapping("/txs2")
    fun startTransactionSuccessSecond(): String {
        transactionTestService.transactionTestSuccessSecond()
        return "ok"
    }
}
