# Gestion Zoo — Java OOP Project

Zoo management application developed in Java as part of the **Prosits 1 to 6** at **ESPRIT** (Programmation Orientée Objet).

## Team
Med Hedi Nsir — [@medhedinsir](https://github.com/medhedinsir)

## Project structure
```
src/tn/esprit/gestionzoo/
├── main/
│   └── ZooManagement.java   → main class (entry point)
└── entities/
    ├── Animal.java          → base class (family, name, age, isMammal)
    ├── Zoo.java             → zoo with animals & aquatic animals arrays
    ├── Aquatic.java         → abstract class (habitat, swim(), equals())
    ├── Terrestrial.java     → terrestrial animals (nbrLegs)
    ├── Dolphin.java         → aquatic (swimmingSpeed)
    └── Penguin.java         → aquatic (swimmingDepth)
```

## Prosits covered
| Prosit | Content |
|--------|---------|
| 1 | Main class, variables, keyboard input with `Scanner` + input validation |
| 2 | `Animal` and `Zoo` classes, parameterized constructors |
| 3 | Zoo methods: add, search, remove, display animals, compare zoos |
| 4 | Encapsulation (private attributes, getters/setters), packages |
| 5 | Inheritance: `Aquatic`, `Terrestrial`, `Dolphin`, `Penguin`, `toString()` overriding |
| 6 | Polymorphism, abstract `swim()`, `instanceof`, overriding `equals()` |

## OOP concepts used
- Encapsulation
- Inheritance
- Polymorphism
- Abstract classes & methods
- Method overriding (`toString`, `equals`, `swim`)

## How to run
1. Open the project in **IntelliJ IDEA**
2. Run `ZooManagement.java` (in `tn.esprit.gestionzoo.main`)
3. Enter a zoo name and a number of cages in the console

## Tech
- Java 17+
- IntelliJ IDEA
