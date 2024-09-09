# KodeKraft_BDD_Cucumber_JunitFramework
Learn Cucumber with Junit and Selenium + Java....

to run test
mvn clean test -Dbrowser=chrome -Dheadless=true

### Key Changes:
#### New useGrid System Property:
You can pass the system property useGrid to determine whether to use Selenium Grid (true) or run locally (false).
__ If useGrid=true, __  
** `it connects to the Grid.** 

`If useGrid=false 
or the parameter is omitted, it runs locally.
Grid and Local Logic: The code now handles both the scenarios: if useGrid is set, it connects to the Selenium Grid; otherwise, it runs the tests using local drivers.
Running with Maven:
To run against the grid or locally,
you can pass the useGrid parameter when running Maven commands.
`
### Run using Selenium Grid:
`mvn test -Dbrowser=chrome -Dheadless=true -DuseGrid=true -Dselenium.grid.url=http://localhost:4444`

### Run locally:
mvn test -Dbrowser=chrome -Dheadless=true
