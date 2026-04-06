# RADME

## 项目依赖
例举每一个项目使用依赖，以说明项目从简单到复杂。

`01_Book-InMemory-RESTful-API`
- `spring-boot-starter-web`

`02_SpringBootRestAPI`
- `spring-boot-starter-web`
- `spring-boot-devtools` new


`03_SpringBootRestEmployee`
- `spring-boot-starter-web`
- `spring-boot-devtools`
- `spring-boot-starter-data-jpa` new
- `mysql-connector-j` new
- `h2` new

`04_SpringBootWebFlux`

- `spring-boot-starter-data-mongodb-reactive`：
这是实现响应式编程的关键。它提供了异步、非阻塞的 MongoDB 操作能力（使用 ReactiveMongoRepository）。

- `spring-boot-starter-webflux`：
这是 Spring 的响应式 Web 框架，用来替代传统的 spring-boot-starter-web（Servlet 架构）。它运行在 Netty 之上。

- `spring-boot-starter-thymeleaf`：
虽然 WebFlux 通常用于构建前后端分离的 API，但你这里引入了 Thymeleaf，说明你可能在用响应式的方式渲染 HTML 页面。

- `lombok`
这几乎是 Java 开发的必备“手动添加项”。
它通过注解（如 @Data, @NoArgsConstructor）在编译期自动生成 Getter/Setter，减少样板代码。

- reactor-test：
专门用于测试 Project Reactor 流（Mono 和 Flux）的工具库。

`05_SpringBootWebFluxRest`
- `spring-boot-starter-data-mongodb-reactive`
  - 作用：这是 MongoDB 的响应式驱动。
  - 特点：它返回的是 Mono<T> 或 Flux<T> 对象，而不是直接的对象。这允许数据库操作不阻塞当前的执行线程。

- spring-boot-starter-webflux
  - 作用：项目标配。提供 HTTP 路由、控制器支持以及 Netty 服务器。
  - 注意：你这个 pom.xml 里没有 spring-boot-starter-web，这是非常正确的做法，避免了阻塞式和非阻塞式容器的冲突。

- `lombok`
  - 作用：通过注解减少样板代码（如自动生成 Getter/Setter/ToString）。
  - 注意：在 <build> 插件部分，它被排除在最后的可执行 Jar 包之外，因为它只在编译期起作用。

- `spring-boot-devtools`
  - 作用：开发环境神器。代码改动后，应用会自动重启，保存即生效。

- reactor-test
  - 作用：专门为响应式流提供的测试库。
  - 必用场景：如果你要写测试用例来验证 StepVerifier 逻辑，这个依赖是必须的。