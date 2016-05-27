/*
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package javax.enterprise.inject.spi.builder;

import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.EventMetadata;
import javax.enterprise.inject.spi.ObserverMethod;
import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * This API is an helper to build a new {@link ObserverMethod} instance.
 * CDI container must provides an implementation of this interface accessible.
 *
 * This configurator is not thread safe and shall not be used concurrently.
 *
 * @param <T> type of the event the configured ObserverMethod will observe
 * @author Antoine Sabot-Durand
 * @see AfterBeanDiscovery#addObserverMethod()
 * @since 2.0
 */
public interface ObserverMethodConfigurator<T> {


    /**
     * Add the qualifier to the observed event
     *
     * @param qualifier to add to event
     * @return self
     */
    ObserverMethodConfigurator<T> addQualifier(Annotation qualifier);

    /**
     * Add all the qualifiers to the Observed event
     *
     * @param qualifiers to add to event
     * @return self
     */
    ObserverMethodConfigurator<T> addQualifiers(Annotation... qualifiers);

    /**
     * Add all the qualifiers to the Observed event
     *
     * @param qualifiers to add to event
     * @return self
     */
    ObserverMethodConfigurator<T> addQualifiers(Set<Annotation> qualifiers);

    /**
     * Replace all qualifiers on the Observed event.
     *
     * @param qualifiers to put on event
     * @return self
     */
    ObserverMethodConfigurator<T> qualifiers(Annotation... qualifiers);

    /**
     * Replace all qualifiers on the Observed event.
     *
     * @param qualifiers to put on event
     * @return self
     */
    ObserverMethodConfigurator<T> qualifiers(Set<Annotation> qualifiers);

    /**
     * Set the {@link Reception} mode for the observer to build
     *
     * @param reception reception type
     * @return self
     */
    ObserverMethodConfigurator<T> reception(Reception reception);

    /**
     * Set the {@link TransactionPhase} for the observer to build
     *
     * @param transactionPhase phase for the observer
     * @return self
     */
    ObserverMethodConfigurator<T> transactionPhase(TransactionPhase transactionPhase);

    /**
     * Set the priority for the observer to build
     *
     * @param priority priority of the observer
     * @return self
     */
    ObserverMethodConfigurator<T> priority(int priority);

    /**
     * Define Consumer to call when event is notified
     *
     * @param callback to call for the event notification
     * @return self
     */
    ObserverMethodConfigurator<T> notifyWith(Consumer<T> callback);

    /**
     * Defines a BiConsumer to call when event is notified
     *
     * @param callback a BiConsumer taking an event type and an EventMetadata as type parameters
     * @return self
     */
    ObserverMethodConfigurator<T> notifyWith(BiConsumer<T, EventMetadata> callback);

    /**
     * Allows modification of the asynchronous status of the observer to build.
     *
     * @param async async status
     * @return self
     */
    ObserverMethodConfigurator<T> async(boolean async);
}
