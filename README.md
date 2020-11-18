# java10-local-type-inference
Gentle introduction to Java 10 local variable type inference.

* references
    * https://blog.codefx.org/java/java-10-var-type-inference/  
    * https://www.journaldev.com/19871/java-10-local-variable-type-inference
    * [Var with Style: Local Variable Type Inference in Java 10 by Stuart Marks](https://www.youtube.com/watch?v=786iemaCJHU)

# preface
* **type inference** - automatic detection of the data type of an expression

# overview
* when processing `var`
    * compiler looks at the right hand side of the declaration
        * so-called initializer
    * and uses its type for the variable
    * it writes that type into the resulting bytecode
* **types are not inferred at runtime but at compile time**
    * resulting bytecode is the same as with explicit type declaration
    * no extra processing at runtime
        * compiler infers all involved types 
        * puts them into the class files 
        * as if you typed them yourself
* `var` is not a keyword, but a reserved type name
    * it can only be used in places where the compiler expects 
    a type name, but everywhere else it’s a valid identifier
        * only classes called `var` will no longer work
* can be used only for "local variable declarations with initializers"
    ```
    // none of this works
    var ints = {0, 1, 2};
    var appendSpace = a -> a + " ";
    var x = 1, y = 2;
    ```
* only other eligible spots besides local variables are for loops 
and try-with-resources blocks.
    ```
    for (var number : numbers) {
        System.out.println(number);
    }
    ```
    
    ```
    try (var linesStream = Files.lines(Paths.get("src/test/java/LocalTypeInferenceTest.java"))) {
        linesStream.takeWhile(e -> !e.contains("public")).forEachOrdered(System.out::println);
    }
    ```
* where can var `NOT` be used?
    * method parameters, method return types, fields
    * why?
        * these types are part of a class's API - best to be explicit
        * they are written into the class file
        * they affect binary compatibility
        * too easy to introduce errors by inadvertently changing an inferred type
* can be reassigned to values of a compatible type
    ```
    var name = "Terry";
    name = "Diana";
    ```
    * if you want a variable that cannot be reassigned: `final var name = ...`
* pros
    * enables developers to write better code
    * reduces verbosity and clutter
        * from unimportant or redundant explicit declarations
        * helps with verbose generic types
    * lets more important things like the variable's name stand out
    * reduces the cost of extracting an expression into a local variable
    * the issue is one of readability
        * not the amount of keyboarding one needs to do