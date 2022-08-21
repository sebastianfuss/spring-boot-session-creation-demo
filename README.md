This project demonstrates a session creation even `SessionCreationPolicy.STATELESS` is configured with spring boot `2.7.3`.
With spring boot `2.6.11` no session was created.

### how to reproduce?
```shell
./mvnw clean package
java -jar target/demo.jar
```

```shell
➜  demo curl -X GET http://localhost:8080/foo -I

HTTP/1.1 401 Unauthorized
Expires: 0
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Set-Cookie: JSESSIONID=-rmUZANCfe7u-NSODewS2lwYOzKKqOQ2YkOgB7h7; path=/
X-XSS-Protection: 1; mode=block
Pragma: no-cache
X-Frame-Options: DENY
Date: Sun, 21 Aug 2022 09:56:14 GMT
Connection: keep-alive
WWW-Authenticate: Bearer
X-Content-Type-Options: nosniff
Content-Length: 0
```