# Android Form Validator Library
### Library for validating forms may have many fields at once

[![Build Status](https://travis-ci.org/rendyyangasli/android-form-validator.svg?branch=master)](https://travis-ci.org/rendyyangasli/android-form-validator)

## Sample

![](asset/demo.gif)

* Code 
```
class MainActivity : AppCompatActivity() {

    private val validator = Validator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            if (formsValidated()) {
                // Do your magic
            }
        }
    }

    private fun formsValidated(): Boolean {
        validator.buildRulesFor(field)
            .required()
            .min(15)
            .build()

        validator.buildRulesFor(field2)
            .required()
            .max(5)
            .validEmail()
            .onError {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }

        return validator.check()
    }
}
```

## Getting Started
### Installation

##### Adding into your project
 * Using maven repository
 Add this line into your app build.gradle
```
implementation 'dev.poteto:formvalidator:0.0.2'
```

### Usage
##### Default Usage

You must invoke method `buildRulesFor()` in one statement only.

``` 
// Create the validator instance
val validator = Validator()

// Find your views with traditional way
val editText = findViewById<EditText>(R.id.field1)
validator.buildRulesFor(editText)
    .required()
    .min(10)
        
// Or you prefer for using kotlin views extension
validator.buildRulesFor(field1, DataType.INT)
    .required()
    .min(10)

// Then check your all forms 
if (validator.check()) {
    // Then do your magic
}
```

> DataType is an enum class for `DataType.STRING` and `DataType.INT` type 
> If you aren't passing the DataType parameter, the `STRING` **will be used as a default** DataType

Or if you not want to invoke `buildRulesFor()` per statement, you can chain all the validation rules, you can invoke the `build()` method, then build your validation rules again
Example using the `build()` method 

```
val validator = Validator();
validator.buildRulesFor(editText1)
    .required()
    .min(10)
    .build() // Your rules validation has been reset here
    .buildRulesFor(editText2) 
    .required()
    .build()
``` 

> `buildRulesFor()` method just only accept 2 types of validation, i.e `CharSequence` and `EditText`

Passing EditText into the first parameter will automatically setting the error message for you. If you wrap your EditText inside TextInputLayout, it will automatically setting the error message into your TextInputLayout instead of EditText. Yeahhh :)) 

Then, passing CharSequence will not show your errors into the views. you must invoke `onError` lamda to catch the error.


#### Custom Error Callback
```
validator.buildRulesFor(string)
    .required()
    .onError { msg -> 
        Toast.make(context, msg, Toast.LENGTH_SHORT).show()
    }
```

### Custom Error Messages 
It's so easy for you to customize the error message, you just need to create object and implement the `ValidationMessages` interface, then you should calling it when creating the `Validator` instance. e.g 
```
val customMessage = object : ValidationMessages {
    // you must implement the methods defined there
}

val validator = Validator(customMessage)
```
Then you will be able to use the validator as usually with customized error messages. this is very useful when you're creating multilinguism app
> Default error message is Indonesian, for English error message support, it will added soon. And we will make it as a default language. **We need help to supporting another language**

### Available Validation Rules
* `required()` mark the field as required
* `validEmail()` to checking email
* `min(minimalValue)` to checking minimal value 
* `max(maximalValue)` to limit the user input
* `range(min, max)` range user input, can be as characters or integer

### Milestones
Check the [issues](https://github.com/rendyyangasli/android-form-validator/issues)