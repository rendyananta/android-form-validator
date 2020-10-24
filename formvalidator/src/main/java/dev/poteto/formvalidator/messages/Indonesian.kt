package dev.poteto.formvalidator.messages

import dev.poteto.formvalidator.contracts.ValidationMessages

object Indonesian : ValidationMessages {

    /**
     * @return the error messages of required field
     */
    override fun required(): String = "Harus diisi"

    /**
     * @param min characters needed
     * @return error messages of field with minimal characters
     */
    override fun charactersMin(min: Int): String = "Jumlah karakter minimal $min"

    /**
     * @param max characters limit
     * @return error message of field with max characters exceed
     */
    override fun charactersMax(max: Int): String = "Jumlah karakter tidak boleh melebihi $max"

    /**
     * @param min number needed
     * @return error message of field with minimal number
     */
    override fun numberMin(min: Int): String = "Angka harus lebih dari $min"

    /**
     * @param max number limit
     * @return error message of field with max number exceed
     */
    override fun numberMax(max: Int): String = "Angka tidak boleh melebihi $max"

    /**
     * @return error message of field that have invalid email
     */
    override fun email(): String = "Masukkan email dengan benar"

    /**
     * @param from [Int]
     * @param to [Int]
     * @return error message number out of range
     */
    override fun numberRange(from: Int, to: Int): String =
        "Angka harus lebih dari $from dan kurang dari $to"

    /**
     * @param from [Int]
     * @param to [Int]
     * @return error message character length out of range
     */
    override fun charactersRange(from: Int, to: Int): String =
        "Karakter harus lebih dari $from dan kurang dari $to karakter"

    /**
     * @return error message invalid phone number
     */
    override fun phone(): String = "Masukkan nomor telepon dengan benar"

    /**
     * @return error message invalid currency
     */
    override fun currency(): String = "Masukkan nominal uang dengan benar"
    /**
     * @return error message invalid date
     */
    override fun date(): String = "Masukkan tanggal dengan benar"

}