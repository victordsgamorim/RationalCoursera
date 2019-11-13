package rationals

fun main() {

    val half = 1 divBy 2
    val third = 1 divBy 3

    println("------ sum -------")
    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    println("------ diff -------")
    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    println("------ times -------")
    val product: Rational = half * third
    println(1 divBy 6 == product)

    println("------ quotient -------")
    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    println("------ minus -------")
    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println("------ string -------")
    println((2 divBy 1).toString() == "2")

    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)


    println(half in third..twoThirds)

    println("5670711258187766016096/1017819969418316977248".toRational())

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)

}







