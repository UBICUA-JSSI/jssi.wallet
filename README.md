# JSSI Wallet
Java implementation of SSI Wallet

## Description
JSSI Wallet is a Java module that provides the persistence and cryptographic functionality of SSI Wallet. The module is designed to be incorporated into the applications as a component. 
Due to security reasons, the API is conveniently divided in two parts:
- Public API that provides methods for managing sensitive data of SSI-compliant apps (external consumers). The Wallet API includes CRUD operations for the Wallet Records. The supported functionality is quite generic and compatible with different pluggable storages.
- Private API that provides methods for managing data and services accessible only by a DID Subject (identity owner). The private API contains a class for storing and retrieving the DID Subject cryptographic material (Metadata). Also, it includes the Wallet Service API that enables the Wallet export and import operations.

## Prerequisites
- IntelliJ 2021+
- Open JDK 15+

## Dependencies
- org.libsodium (a jni wrapper over libsodium)

## Configuration
The configuration directory of sqlite wallet is specified in the WALLET_DIR parameter of the jssi.wallet.WalletConstants class. The <user_dir>/.indy_client/wallet/ubicua_wallet/ value is set as default. However, the configuration may vary depending on the application requirements.

## Logging
Configure the log path in the logback.xml file:
```
<appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file>culaquier ruta/wallet.log</file>
    <encoder>
        <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
    </encoder>
</appender>
```
## Execution
Compile the module and execute the tests.




