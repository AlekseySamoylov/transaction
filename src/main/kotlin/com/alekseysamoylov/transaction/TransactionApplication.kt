package com.alekseysamoylov.transaction

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class TransactionApplication

fun main(args: Array<String>) {
    SpringApplication.run(TransactionApplication::class.java, *args)
}
