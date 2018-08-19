package com.alekseysamoylov.transaction

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import javax.sql.DataSource

@SpringBootApplication
class TransactionApplication

@Autowired
private lateinit var dataSource: DataSource

fun main(args: Array<String>) {
    SpringApplication.run(TransactionApplication::class.java, *args)
}
