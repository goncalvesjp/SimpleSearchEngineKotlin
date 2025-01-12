package search

import java.io.File
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if(args.size!=2  ||  args[0] != "--data"){
        println("Usage: --data <filename>.txt")
        return
    }


    val people : List<String> =  File(args[1]).useLines { it.toList() }

    menu(people = people)

}

fun menu(people: List<String>) {
    println()
    while (true) {
        println("=== Menu ===")
        println("1. Find a person")
        println("2. Print all people")
        println("0. Exit")

        val value = readln().toInt() ?:continue
        println()

        when (value) {
            1 -> findPerson(people = people)
            2 -> printAllPeople(people = people)
            0 -> existApplication()
            else -> println("Incorrect option! Try again.")
        }
        println()
    }
}

fun existApplication() {
    println("Bye!")
    exitProcess(0)
}

fun printAllPeople(people: List<String>) {
    println("=== List of people ===")
    for (person in people) {
        println(person)
    }
}

fun findPerson(people: List<String>) {
    println("Select a matching strategy: ALL, ANY, NONE")
    val strategy = readln()
    when (strategy) {
        "ALL" -> findPersonAll(people = people)
        "ANY" -> findPersonAny(people = people)
        "NONE" -> findPersonNone(people = people)
    }
}

fun findPersonNone(people: List<String>) {
    println("Enter a name or email to search all matching people.")

    val dateToSearch = readln()

    if (people.map { p -> !p.contains(dateToSearch, true) }.reduce { a1, a2 -> a1 or a2 }) {
        val peopleFound = people.filter { p -> !p.contains(dateToSearch, true) }
        if(peopleFound.size == 1) {
            println("1 person found:")
        } else {
            println("${peopleFound.size} persons found:")
        }

        for (person in peopleFound) {
            println(person)
        }
    } else {
        println("No matching people found.")
    }
}

fun findPersonAny(people: List<String>) {
    println("Enter a name or email to search all matching people.")

    val dateToSearch = readln()

    if (people.map { p -> p.contains(dateToSearch, true) }.reduce { a1, a2 -> a1 or a2 }) {
        val peopleFound = people.filter { p -> p.contains(dateToSearch, true) }
        if(peopleFound.size == 1) {
            println("1 person found:")
        } else {
            println("${peopleFound.size} persons found:")
        }

        for (person in peopleFound) {
            val p = person.split(" ")
            println("${p[0]} ${p[1]}")
        }
    } else {
        println("No matching people found.")
    }
}

fun findPersonAll(people: List<String>) {
    println("Enter a name or email to search all matching people.")

    val dateToSearch = readln()

    if (people.map { p -> p.contains(dateToSearch, true) }.reduce { a1, a2 -> a1 or a2 }) {
        val peopleFound = people.filter { p -> p.contains(dateToSearch, true) }
        if(peopleFound.size == 1) {
            println("1 person found:")
        } else {
            println("${peopleFound.size} persons found:")
        }

        for (person in peopleFound) {
            println(person)
        }
    } else {
        println("No matching people found.")
    }
}
