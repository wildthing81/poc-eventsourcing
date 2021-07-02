/*
 * The code is copyright ©2021
 */

package com.foo.eventsourcing.data

import com.foo.eventsourcing.event.NotificationCreatedEvent
import com.foo.eventsourcing.query.FetchNotificationByIdQuery
import mu.KotlinLogging
import org.axonframework.eventhandling.EventHandler
import org.axonframework.queryhandling.QueryHandler
import org.springframework.stereotype.Component

@Component
class NotificationProjector {

    private val log = KotlinLogging.logger { }

    //@Autowired
    //private lateinit var notificationRepository: NotificationRepository


    @QueryHandler
    fun handle(query: FetchNotificationByIdQuery): String{
        log.info("Get notification by id query: {}", query)
       // return notificationRepository.fetchNotificationById(query.id)
        return "Query/Materialized View to create time-based projection of aggregate"
    }

    @EventHandler
    fun on(event: NotificationCreatedEvent): String{
        log.info("Action on event: ${event.id}")
        return "Perform some action on event generation"
    }

}
