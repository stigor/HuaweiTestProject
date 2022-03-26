# Huawei Interview Test Task

Example of implementation Linked Node and tests for it

## Open questions:

1. There are no obvious methods for linked lists implementation: **add**, **addFirst**, **addLast**, **remove** and
   other.
2. What will happen in findNode method if parent and child nodes have the same value.
3. There is test which detect initial incorrect findNode method
   implementation: `org.example.LinkedNodeBaseTest.checkFindMethodWithIncorrectImplementationWorks`

## How to run tests:

Just run gradle command in the root of repository:

~~~
./gradlew test
~~~

## How to serve Allure report:

1. Run test
2. Execute command:

~~~
./gradlew allureServe
~~~

