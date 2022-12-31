package com.solvd.construction_company.reflection;

import com.solvd.construction_company.orders.Order;
import com.solvd.construction_company.staff.Director;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);

        //get class of Class and variables [.class] / [getDeclaredFields]
        Class<Order> orderClass = Order.class;
        Field[] declaredFields = orderClass.getDeclaredFields();
        for (Field field : declaredFields) {
            logger.info("field of the Order class: " + field);
        }

        //get variable by name, if not exist, throws exception [getDeclaredField]
        try {
            Field orderID = orderClass.getDeclaredField("orderID");
            logger.info("variable of Order class: " + orderID);
            Field orderName = orderClass.getDeclaredField("orderName");
            logger.info(" variable of Order class: " + orderName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //get only public field [getFields]
        Field[] publicFields = orderClass.getFields();
        for (Field field : publicFields) {
            logger.info("public variable of Order class: " + field);
        }

        //get public variable by name, if not exist or private throw exception [getField]
        try {
            Field orderId = orderClass.getField("orderID");
            logger.info("public variable of Order class: " + orderId);
            Field orderName = orderClass.getField("orderName");
            logger.info("public variable of Order class: " + orderName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //get all methods [getDeclaredMethods]
        Method[] declaredMethods = orderClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            logger.info("method of Order class: " + method);
        }

        // get methods by name + param types, if not exist, throws exception [getDeclaredMethods]
        try {
            Method createNewOrder = orderClass.getDeclaredMethod("createNewOrder");
            logger.info("method of Order Class: " + createNewOrder);

            Method setOrderId = orderClass.getDeclaredMethod("setOrderID", int.class);
            logger.info("method of Order Class: " + setOrderId);

            orderClass.getDeclaredMethod("getOrderName");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //get all public methods and parent+interface methods [getMethods]
        Method[] methods = orderClass.getMethods();
        for (Method method : methods) {
            logger.info("public method of Order Class: " + method);
        }

        //get public method by name, if not exist, throws exception [getMethod]
        try {
            Method createNewOrder = orderClass.getMethod("createNewOrder");
            logger.info("public method of Order Class: " + createNewOrder);

            Method getOrderName = orderClass.getMethod("getOrderName");
            logger.info("public method of Order Class: " + getOrderName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //get method, where anonymous or local class has been created, if no exist -> null [getEnclosingMethod]
        Order order2 = new Order(2, 2) {
            public void createNewOrder() {
                logger.info("New Order created");
            }
        };
        Method enclosingMethod = order2.getClass().getEnclosingMethod();
        logger.info("local or anonymous class of Order class: " + enclosingMethod);

        //get value of private variable [getInt] [setAccessible(true)]
        Order order = new Order(5, 5);
        Class<? extends Order> carClass = order.getClass();
        Field orderId = null;
        try {
            orderId = carClass.getDeclaredField("orderID");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        orderId.setAccessible(true);
        try {
            logger.info("Value of getInt field in Order class before change: " + orderId.getInt(order));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        //set value of private variable
        try {
            orderId.setInt(order, 51);
            logger.info("Value of getInt field in Order class after change: " + orderId.getInt(order));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        //get method name [getMethod]
        Order o = new Order(100, 100);
        Class<? extends Order> oClass = o.getClass();

        Method getOrderID = null;
        try {
            getOrderID = oClass.getMethod("getOrderID");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        logger.info("Name of the method in Order class: " + getOrderID.getName());

        //call public method [invoke]
        Object resultValue = null;
        try {
            resultValue = getOrderID.invoke(o);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        logger.info("result of calling public getOrderId method in Order class: " + resultValue);

        //call private method [setAccessible(true)] [invoke]
        Method getOrderInfo = null;
        try {
            getOrderInfo = oClass.getDeclaredMethod("getOrderInfo");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        getOrderInfo.setAccessible(true);
        try {
            getOrderInfo.invoke(o);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        logger.info("result of calling public getOrderId method in Order class: " + getOrderInfo);

        //create new object using reflection [newInstance]
        Director dir;
        try {
            dir = Director.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        logger.info("Object Director created: " + dir);
    }
}
