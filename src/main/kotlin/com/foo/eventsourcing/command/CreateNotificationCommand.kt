/*
 * The code is copyright ©2021
 */

package com.foo.eventsourcing.command

import com.fasterxml.jackson.databind.JsonNode

class CreateNotificationCommand(
    id: String,
    val type: String,
    val payload: JsonNode
): BaseCommand(id){

}
