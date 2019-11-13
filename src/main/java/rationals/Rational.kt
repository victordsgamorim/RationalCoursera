package rationals

import java.math.BigInteger

data class Rational(
        val numerator: BigInteger,
        val denominator: BigInteger = BigInteger.valueOf(1)
) : Comparable<Rational> {

    override fun compareTo(other: Rational): Int {
        val primaryNumeratorFloat = this.numerator.toFloat()
        val primaryDenominatorFloat = this.denominator.toFloat()
        val primaryFractionResult = primaryNumeratorFloat.div(primaryDenominatorFloat)

        val secundaryNumeratorFloat = other.numerator.toFloat()
        val secundaryDenominatorFloat = other.denominator.toFloat()
        val secundaryFracitonResult = secundaryNumeratorFloat.div(secundaryDenominatorFloat)
        return primaryFractionResult.compareTo(secundaryFracitonResult)
    }


    private fun calcNumeratorAndDenominator(other: Rational): Triple<BigInteger, BigInteger, BigInteger> {
        val totalDenominator = this.denominator.times(other.denominator)

        val newPrimaryNumerator = totalDenominator.div(this.denominator).times(this.numerator)
        val newSecundaryNumerator = totalDenominator.div(other.denominator).times(other.numerator)

        return Triple(newPrimaryNumerator, newSecundaryNumerator, totalDenominator)
    }

    operator fun plus(other: Rational): Rational {
        val (primaryNumerator, secundaryNumerator, denominator)
                = calcNumeratorAndDenominator(other)

        val totalNumerator = primaryNumerator.plus(secundaryNumerator)

        val rational = Rational(numerator = totalNumerator,
                denominator = denominator)

        return factorFraction(rational)
    }

    operator fun minus(other: Rational): Rational {
        val (primaryNumerator, secundaryNumerator, denominator)
                = calcNumeratorAndDenominator(other)
        val totalNumerator = primaryNumerator.minus(secundaryNumerator)

        val rational = Rational(numerator = totalNumerator,
                denominator = denominator)

        return factorFraction(rational)
    }

    operator fun times(other: Rational): Rational {
        val totalDenominator = this.denominator.times(other.denominator)
        val numerator = this.numerator.times(other.numerator)

        val rational = Rational(numerator = numerator,
                denominator = totalDenominator)


        return factorFraction(rational)
    }

    operator fun div(other: Rational): Rational {
        val denominator = this.denominator.times(other.numerator)
        val numerator = this.numerator.times(other.denominator)

        return Rational(numerator = numerator,
                denominator = denominator)
    }


    operator fun unaryMinus() = Rational(this.numerator.negate(), this.denominator)


    operator fun unaryPlus() = Rational(this.numerator, this.denominator)


    operator fun contains(range: ClosedRange<Rational>): Boolean {
        return this in range
    }

    override fun toString(): String {
        if (denominator == BigInteger.ONE) return "$numerator"
        return "$numerator/$denominator"
    }


}