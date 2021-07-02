/*
 * The code is copyright ©2021
 */

package com.foo.eventsourcing.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_NULL)
data class NotificationDto(
    @JsonProperty var type: String? = null,
    @JsonProperty var payload: JsonNode? = null,
): Serializable
