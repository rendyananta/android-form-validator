# Android Form Validator Library
### Library for validating forms may have many fields at once

[![Build Status](https://travis-ci.org/rendyyangasli/android-form-validator.svg?branch=master)](https://travis-ci.org/rendyyangasli/android-form-validator)
[![codebeat badge](https://codebeat.co/badges/dbc9d2b3-09aa-46e2-878b-933a85d620c9)](https://codebeat.co/projects/github-com-rendyyangasli-android-form-validator-master)
[![Known Vulnerabilities](https://snyk.io/test/github/rendyyangasli/android-form-validator/badge.svg?targetFile=formvalidator%2Fbuild.gradle)](https://snyk.io/test/github/rendyyangasli/android-form-validator?targetFile=formvalidator%2Fbuild.gradle)

## Sample

![](asset/demo.gif)

#### Code 
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
 * Using jcenter 
 Add this line into your app build.gradle
```
implementation 'dev.poteto:formvalidator:0.0.9'
```

 * Using jitpack repository
 Add this the code into your project build.gradle 
```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
Then  add this into your app build.gradle
```
implementation 'com.github.rendyyangasli:android-form-validator:0.0.9'
```


### Usage
##### Default Usage

You must invoke method `buildRulesFor()` in one statement only.

``` 
// Create the validator instance
val validator = Validator(INDONESIAN) 
// Use this argument if you prefer using indonesian message over english error message
// You can left the argument empty, it will using english error message as default

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
> If you are not passing the DataType parameter, the `STRING` **will be used as a default** DataType

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

##### Custom Validation Rule
If you need to write your own validation rules, then you can invoke `customRule()` method then implements the `ValidationRule` interface members

```
validator.buildRulesFor(field)
    .required()
    .customRule(object : ValidationRule {
        override fun check(): Boolean {
            return field1.text == field2.text
        }
        
        override fun getMessage(): String {
            return "value for field 1 must be the same with field 2"
        }
    })

```

##### Custom Error Callback
```
validator.buildRulesFor(string)
    .required()
    .onError { msg -> 
        Toast.make(context, msg, Toast.LENGTH_SHORT).show()
    }
```

##### Custom Error Messages 
It's so easy for you to customize the error message, you just need to create object and implement the `ValidationMessages` interface, then you should calling it when creating the `Validator` instance. e.g 
```
val customMessage = object : ValidationMessages {
    // you must implement the methods defined there
}

val validator = Validator(customMessage)
```
Then you will be able to use the validator as usually with customized error messages. this is very useful when you're creating multilinguism app

###### Available Error Messages Languages
* English (default)
* Indonesian (`INDONESIAN`)
> **We need help to supporting another language**

##### Available Validation Rules
* `required()` mark the field as required
* `validEmail()` to checking email
* `min(minimalValue)` to checking minimal value 
* `max(maximalValue)` to limit the user input
* `range(min, max)` range user input, can be as characters or integer
* `phone()` to check user input is match with phone number format

### Milestones
Check the [issues](https://github.com/rendyyangasli/android-form-validator/issues)