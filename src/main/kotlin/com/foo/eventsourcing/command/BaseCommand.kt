/*
 * The code is copyright ©2021
 */

package com.foo.eventsourcing.command

import org.axonframework.modelling.command.TargetAggregateIdentifier

open class BaseCommand(
    @TargetAggregateIdentifier
    var id: String
) {

}
