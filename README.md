## Develop very simple microservices using Spring Cloud, Spring Boot, Eureka Server, Feign, and Hystrix

## Reference Documents:
* https://spring.io/projects/spring-cloud
* https://www.baeldung.com/spring-cloud-netflix-eureka
* https://www.baeldung.com/spring-cloud-openfeign
* https://www.baeldung.com/spring-cloud-netflix-hystrix

## Components:
<table>
    <tr>
        <th>Project Name</th>  <th>Description</th>  <th>Port</th>
    </tr>
<tbody>
    <tr>
        <td>eureka_server_a</td>  
        <td>Service Registration and Discovery</td>  
        <td>8888</td>
    </tr>
    <tr>
        <td>eureka_server_b</td>  
        <td>Service Registration and Discovery</td>  
        <td>9999</td>
    </tr>
    <tr>
        <td>microservice_order</td>  
        <td>The Service which is going to get data from Server via the Discovery Service from the Service Registry (eureka_server_a, eureka_server_b)</td>  
        <td>9011</td>
    </tr>
    <tr>
        <td>microservice_user</td>  
        <td>Offer user information</td>
        <td>9013</td>
    </tr>
    <tr>
        <td>hystrix_monitor</td>  
        <td>monitor a single server microservice_order</td>
        <td>7777</td>
    </tr>
    <tr>
        <td>flyway_migrations</td>  
        <td>mysql database migrations</td>
        <td>8080</td>
    </tr>
</tbody>
</table>

## Instructions for use:
### Eureka
Microservice Registry. Create two servers, when one of them is broken, the service can keep working.
    <table>
        <tr>
            <th>Url/th>  <th>Description</th>
        </tr>
        <tbody>     
            <tr>
                <td>http://127.0.0.1:8888/</td> 
                <td>Registry</td>
            </tr>
            <tr>
                <td>http://127.0.0.1:9999/</td> 
                <td>Registry</td>
            </tr>           
        </tbody>
    </table>

* 1.add EnableEurekaServer annotation
    
    
    @SpringBootApplication
    @EnableEurekaServer
    public class EurekaServerApplication {

        public static void main(String[] args){
            SpringApplication.run(EurekaServerApplication.class,args);
        }

    }
    
* 2.add Eureka server setting


    server:
      port: 9999
    spring:
      application:
        name: eureka-server
    eureka:
      client:
        fetch-registry: true
        register-with-eureka: true
        service-url:
          defaultZone: http://127.0.0.1:8888/eureka
      server:
        eviction-interval-timer-in-ms: 5000
        enable-self-preservation: false
    
### Openfeign
It is a convenient framework for calling Spring Cloud remote services.
    <table>
        <tbody>
            <tr>
                <td>http://127.0.0.1:9011/order/4ffcfab8-c765-11ea-826b-6027a2b7af48/</td> 
                <td>get microservice_order order information and microservice_user user information </td>
            </tr>        
        </tbody>
    </table>
    
    response data:
    {"status":"200","message":"sucess","orderMaster":{"id":1,"orderNum":"4ffcfab8-c765-11ea-826b-6027a2b7af48","game":"Lineage M","device":"mobile","username":"gary ssu","userId":1},"userDto":{"id":1,"username":"gary ssu","address":"New Taipei City","age":20,"lastLoginTime":"2020-07-16 03:00:00"},"orderDetails":null}

#### Hystrix
Monitor service display data on dashboard. When microservice_user is suspended, the fallback method will be used
    <table>
        <tbody>
            <tr>
                <td>http://127.0.0.1:7777/hystrix/</td> 
                <td>hystrix dashboard </td>
            </tr>        
        </tbody>
    </table>    

* 1.add Hystrix annotation in microservice_order
    
    
    @EnableFeignClients // OpenFeign

* 2.add fallback annotation in your controller


    @FeignClient(value = "microservice-user",fallback = UserControllerImpl.class)
    public interface UserController {

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public UserDto getUser(@PathVariable(value = "id") Integer id);

