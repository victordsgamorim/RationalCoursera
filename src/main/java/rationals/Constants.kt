package rationals

import java.math.BigInteger

infix fun <T : Number> T.divBy(d: T): Rational {

    val num = this.toString()
    val den = d.toString()

    val numerator = num.toBigInteger()
    val denominator = den.toBigInteger()

    if (d == 0) return throw IllegalArgumentException("Denominator $d is equal to '0' ")
    if (d == 1 && numerator > BigInteger.ZERO) return Rational(num.toBigInteger().abs())

    val rational = if (numerator < BigInteger.ZERO && denominator < BigInteger.ZERO) {
        +createRational(num, den)
    } else if (numerator < BigInteger.ZERO || denominator < BigInteger.ZERO) {
        -createRational(num, den)
    } else {
        createRational(num, den)
    }

    return factorFraction(rational)
}

private fun createRational(num: String, den: String): Rational {
    return Rational(
            num.toBigInteger().abs(),
            den.toBigInteger().abs())
}

fun String.toRational(): Rational {
    val split = this.split("/")

    val numerator = split[0]
    val denominator = if (split.size > 1) split[1] else "1"

    return BigInteger(numerator) divBy BigInteger(denominator)
}

fun String.toBigInteger(): BigInteger {
    return BigInteger(this)
}

fun highestCommonFactor(numerator: BigInteger, denominator: BigInteger): BigInteger =
        if (denominator != 0.toBigInteger()) highestCommonFactor(denominator, numerator % denominator) else numerator

fun factorFraction(rational: Rational): Rational {
    val highestCommonFactor = highestCommonFactor(rational.numerator, rational.denominator).abs()
    val numerator = rational.numerator.div(highestCommonFactor)
    val denominator = rational.denominator.div(highestCommonFactor)
    return Rational(numerator, denominator)
}
