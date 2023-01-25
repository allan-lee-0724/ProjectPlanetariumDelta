# Break #2

# Break
modifying the http status for all contollers to HTTP_VERSION_NOT_SUPPORTED

# Visual
Display of the broken code: use three back tics before and after the code snippet to format your code
```java
@GetMapping("{uri}")
    public ResponseEntity<List<{Generic}>> {methodName}(){
        return new ResponseEntity<>(this.service.{methodName}(), HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }
```

display of what the code should actually be for the planetarium  app to be fixed
```java
@GetMapping("{uri}")
    public ResponseEntity<List<{Generic}>> {methodName}(){
        return new ResponseEntity<>(this.service.{methodName}(), HttpStatus.OK);
    }
```
**Note: the broken "code" could be configurations, xml, etc. Just make sure you show what is broken and how it can be fixed**

# Indicator
running collections should return a blend of 404 and 505 for all api methods

![Collection will show a blend of 404 and 505 for api methods](./Running%20Collection%20B2.jpg)


**Note: make sure your broken app actually returns the expected metrics by deploying it either locally or in your team's cluster**
