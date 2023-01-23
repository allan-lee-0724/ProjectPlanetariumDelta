# Break #1

# Break
adding session store-type in .properties file and matching dependencies in pom.xml file

# Visual
Display of the broken code: use three back tics before and after the code snippet to format your code
```.properties
spring.session.store-type=jdbc
```

```pom.xml
<dependency>
	<groupId>org.springframework.session</groupId>		<artifactId>spring-session-core</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.session</groupId>
	<artifactId>spring-session-jdbc</artifactId>
</dependency>
```

display of what the code should actually be for the planetarium  app to be fixed
```
delete the above code
```
**Note: the broken "code" could be configurations, xml, etc. Just make sure you show what is broken and how it can be fixed**

# Indicator
adding these configurations will somehow create an empty session when the traffic gets sent to the cluster, resulting in 500 INTERNAL SERVER ERROR code in all requests

**Note: make sure your broken app actually returns the expected metrics by deploying it either locally or in your team's cluster**