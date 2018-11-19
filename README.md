# Temperature Converter Android App by Jesus Partal
This android app convertes temperatures from Celsius to Fahrenheit and viceversa. It also allows to send the conversion by email

### List of classes:
- MainActivity: this is our main activity; there is an EditText view so user can enter the temperature to be converted. Also contains two radio buttons to select the type of scale the temperature entered by the user is. A convert button will start the activity ResultsActivity
- ResultsActivity: this is the results activity; shows the conversion performed and includes a Share button to send by email the conversion
- Temperature: this class creates Temperature objects and contains two methods to convert to Celsius or Fahrenheit
