package dev.poteto.formvalidator.messages

import dev.poteto.formvalidator.contracts.ValidationMessages

/**
 * Implementation of ValidationMessages Interface
 * Used for defining your message
 */
object DefaultMessage : ValidationMessages {

    /**
     * @return the error messages of required field
     */
    override fun required(): String = "Field is required"

    /**
     * @param min characters needed
     * @return error messages of field with minimal characters
     */
    override fun charactersMin(min: Int): String = "Characters must less than $min character"

    /**
     * @param max characters limit
     * @return error message of field with max characters exceed
     */
    override fun charactersMax(max: Int): String = "Characters must more than $max character"

    /**
     * @param min number needed
     * @return error message of field with minimal number
     */
    override fun numberMin(min: Int): String = "Number must be more than $min"

    /**
     * @param max number limit
     * @return error message of field with max number exceed
     */
    override fun numberMax(max: Int): String = "Number must less than $max"

    /**
     * @return error message of field that have invalid email
     */
    override fun email(): String = "Enter valid email address"

    /**
     * @param from [Int]
     * @param to [Int]
     * @return error message number out of range
     */
    override fun numberRange(from: Int, to: Int): String =
        "Number must start $from and less than $to"

    /**
     * @param from [Int]
     * @param to [Int]
     * @return error message character length out of range
     */
    override fun charactersRange(from: Int, to: Int): String =
        "Characters must more than $from and less than $to character"

    /**
     * @return error message invalid phone number
     */
    override fun phone(): String = "Enter valid phone number"

    override fun currency(): String = "Enter valid currentcy"

    override fun date(): String = "Masukkan tanggal dengan benar"
}