package rationals

data class Rational(
        val numerator: Int,
        val denominator: Int = 1,
        val result: Float = 0.0f) {


    private fun getDominatorMultiplication(other: Rational): Triple<Int, Int, Int> {
        val totalDenominator = this.denominator.times(other.denominator)

        val newPrimaryNumerator = totalDenominator.div(this.denominator)
        val newSecundaryNumerator = totalDenominator.div(other.denominator)

        return Triple(newPrimaryNumerator, newSecundaryNumerator, totalDenominator)
    }

    operator fun plus(other: Rational): Rational {
        val (primaryNumerator, secundaryNumerator, denominator) = getDominatorMultiplication(other)
        val totalNumerator = primaryNumerator.plus(secundaryNumerator)

        return Rational(numerator = totalNumerator,
                denominator = denominator,
                result = getFractionResult(totalNumerator, denominator))
    }

    operator fun minus(other: Rational): Rational {
        val (primaryNumerator, secundaryNumerator, denominator) = getDominatorMultiplication(other)
        val totalNumerator = primaryNumerator.minus(secundaryNumerator)

        return Rational(numerator = totalNumerator,
                denominator = denominator,
                result = getFractionResult(totalNumerator, denominator))
    }

    operator fun times(other: Rational): Rational {
        val totalDenominator = this.denominator.times(other.denominator)
        val numerator = this.numerator.times(other.numerator)
        return Rational(numerator = numerator,
                denominator = totalDenominator,
                result = getFractionResult(numerator, totalDenominator))
    }

    operator fun div(other: Rational): Rational {
        val denominator = this.denominator.times(other.numerator)
        val numerator = this.numerator.times(other.denominator)

        return Rational(numerator = numerator,
                denominator = denominator,
                result = getFractionResult(numerator, denominator))
    }

    operator fun unaryMinus() = Rational(-this.numerator, this.denominator, -getFractionResult(this.numerator, this.denominator))

    operator fun compareTo(other: Rational): Int {
        val primaryNumeratorFloat = this.numerator.toFloat()
        val primaryDenominatorFloat = this.denominator.toFloat()
        val primaryFractionResult = primaryNumeratorFloat.div(primaryDenominatorFloat)

        val secundaryNumeratorFloat = other.numerator.toFloat()
        val secundaryDenominatorFloat = other.denominator.toFloat()
        val secundaryFracitonResult = secundaryNumeratorFloat.div(secundaryDenominatorFloat)
        return primaryFractionResult.compareTo(secundaryFracitonResult)
    }

    operator fun contains(contain: Rational): Boolean {
        return this in contain
    }


    override fun toString(): String {
        if (denominator == 1) return "$numerator"
        return "$numerator/$denominator"
    }


}