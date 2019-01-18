package demo


import kotlin.random.Random
import kotlin.Pair



fun main(args : Array<String>) {
    println("Hello, world!")

    //Number values

    var bigInt: Int = Int.MAX_VALUE
    var smallInt: Int = Int.MIN_VALUE
    println("Biggest Int : " + bigInt)
    println("Smallest Int: $smallInt")

    var bigLong: Long = Long.MAX_VALUE
    var smallLong: Long = Long.MIN_VALUE
    println("Biggest Long : " + bigLong)
    println("Smallest Long: $smallLong")

    var bigDouble: Double = Double.MAX_VALUE
    var smallDouble: Double = Double.MIN_VALUE
    println("Biggest Double: " + bigDouble)
    println("Smallest Double: $smallDouble")

    var bigFloat: Float = Float.MAX_VALUE
    var smallFloat: Float = Float.MIN_VALUE
    //loss of precision with Float past 15 digits
    println("Biggest Float: " + bigFloat)
    println("Smallest Float: $smallFloat")

    var dbNum1: Double = 1.11111111111111111
    var dbNum2: Double = 1.11111111111111111
    println("Sum : " + (dbNum1 + dbNum2))

    //Boolean

    if (true is Boolean) {
        print("true is boolean\n")
    }
    var letterGreade: Char = 'A'
    println("A is a Char : ${letterGreade is Char}")

    //Casting

    println("3.14 to Int : " + (3.14.toInt()))
    println("A to Int : " + ('A'.toInt()))
    println("65 to Char : " + 65.toChar())

    //Strings

    val myName = "Mike Page"
    val longStr = """This is a long string"""
    var fName: String = "Mike"
    var lName: String = "Page"
    fName = "Sally"
    var fullName = fName + " " + lName
    println("Name : $fullName")
    println("1 + 2 = ${1 + 2}")
    println("String Length : ${longStr.length}")

    var str1 = "A random string"
    var str2 = "a random string"
    println("Strings Equal : ${str1.equals(str2)}")
    println("Compare A to B : ${'A'.compareTo('B')}")
    println("2nd index : ${str1[2]}")
    println("Index 2 - 7 : ${str1.subSequence(2, 8)}")
    println("Contains random : ${str1.contains("random")}")

    //Arrays

    var myArray = arrayOf(1, 1.34, "Mike")
    println(myArray[2])
    myArray[1] = 2.222
    println("Array Length : ${myArray.size}")
    println("Mike in Array : ${myArray.contains("Mike")}")

    var partArray = myArray.copyOfRange(0, 1)
    println("First : ${myArray.first()}")
    println("Index of Mike : ${myArray.indexOf("Mike")}")
    //Square array { x = 2, then 2 x 2 }
    var sqArray = Array(5, { x -> x * x })
    println(sqArray[2])
    //type specific Array <type>
    var arr2: Array<Int> = arrayOf(1, 2, 3)

    //Ranges

    val oneTo10 = 1..10
    val alpha = "A".."Z"
    println("R in Alpha : ${"R" in alpha}")

    val tenTo1 = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)
    val rng3 = oneTo10.step(3)
    //for loop
    for (x in rng3) println("rng3 : $x")
    for (x in tenTo1.reversed()) println("Reverse : $x")

    //Conditionals

    val age = 8
    if (age < 5) {
        println("Go to preschool")
    } else if (age == 5) {
        println("Go to kindergarden")
    } else if ((age > 5) && (age <= 17)) {
        val grade = age - 5
        println("Go to Grade $grade")
    } else {
        println("Go to College")
    }
    //When statement, similar to Case in Java
    when (age) {
        0, 1, 2, 3, 4 -> println("Go to Preschool")

        5 -> println("Go to Kindergarden")
        //in denotes range
        in 6..17 -> {
            val grade = age - 5
            println("Go to grade $grade")
        }
        else -> println("Go to college")
    }

    //Loops

    for (x in 1..10) {
        println("Loop : $x")
    }
    //import Kotlin Random number -> does not use "()" on instance of .Random
    val rand: Random = Random
    val magicNum = rand.nextInt(50) + 1
    var guess = 0

    while (magicNum != guess) {
        guess += 1
    }
    println("Magic Number was $guess")
    for (x in 1..20) {
        if (x % 2 == 0) {
            continue
            //skips even numbers and prints odd
        }
        println("Odd : $x")

        if (x == 15) break
    }
    //for loop used to iterate through an array to display each index
    var arr3: Array<Int> = arrayOf(3, 6, 9)

    for (i in arr3.indices) {
        println("Mult 3 : ${arr3[i]}")
    }

    for ((index, value) in arr3.withIndex()) {
        println("Index : $ Value : $value")
    }

    //functions

    fun add(num1: Int, num2: Int): Int = num1 + num2
    println("5+4 = ${add(5, 4)}")

    fun subtract(num1: Int = 1, num2: Int = 1) = num1 - num2
    println("5 - 4 = ${subtract(5, 4)}")
    println("4 - 5 = ${subtract(num2 = 5, num1 = 4)}")

    fun sayHello(name: String): Unit = println("Hello $name")
    sayHello("Mike")

    // val (two, three) = nextTwo(1)
    //println("1 $two $three")

    println("Sum = ${getSum(1,2,3,4,5)}")
    val multiply = {num1: Int, num2: Int -> num1 * num2}
    println("5 * 3 = ${multiply(5,3)}")
    //factorial "!" operator
    println("5! = ${fact(5)}")

    //collection operators

    val numList = 1..20
    //"it" used with only one var, no need to declare
    val evenList = numList.filter { it % 2 == 0 }
    evenList.forEach { n -> println(n) }
    //used with the function makeMathFunc
    val mult3 = makeMathFunc(3)
    println("5 * 3 = ${mult3(5)}")
    //used with mathOnList function
    val multiply2 = {num1: Int -> num1 * 2}
    val numList2 = arrayOf(1,2,3,4,5)
    mathOnList(numList2, multiply2)



}
    /*fun nextTwo(num: Int): Pair<Int, Int>{
        return Pair(num+1, num+2)
    }*/
    fun getSum(vararg nums: Int): Int{
        var sum = 0
        nums.forEach{n -> sum += n}
        return sum
    }
    //factorial recursion
    fun fact(x: Int): Int{
        tailrec fun factTail(y: Int, z: Int): Int {
            if(y == 0) return z
            else return factTail(y - 1, y * z)
        }
        return factTail(x, 1)
    }

    //function that creates a function

    fun makeMathFunc(num1: Int): (Int) -> Int = {num2 -> num1 * num2}

    fun mathOnList(numList: Array<Int>, myFunc: (num: Int) -> Int){
        for(num in numList){
            println("MathOnList ${myFunc(num)}")
        }
    }

    fun MathFunc(num1: Int: (Int) -> Int = {num2 -> num1 -num2}














