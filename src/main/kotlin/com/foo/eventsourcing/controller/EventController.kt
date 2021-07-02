/*
 * The code is copyright ©2021
 */

package com.foo.eventsourcing.controller

import com.foo.eventsourcing.dto.NotificationDto
import com.foo.eventsourcing.service.NotificationServiceBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController {

    @Autowired
    private lateinit var notificationService: NotificationServiceBean

    @PostMapping("/publish")
    fun createEvent(@RequestBody notificationDto: NotificationDto):ResponseEntity<NotificationDto> {
        notificationService.sendNotification(notificationDto)
        return ResponseEntity(notificationDto, HttpStatus.OK)
    }
}
