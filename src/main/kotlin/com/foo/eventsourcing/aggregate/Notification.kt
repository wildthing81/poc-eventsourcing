/*
 * The code is copyright ©2021
 */

package com.foo.eventsourcing.aggregate

import com.foo.eventsourcing.command.CreateNotificationCommand
import com.foo.eventsourcing.event.NotificationCreatedEvent
import com.fasterxml.jackson.databind.JsonNode
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.spring.stereotype.Aggregate
import org.axonframework.modelling.command.AggregateLifecycle.apply


@Aggregate
class Notification()  {

    @AggregateIdentifier
    private var id:String? = null
    private var type: String? = null
    private var payload: JsonNode? = null

    //constructor()

    @CommandHandler
    constructor(cmd: CreateNotificationCommand):this() {
        apply(NotificationCreatedEvent(cmd.id, cmd.type,cmd.payload))
    }

    @EventSourcingHandler
    fun on(event: NotificationCreatedEvent) {
        this.id = event.id
        this.type = event.type
        this.payload = event.payload
    }
}
