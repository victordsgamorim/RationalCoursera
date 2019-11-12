package rationals

fun main() {

    var rational = "117/1098".toRational()


}

infix fun Int.div(d: Int): Rational {

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

    return Rational(num, den)
}



