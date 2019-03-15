package dev.poteto.formvalidator.contracts

import dev.poteto.formvalidator.DataType

/**
 * Abstract Class for validation rule
 * All rules must extend this class
 * @constructor apply target and message
 * @property target [CharSequence] to be validated
 * @property message [ValidationMessages] object
 * @property type [DataType] data type to be validated
 */
abstract class ValidationRule(
    protected val target: CharSequence?,
    protected val messages: ValidationMessages,
    protected val type: DataType = DataType.STRING
) {

    /**
     * Validation check implementation,
     * this method should use to comparing things,
     * or many other you may need to validate the CharSequence inputs
     * @return the boolean result of checking implementation
     */
    abstract fun check(): Boolean

    /**
     * @return the messages should be shown if validation fails
     */
    abstract fun getMessage(): String

}