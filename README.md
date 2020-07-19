## Develop very simple microservices using Spring Cloud, Spring Boot, Eureka Server, Feign, and Hystrix

### Components
* eureka_server_a, eureka_server_b - Service Registration and Discovery
* flyway_migrations - mysql database migrations
* hystrix_monitor - monitor a single server microservice_order
* microservice_order - The Service which is going to get data from Server via the Discovery Service from the Service Registry (eureka_server_a, eureka_server_b)
* microservice_user - offer user information

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



