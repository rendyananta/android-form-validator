package dev.poteto.formvalidator.contracts

import dev.poteto.formvalidator.DataType

/**
 * Abstract Class for validation rule
 * All rules must extend this class
 * @constructor apply target and message
 * @property target [CharSequence] to be validated
 * @property messages [ValidationMessages] object
 * @property type [DataType] data type to be validated
 */
abstract class PredefinedValidationRule(
    protected val target: CharSequence?,
    protected val messages: ValidationMessages,
    protected val type: DataType = DataType.STRING
) : ValidationRule