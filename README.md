## Representing concrete classes in JSON dynamically

I have an interface or abstract class that is implemented or extended and I need those concrete classes to be \
mapped to JSON dynamically. JSON mapper will dynamically determine which concrete class is handling and correctly \
parse its properties so client consuming JSON knows of only the interface or abstract class. \
Key notes:
* Interface or abstract class declares @JsonTypeInfo documenting concrete classes
    * 'property' option declares the field to be used in determining @JsonSubType