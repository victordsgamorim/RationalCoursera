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
//
//    println(2000000000L divBy 4
//
//    println("912016490186296920119201192141970416029".toBigInteger() divBy
//            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}


infix fun Int.divBy(d: Int): Rational {

    if (d == 0) return throw IllegalArgumentException("Denominator $d is equal to '0' ")
    if (d == 1) return Rational(this)

    var num = this
    var den = d

    var molTwo = num % 2 == 0 && den % 2 == 0
    var molThree = num % 3 == 0 && den % 3 == 0
    var molFive = num % 5 == 0 && den % 5 == 0

    while (molTwo || molThree || molFive) {
        when {
            molTwo -> {
                num = num.div(2)
                den = den.div(2)
                molTwo = num % 2 == 0 && den % 2 == 0
            }
            molThree -> {
                num = num.div(3)
                den = den.div(3)
                molThree = num % 3 == 0 && den % 3 == 0
            }
            molFive -> {
                num = num.div(5)
                den = den.div(5)
                molFive = num % 5 == 0 && den % 5 == 0
            }
        }
    }

    return Rational(num, den, getFractionResult(num, den))
}

fun String.toRational(): Rational {
    val split = this.split("/")

    val numerator = split[0].toInt()
    val denominator = split[1].toInt()

    return numerator.divBy(denominator)
}

fun getFractionResult(numerator: Int, denominator: Int): Float {
    return numerator.toFloat().div(denominator.toFloat())
}



