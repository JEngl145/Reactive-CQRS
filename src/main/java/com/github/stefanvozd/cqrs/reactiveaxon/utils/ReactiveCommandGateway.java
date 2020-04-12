package com.github.stefanvozd.cqrs.reactiveaxon.utils;

import com.github.stefanvozd.cqrs.reactiveaxon.api.BankAccountCmd;
import com.github.stefanvozd.cqrs.reactiveaxon.input.rabbit.ReactiveRabbitReceiver;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReactiveCommandGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReactiveCommandGateway.class);

    private final CommandGateway commandGateway;

    public ReactiveCommandGateway(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    //Completable future is eager and Mono is lazy.
    //Without defer, query would be sent immediately, before anyone subscribes, causing weird effects
    public <C, R> Mono<R> send(C command) {
        return Mono.defer(
                () -> Mono.fromFuture(commandGateway.send(command))
        );
    }

    //Sends command one by one, in same ordered they are arriving.
    //Supports back pressure, requests next command once previous has been sent
    public <C,R> Flux<R> sendAll(Publisher<C> commands)  {
        return Flux.from(commands)
                .concatMap(this::send);
    }

}
