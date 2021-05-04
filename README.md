# kinesis-avro-prototype
To learn avro serialization and compressing record before writing it into kinesis.

How to build
```sh
mvn clean verify
```

How to run
- Generate the session credentials from [operations.cj.dev](operations.cj.dev)
- Put it into Environment Variable in Application Template Configuration in IntelliJ
- Set the main class as com.cj.prototype.EntryPoint.
- Set the working directory to folder containing pom.xml
