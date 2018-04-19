# extendedPIT
Extending the great PIT Mutation Testing Tool, from pittest.org. This project includes additional mutators for better java test suite testing.

### Before you begin

Install maven onto your computer, as well as JAVA SDK

Navigate to extendedPIT/pitest/pitest

```
$ mvn clean install -DskipTests
```

### To run a test
First copy and paste below code into pom.xml file of the project in the correct location to include all extensions (or remove lines of which is not needed)

    <build>
     <plugins>
      <plugin>
        <groupId>org.pitest</groupId>
        <artifactId>pitest-maven</artifactId>
        <version>1.4.0-SNAPSHOT</version>
        <configuration>
          <mutators>
            <mutator>MATH</mutator>
            <mutator>AOR1</mutator>
            <mutator>AOR2</mutator>
            <mutator>AOR3</mutator>
            <mutator>NEGATE_CONDITIONALS</mutator>
            <mutator>ROR1</mutator>
            <mutator>ROR2</mutator>
            <mutator>ROR3</mutator>
            <mutator>ROR4</mutator>
            <mutator>AOD1</mutator>
            <mutator>AOD2</mutator>
            <mutator>Invert</mutator>
            <mutator>FieldNullCheck</mutator>
            <mutator>RandVarRepl</mutator>
          </mutators>
        </configuration>
      </plugin>
     </plugins>
    </build>

Additionally the following lines can be added in the configuration section to run only certain test cases.

          <targetClasses>
            <param>org.jfree.chart.annotations*</param>
          </targetClasses>
          <targetTests>
            <param>org.jfree.chart.annotations*</param>
          </targetTests>

To run a test, open a command line interface where your project's pom.xml file is located
```
$ mvn test
```
```
$ mvn org.pitest:pitest-maven:mutationCoverage
```