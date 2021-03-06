```
NOTES TO GRADER/TA:
For M1 mutator, use the name "FieldNullCheck". Code is in FieldNullCheckMutator.java
For M4 mutator, use the name "M4". Code is in RandVarReplMutator.java

Following don't fully work, but are greatly implmented. Please see code.
For M2 mutatator, scanner class is ScanClassAdapter.java, and mutations in CallAnotherOverloadingMethod.java
For M3 mutatator, scanner class is ScanForMethodName.java, and mutations in ReplaceMethodNameMutator.java
```

# extendedPIT
Extending the great PIT Mutation Testing Tool, from pittest.org. This project includes additional mutators for better java test suite testing.

### Before you begin

Install maven onto your computer, as well as JAVA SDK

Navigate to extendedPIT/pitest.

```
$ mvn clean install -DskipTests
```

Also run this command in every program being tested for. It should be run whereever the pom.xml file is located for the project.

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
            <mutator>CONDITIONALS_BOUNDARY</mutator>
            <mutator>INCREMENTS</mutator>
            <mutator>VOID_METHOD_CALLS</mutator>
            <mutator>RETURN_VALS</mutator>
            <mutator>INVERT_NEGS</mutator>
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
            <mutator>UOIADD1</mutator>
            <mutator>UOISUBTRACT1</mutator>
            <mutator>SVR1</mutator>
            <mutator>SVR2</mutator>
            <mutator>FieldNullCheck</mutator>
            <mutator>M4</mutator>
          </mutators>
        </configuration>
      </plugin>
     </plugins>
    </build>

OR IF ALL MUTATORS:
    
    <build>
     <plugins>
      <plugin>
        <groupId>org.pitest</groupId>
        <artifactId>pitest-maven</artifactId>
        <version>1.4.0-SNAPSHOT</version>
        <configuration>
          <mutators>
            <mutator>ALL</mutator>
          </mutators>
        </configuration>
      </plugin>
     </plugins>
    </build

Additionally the following lines can be added in the configuration section to run only certain test cases. This is an example of testing only on org.jfree.char.annotations package in jfree chart program code.

          <targetClasses>
            <param>org.jfree.chart.annotations*</param>
          </targetClasses>
          <targetTests>
            <param>org.jfree.chart.annotations*</param>
          </targetTests>

To run a test, open a command line interface where your project's pom.xml file is located
```
$ mvn clean install -DskipTests
```
```
$ mvn org.pitest:pitest-maven:mutationCoverage
```