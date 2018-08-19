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
    fun startTransaction(@PathVariable id: Int): String {
        return transactionTestService.getProductName(id)
    }
}
