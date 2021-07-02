/*
 * The code is copyright ©2021
 */

package com.foo.eventsourcing.event

import com.fasterxml.jackson.databind.JsonNode

data class NotificationCreatedEvent(val id: String, val type: String, val payload: JsonNode)

