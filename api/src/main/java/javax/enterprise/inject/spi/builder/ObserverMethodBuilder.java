package javax.enterprise.inject.spi.builder;

import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import javax.enterprise.inject.spi.EventMetadata;
import javax.enterprise.inject.spi.ObserverMethod;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Tomas Remes
 */
public interface ObserverMethodBuilder<T> extends ObserverMethodConfigurator<T> {

    /**
     * Add the qualifier to the observed event
     *
     * @param qualifier to add to event
     * @return self
     */
    ObserverMethodBuilder<T> addQualifier(Annotation qualifier);

    /**
     * Add all the qualifiers to the Observed event
     *
     * @param qualifiers to add to event
     * @return self
     */
    ObserverMethodBuilder<T> addQualifiers(Annotation... qualifiers);

    /**
     * Add all the qualifiers to the Observed event
     *
     * @param qualifiers to add to event
     * @return self
     */
    ObserverMethodBuilder<T> addQualifiers(Set<Annotation> qualifiers);

    /**
     * Replace all qualifiers on the Observed event.
     *
     * @param qualifiers to put on event
     * @return self
     */
    ObserverMethodBuilder<T> qualifiers(Annotation... qualifiers);

    /**
     * Replace all qualifiers on the Observed event.
     *
     * @param qualifiers to put on event
     * @return self
     */
    ObserverMethodBuilder<T> qualifiers(Set<Annotation> qualifiers);

    /**
     * Set the {@link Reception} mode for the observer to build
     *
     * @param reception reception type
     * @return self
     */
    ObserverMethodBuilder<T> reception(Reception reception);

    /**
     * Set the {@link TransactionPhase} for the observer to build
     *
     * @param transactionPhase phase for the observer
     * @return self
     */
    ObserverMethodBuilder<T> transactionPhase(TransactionPhase transactionPhase);

    /**
     * Set the priority for the observer to build
     *
     * @param priority priority of the observer
     * @return self
     */
    ObserverMethodBuilder<T> priority(int priority);

    /**
     * Define Consumer to call when event is notified
     *
     * @param callback to call for the event notification
     * @return self
     */
    ObserverMethodBuilder<T> notifyWith(Consumer<T> callback);

    /**
     * Defines a BiConsumer to call when event is notified
     *
     * @param callback a BiConsumer taking an event type and an EventMetadata as type parameters
     * @return self
     */
    ObserverMethodBuilder<T> notifyWith(BiConsumer<T, EventMetadata> callback);

    /**
     * Allows modification of the asynchronous status of the observer to build.
     *
     * @param async async status
     * @return self
     */
    ObserverMethodBuilder<T> async(boolean async);

    /**
     * Set the class of the Bean containing this observer.
     * If not set, the extension class is used.
     *
     * @param type the bean class containing this configurator.
     * @return self
     */
    ObserverMethodBuilder<T> beanClass(Class<?> type);

    /**
     * Set the type of the observed event
     *
     * @param type of the observed event
     * @return self
     */
    ObserverMethodBuilder<T> observedType(Type type);

    ObserverMethod<T> build();

}
