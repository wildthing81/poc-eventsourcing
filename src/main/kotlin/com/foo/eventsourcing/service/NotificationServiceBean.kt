/*
 * The code is copyright ©2021
 */

package com.foo.eventsourcing.service

import com.foo.eventsourcing.command.CreateNotificationCommand
import com.foo.eventsourcing.dto.NotificationDto
import com.fasterxml.jackson.databind.ObjectMapper
import mu.KotlinLogging
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.queryhandling.QueryGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.concurrent.TimeUnit


@Service("notificationService")
open class NotificationServiceBean {
    private val log = KotlinLogging.logger { }

    @Autowired
    private lateinit var commandGateway: CommandGateway

    @Autowired
    private lateinit var queryGateway: QueryGateway


    fun sendNotification(notificationDto: NotificationDto) {
        log.info { "Sending command to create notification on CommandBus" }
        commandGateway.sendAndWait<CreateNotificationCommand>(
            CreateNotificationCommand(
                UUID.randomUUID().toString(),
                notificationDto.type!!,
                ObjectMapper().createObjectNode()
            ), 10000, TimeUnit.MILLISECONDS
        )
        log.info { "Command sent" }
    }

//    fun queryNotification(notificationId: String): Notification {
//        log.info { "Querying notification aggregate on QueryBus" }
//        return queryGateway.query(
//            FetchNotificationByIdQuery(notificationId),
//            ResponseTypes.instanceOf(Notification::class.java)
//        ).get()
//    }
}
