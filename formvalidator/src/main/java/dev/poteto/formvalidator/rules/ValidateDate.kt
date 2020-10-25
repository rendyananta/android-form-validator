package dev.poteto.formvalidator.rules

import dev.poteto.formvalidator.DataType
import dev.poteto.formvalidator.contracts.PredefinedValidationRule
import dev.poteto.formvalidator.contracts.ValidationMessages
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Class for validating Date
 * @param target inherit
 * @param messages inherit
 * @param type inherit
 */
class ValidateDate(
    val format:String,
    target: CharSequence?,
    messages: ValidationMessages,
    type: DataType
) : PredefinedValidationRule(target, messages, type) {

    /**
     * Check the date is valid or not with regex method
     */
    override fun check(): Boolean {
        val dateFormat = SimpleDateFormat(format)
        dateFormat.setLenient(false)
        try {
            dateFormat.parse(target.toString().trim { it <= ' ' })
        } catch (pe: ParseException) {
            return false
        }
        return true
    }

    /**
     * @return message when validation fails
     */
    override fun getMessage(): String = messages.date()
}