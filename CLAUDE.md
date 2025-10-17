# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java learning project focused on functional programming concepts, including lambdas, streams, collectors, and design patterns. The codebase primarily contains educational examples exploring Java's functional programming features introduced in Java 8 and beyond.

**Current Java Version**: Java 21 (Maven compiler source/target)

## Build and Test Commands

### Building the Project
```bash
mvn clean compile
```

### Running Tests
```bash
# Run all tests
mvn test

# Run a specific test class
mvn test -Dtest=CollectorTest

# Run a specific test method
mvn test -Dtest=CollectorTest#test_people_age_sum_reduce
```

### Packaging
```bash
mvn package
```

### Clean Build
```bash
mvn clean install
```

## Architecture and Code Organization

### Package Structure

The project is organized into three main conceptual areas:

1. **`idv.lance.onjava.*`** - Functional programming fundamentals
   - Closures and variable capture (Closure1-8)
   - Method references (MethodReferences, UnboundMethodReference, ConstructorReference)
   - Function composition (FunctionComposition, PredicateComposition)
   - Currying and partial application (Currying, CurryingAndPartials)
   - Recursion examples (RecursiveFibonacci, RecursiveFactorial)
   - Custom functional interfaces (TriFunction)

2. **`idv.lance.streams.*`** - Stream API exploration
   - Stream creation (StreamOf, Randoms, Generator, Ranges)
   - Intermediate operations (FlatMap, FunctionMap)
   - Terminal operations and collectors (Reduce, SpecialCollector, TreeSetOfWords)
   - Optional handling (Optionals, OptionalMap, OptionalFlatmap, OptionalFilter)
   - File I/O with streams (FileToWords, FileToWordsBuilder, FileToWordsRegexp)

3. **`idv.lance.collector.*`** - Custom collector implementations
   - PersonNameCollector: Custom collector demonstrating all Collector interface methods
   - Comprehensive collector examples in CollectorTest

4. **Root `idv.lance.*`** - Design patterns using functional programming
   - Strategy pattern with lambdas (StrategyExample)
   - Decorator pattern with function composition (DecoratorExample, Decorator2)
   - Iterator pattern (IteratorExample)

### Key Dependencies

- **Lombok** - Used extensively for @Slf4j logging annotations
- **JUnit 5** - Testing framework (junit-jupiter)
- **Apache Commons Lang3** - Utility functions
- **Guava** - Google's core libraries
- **Logback** - Logging implementation

### Testing Patterns

Tests in this project serve dual purposes:
1. Actual unit tests verifying behavior
2. Executable documentation demonstrating concepts

Key test classes:
- `CollectorTest` - Comprehensive examples of Java Stream collectors (reduce, groupBy, partitioning, mapping, etc.)
- `PersonNameCollector` - Custom collector implementation showing all interface methods

When writing new tests:
- Use descriptive method names that explain the concept being demonstrated
- Include inline comments explaining functional programming concepts
- Follow existing patterns in CollectorTest for consistency
- Use static imports for collectors (`import static java.util.stream.Collectors.*`)

## Development Notes

### Lombok Usage
Most classes use Lombok's @Slf4j annotation for logging. When adding logging to a new class, add `@Slf4j` annotation and use `log.info()`, `log.debug()`, etc.

### Functional Programming Style
This codebase demonstrates functional programming concepts:
- Prefer lambdas and method references over anonymous classes
- Use function composition (`.andThen()`, `.compose()`) to build complex operations
- Leverage streams for collection processing
- Examples often include multiple approaches to solving the same problem (see StrategyExample with totalValue vs totalValue2)

### Test-Driven Learning
Many "tests" are actually learning exercises demonstrating concepts. They include:
- Detailed comments explaining functional programming principles
- Multiple variations showing different approaches
- Some commented-out tests (possibly for future Java versions or experimental features)

## Common Patterns in This Codebase

### Custom Collectors
When implementing custom collectors (see PersonNameCollector.java):
- Implement all 5 Collector interface methods: supplier(), accumulator(), combiner(), finisher(), characteristics()
- supplier() creates the mutable container
- accumulator() adds elements to the container
- combiner() merges containers (for parallel streams)
- finisher() performs final transformation
- characteristics() declares collector properties

### Method References
The codebase extensively uses method references in various forms:
- Static method references: `Integer::sum`, `Collections::unmodifiableList`
- Instance method references: `Person::getName`, `String::toUpperCase`
- Unbound method references: Examples in UnboundMethodReference.java
- Constructor references: Examples in ConstructorReference.java

### Stream Operations
Common patterns found in streams package:
- Infinite streams with `Stream.generate()` and `Stream.iterate()`
- Primitive streams (IntStream, LongStream) for better performance
- FlatMap for nested collection flattening
- Collectors with downstream collectors (groupingBy + mapping)
