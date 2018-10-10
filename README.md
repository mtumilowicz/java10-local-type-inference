# java10-local-type-inference
Gentle introduction to Java 10 local variable type inference.

_Reference_: https://blog.codefx.org/java/java-10-var-type-inference/  
_Reference_: https://www.journaldev.com/19871/java-10-local-variable-type-inference

# preface
**Type inference** refers to the automatic detection of the data type of an expression 
in a programming language.

# overview
When processing `var`, the compiler looks at the right hand side of the 
declaration, the so-called initializer, and uses its type for the 
variable. And not just for internal bookkeeping, it writes that type 
into the resulting bytecode.

**Types are not inferred at runtime but at compile time**. That means 
the resulting bytecode is the same as with explicit type declaration - 
it does include the information about the type. That means no extra 
processing at runtime - the compiler infers all involved types 
and puts them into the class files as if you typed them yourself.

Technically, var is not a keyword, but a reserved type name, meaning it 
can only be used in places where the compiler expects a type name, but 
everywhere else it’s a valid identifier. That means that only classes 
called var will no longer work.

* It can be used only for "local variable declarations with initializers".
    ```
    // none of this works
    var ints = {0, 1, 2};
    var appendSpace = a -> a + " ";
    var x = 1, y = 2;
    ```

* The only other eligible spots besides local variables are for loops 
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