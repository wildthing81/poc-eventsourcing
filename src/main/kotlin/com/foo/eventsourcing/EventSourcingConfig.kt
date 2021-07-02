/*
 * The code is copyright ©2021
 */
package com.foo.eventsourcing

import com.foo.eventsourcing.aggregate.Notification
import org.axonframework.axonserver.connector.AxonServerConfiguration
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.config.DefaultConfigurer
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.spring.config.AxonConfiguration
import org.springframework.context.annotation.Bean

//@Configuration
//@ComponentScan("com.anzi.credible.eventsourcing.data")
//@Import(SpringAxonAutoConfigurer.ImportSelector::class)
//@EnableJpaRepositories(
//    basePackages = ["com.anzi.credible"],
//    entityManagerFactoryRef = "entityManagerFactory"
//)
open class EventSourcingConfig {

    //@Bean
    open fun axonConfiguration(): AxonConfiguration {
        //AxonServer event store for future
        return AxonConfiguration(
            DefaultConfigurer.defaultConfiguration()
                .registerComponent(AxonServerConfiguration::class.java) {
                    axonServerConfiguration()
                }.configureAggregate(Notification::class.java)
        )
    }

    @Bean
    open fun eventStore(): EventStore = axonConfiguration().eventStore()

    @Bean
    open fun commandGateway(): CommandGateway = axonConfiguration().commandGateway()

    @Bean
    open fun queryGateway(): QueryGateway = axonConfiguration().queryGateway()

    @Bean
    open fun axonServerConfiguration(): AxonServerConfiguration {
        return AxonServerConfiguration.builder()
            .componentName("credible")
            .servers("eventstore")
            .build()
    }
}
