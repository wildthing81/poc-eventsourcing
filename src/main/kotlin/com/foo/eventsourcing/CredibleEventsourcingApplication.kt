/*
 * The code is copyright ©2021
 */

package com.foo.eventsourcing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CredibleEventsourcingApplication

fun main(args: Array<String>) {
	runApplication<CredibleEventsourcingApplication>(*args)
}

