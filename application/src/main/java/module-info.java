module application {
    exports com.example.application to spring.context;
    //requires spring.beans;
    //requires spring.core;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.boot.test;
    requires spring.boot.starter.test;
    requires org.slf4j;
}