# JSSI Wallet

JSSI Wallet is a Java API that gives access to the persistence and cryptographic functionality of SSI Wallet. Due to security reasons, the API is conveniently divided in two parts: Public (non-secret) API and Private (secret) API.

## Public API

Public interface provides methods for managing sensitive data of SSI-compliant apps (external consumers). The Wallet API includes CRUD operations for the Wallet Records. The supported functionality is quite generic and compatible with different pluggable storages.

## Private API

Private interface provides methods for managing data and services accessible only by a DID Subject (identity owner). The private API contains a class for storing and retrieving the DID Subject cryptographic material (Metadata). Also, it includes the Wallet Service API that enables the Wallet export and import operations. 

