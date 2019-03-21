package dev.poteto.formvalidator.contracts

/**
 * Interface for saving messages,
 * this more flexible for apps with multi lang support
 */
interface ValidationMessages {

    /**
     * @return [String] required error message
     */
    fun required(): String

    /**
     * @param min [Int] characters needed to passes validation
     * @return [String] characters min error message
     */
    fun charactersMin(min: Int): String

    /**
     * @param max [Int] characters needed to passes validation
     * @return [String] characters max error message
     */
    fun charactersMax(max: Int): String

    /**
     * @param min [Int] number needed to passes validation
     * @return [String] number min error message
     */
    fun numberMin(min: Int): String

    /**
     * @param max [Int] number needed to passes validation
     * @return [String] number max error message
     */
    fun numberMax(max: Int): String

    /**
     * @return [String] invalid email error message
     */
    fun email(): String

    /**
     * @param from [Int]
     * @param to [Int]
     * @return [String] number between
     * @see from
     * @see to
     */
    fun numberRange(from: Int, to: Int): String

    /**
     * @param from [Int]
     * @param to [Int]
     * @return [String] characters length between
     * @see from
     * @see to
     */
    fun charactersRange(from: Int, to: Int): String

    /**
     * @return [String] phone error message
     */
    fun phone(): String
}