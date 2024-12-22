# Java Fundamentals

## Scripts

```bash
make run
```

# Advanced Concepts in Java

## 1. Multithreading and Concurrency
- **Threads**: Creating and managing threads using `Thread` or `Runnable`.
- **Executors**: Using `ExecutorService` and `ThreadPool`.
- **Concurrency Utilities**: Classes like `Semaphore`, `CountDownLatch`, and `CyclicBarrier`.
- **Fork/Join Framework**: Parallel computing with the `ForkJoinPool`.
- **CompletableFuture**: Asynchronous programming with futures.
- **Synchronization**: Locks (`ReentrantLock`, `ReadWriteLock`) and synchronized blocks.
- **Volatile and Atomic Classes**: Managing shared variables in concurrent scenarios.

---

## 2. Java Memory Management
- **Heap and Stack**: Understanding memory allocation and lifecycle.
- **Garbage Collection**: Tuning and understanding GC algorithms (e.g., G1, ZGC).
- **Weak, Soft, and Phantom References**: Managing object references for memory-sensitive applications.
- **Memory Leaks**: Identifying and fixing them using tools like VisualVM and JProfiler.

---

## 3. Generics and Advanced Collections
- **Custom Generic Classes and Methods**: Creating type-safe, reusable code.
- **Wildcard Types**: `? extends` and `? super`.
- **Concurrent Collections**: `ConcurrentHashMap`, `CopyOnWriteArrayList`.
- **Navigable and Sorted Collections**: `TreeMap`, `TreeSet`.

---

## 4. Design Patterns
- **Creational Patterns**: Singleton, Factory, Builder.
- **Structural Patterns**: Adapter, Decorator, Proxy.
- **Behavioral Patterns**: Observer, Strategy, Command.
- **Concurrency Patterns**: Producer-Consumer, Thread-Safe Singleton.

---

## 5. Functional Programming
- **Lambdas and Streams**: Writing concise, functional-style code.
- **Optional**: Avoiding null references and improving code readability.
- **Collectors**: Custom and built-in collectors in the Streams API.
- **Method References**: `ClassName::methodName` syntax.
- **Higher-Order Functions**: Functions that return or take other functions as parameters.

---

## 6. Reflection and Annotations
- **Reflection API**: Inspecting classes, methods, and fields at runtime.
- **Annotations**: Custom annotations and processing with `AnnotationProcessor`.
- **Dynamic Proxies**: Creating runtime implementations of interfaces.

---

## 7. Java Modules (JPMS)
- Modular programming introduced in Java 9.
- **Defining Modules**: Using `module-info.java`.
- **Encapsulation**: Controlling visibility between modules.
- **Services API**: Dependency injection with `provides` and `uses`.

---

## 8. Input/Output and Serialization
- **NIO.2 (New I/O)**: Working with non-blocking I/O, `Path`, and `Files`.
- **Asynchronous Channels**: `AsynchronousFileChannel`, `AsynchronousSocketChannel`.
- **Serialization**: Custom serialization with `Serializable` and `Externalizable`.
- **Object Streams**: Reading/writing objects to streams.

---

## 9. Networking
- **Socket Programming**: TCP and UDP communication.
- **HTTP Clients**: Using `HttpClient` introduced in Java 11.
- **REST APIs**: Working with JSON and APIs using libraries like Jackson or Gson.
- **WebSocket Programming**: Full-duplex communication.

---

## 10. Advanced Java APIs
- **Streams and Parallel Streams**: Leveraging multi-core systems.
- **JDBC and ORM Frameworks**: Efficient database interaction.
- **JMX (Java Management Extensions)**: Monitoring and managing applications.
- **JavaFX**: Rich UI applications.

---

## 11. JVM and Performance Optimization
- **JVM Tuning**: Managing heap, stack, and GC tuning.
- **JIT Compilation**: Understanding how the JVM optimizes code at runtime.
- **Profiling and Monitoring**: Tools like JProfiler, VisualVM, and Flight Recorder.
- **Bytecode Manipulation**: Using libraries like ASM, Javassist.

---

## 12. Security
- **Encryption and Decryption**: Using Java's `javax.crypto` package.
- **Secure Sockets**: SSL/TLS communication.
- **Authentication/Authorization**: Working with JWT, OAuth.
- **Secure Coding Practices**: Avoiding common vulnerabilities like SQL injection and XSS.

---

## 13. Distributed Systems
- **Microservices**: Building and managing distributed applications.
- **Messaging**: Using RabbitMQ, Kafka, or JMS.
- **RESTful Web Services**: Developing and consuming APIs.
- **Remote Method Invocation (RMI)**: Distributed computing in Java.

---

## 14. Testing and Debugging
- **Unit Testing**: Using JUnit and Mockito.
- **Integration Testing**: Using Spring Boot Test and TestContainers.
- **Debugging Tools**: Breakpoints, watches, and stepping through code.
- **Static Code Analysis**: Using SonarQube or PMD.

---

## 15. Advanced Libraries and Frameworks
- **Spring Framework**: Dependency injection, AOP, and data access.
- **Hibernate**: ORM and caching.
- **Akka**: Actor-based concurrency.
- **Vert.x**: Reactive programming.

---