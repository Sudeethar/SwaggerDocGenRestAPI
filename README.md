### What's this?
It's a REST API that uses Springboot, Flyway, and H2 database.
When starting locally, this app uses port 8087, if that is already taken in your machine, you need to change it in application.properties.





### API Documentation

* [swagger] (http://localhost:8087/music/swagger-ui/index.html#/)
* [hal explorer] (http://localhost:8087/music/explorer/index.html#uri=/music/)

### H2 Database
* [h2 console] (http://localhost:8087/music/h2-console/)
* database: jdbc:h2:mem:testdb
* username: sa
* password: password


** Use projections to get more details in the response
* http://localhost:8087/music/cds?projection=cdDetails
* http://localhost:8087/music/artists/{artistid}/cds?projection=cdDetails

__Available projections:__
* artistDetails
* cdDetails
* trackDetails


