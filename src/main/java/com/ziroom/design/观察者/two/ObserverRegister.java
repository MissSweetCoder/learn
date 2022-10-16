package com.ziroom.design.观察者.two;

import com.google.common.base.Preconditions;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月09日 16:11:00
 */
public class ObserverRegister {
    private ConcurrentHashMap<Class<?>,CopyOnWriteArraySet<ObserverAction>> register = new ConcurrentHashMap<>();

    public void register(Object observer){
        Map<Class<?>, Collection<ObserverAction>> observerActions = find(observer);
        observerActions.entrySet().forEach((entry) -> {
            Class<?> event = entry.getKey();
            Collection<ObserverAction> observerActionList = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = register.get(event);
            if (registeredEventActions == null){
                registeredEventActions = new CopyOnWriteArraySet<>();
                register.put(event,registeredEventActions);
            }
            registeredEventActions.addAll(observerActionList);
        });
    }

    public List<ObserverAction> match(Object event){
        List<ObserverAction> observerActions = new ArrayList<>();
        Class<?> eventClass = event.getClass();
        register.entrySet().stream()
                .filter(entry -> eventClass.equals(entry.getKey()))
                .forEach(entry -> observerActions.addAll(entry.getValue()));
        return observerActions;
    }

    private Map<Class<?>, Collection<ObserverAction>> find(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        List<Method> methods =  findMethodWithSubscribe(observer);
        for (Method method : methods){
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> event = parameterTypes[0];
            if (observerActions.containsKey(event)){
                observerActions.put(event,new ArrayList<>());
            }
            ObserverAction observerAction = new ObserverAction(observer, method);
            observerActions.get(event).add(observerAction);
        }
        return observerActions;
    }

    private List<Method> findMethodWithSubscribe(Object observer) {
        List<Method> methodWithSubscribe = new ArrayList<>();
        for (Method method : observer.getClass().getDeclaredMethods()){
            if (method.isAnnotationPresent(Subscribe.class)){
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1 ,
                        "Method %s has Subscribe annotation but has %s paramters.Subscriber methods must have exactly 1 parameter."
                        ,method,parameterTypes.length);
                methodWithSubscribe.add(method);
            }
        }
        return methodWithSubscribe;
    }

}
