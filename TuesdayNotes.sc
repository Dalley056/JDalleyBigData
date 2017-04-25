val radius = 10.0
val radius2 = 10
//Specifying a variable type to override type inference
val radius3:Double = 10

//AnyVal and AnyRef inherits from Any
//def is used to define a method - these are faster than functions but
//are less usefukl as they can't be used as arguments etc and don't have
//a value. Methods can be converted to functions
def printAny(x : Any) = println(x)
def printAnyVal(y: AnyVal) = print(y)
def printAnyRef(z : AnyRef) = println(z)

//int inherits from AnyVal, List inherits from AnyRef
val SomeVal = 5
//Classes / strings / collections / arrays inherit AnyRef
val someRef = List(3,5)

//Creating complex strings
val name = "Jamie"
val greeting = "Hello"
s"$greeting $name, some random text!"
s"${greeting*2}"

//with if statements if it evaluates to false and there is no else statement then it returns
//a special value called Nothing - signals the absence of a value
val numer:Double = 22
val denom:Double = 7
//Pi is type Any as the if can return a double or None, and the first common class between them is Any
val PI = if(denom != 0) {numer/denom} else {None}

//returns Nothing
val denom2:Double = 0
val PI2 = if (denom2!=0) {numer/denom2}

//None is a value, not a type - can be created to be returned
//Nothing is not a value, can't be instantiated, so can't be returned by us. Is signalled by
//empty paranthesis

//For loop with no return value
val alpha = List("a", "b", "c", "d", "e")
for(letter <- alpha)
{
  letter match{
    case "a" => println("First Letter")
    case otherLetter => println(letter)
  }
}

//for loop with a return value
val alpha2 = for(letter <- alpha)yield
{
  letter match{
    case "a" => "First Letter"
    case otherLetter => otherLetter
  }
}
//for loop using numeric range - less used that other kind
for(i <- 0 to alpha2.size - 1){
  println(alpha2(i))
}
//works the same as above, no need to have -1 here
for(i <- 0 until alpha2.size){
  println(alpha2(i))
}

//For loop with a pattern card
for(letter <- alpha2 if letter == "b"){
  println("Second letter")
}

//Nested for loop
for {i <- 0 until alpha2.size
     j <- alpha2}
{
  println(s"$i,$j")
}

//While loops written as expected, but rarely used in Scala - avoid if possible

//Match statements (Catch)
val testString = "PH"
val stringEval = (testString: String) => testString match{
  case "JG" => "Joe Gordon"
  case "JD" => "Jamie Dalley"
  case "AV" | "AX" => "No Name"
  case otherInitial if otherInitial == "PH" | otherInitial == "PSH" => "Persephone S Hurford"
  case otherInitial => s"Name for $otherInitial not in the list"
}

stringEval("JD")
stringEval("JG")
stringEval("JD")
stringEval("AV")
stringEval("AX")
stringEval("PH")
stringEval("PSH")
stringEval("ZZ")

//Using the wildcard to achiece the same result
//Can't use the _ on the right hand side of the arrow
val stringEval2 = (testString: String) => testString match{
  case "JG" => "Joe Gordon"
  case "JD" => "Jamie Dalley"
  case "AV" | "AX" => "No Name"
  case _ => s"Name for $testString not in the list"
}

stringEval2("ZZ")

//Safe type downcast example
val typeOfValue = (toDown:Any) => toDown match{
  case toDown:Int => "Int"
  case toDown:String => "String"
  case toDown:Double => "Double"
  case _ => "No matching type"
}

val toDown:Any = 10
val toDown2:Any = 10.0
val toDown3:Any = "10.0"
val toDown4:Any = true
//if we use toDown3:String = "10.0" we get an error as it checks the string against an int and double and it
//isn't compatible

typeOfValue(toDown)
typeOfValue(toDown2)
typeOfValue(toDown3)
typeOfValue(toDown4)

//A function - takes a double and returns a double. Shows as <function1) as it takes 1 arguement
val testSomething = (test:Double) =>
{
  val something = 3.14
  something * test * test
}:Double

//A method doing the same
def testSomething2 (test:Double):Double =
{
  val something = 3.14
  something * test * test
}

//Converting a method to a function
//Specifying that the function will take a double in and give a double as output
val usedToBeMethod: (Double) => Double = testSomething2
//This is a shortcut for it using wildcard. Wildcard doesn't work with a method that returns
//a function. For this you have to use the longer way shown above. If you try to use the wild card
//way for this then it will store the nested function in the new function, rather than converting
//the method itself to a function and storing that
val alsoUsedToBeMethod = testSomething2 _

//returning a tuple from a method
val valX = 10.0

def methValX(g:Double) = {
  val PI = 3.14
  def getX1(g:Double) = PI * g * g
  def getX2(g:Double) = 2 * PI * g

  //This is the tuple
  (getX1(g),getX2(g))
}

methValX(valX)

//A higher order function has a return value which is a function or has a paramete which is a function
//This function can have a function passed in as an arguement, so it is high order
def smartTest(s1:String, s2:String, tstFn:(String, String) => Int):Int = {
  tstFn(s1,s2)
}

def forTesting(s1:String,s2:String):Int = {
  32
}

def forTesting2(s1:String,s2:String):Int = {
  64
}

//This function returns a function based on the value of the boolean passed in
def returnFunction(check:Boolean):(String,String) => Int = {
  if(check == true) forTesting
  else forTesting2
}

//Parameter default values
def paramDTest(first:Double = 6.1, x:Double, y:Double = 11.45) = {

}

//Can leave the first param to its default but must specify the name of the param we want to
//assign the value(s) we give to
paramDTest(x = 10)
paramDTest(x = 10, y = 14)

//Generics == type parameters - uses square brackets
def genericEquiv[K, V](k:K, v:V) = {
  val keyType = k.getClass
  val valueType = v.getClass
}

//Partially applied functions
//Arity = the number of arguements or operands a function takes
//e.g. F(w,x,y,z) is a Quaternary function - Arity = 4
//Here I have copied the paramDTest function but made this version have a default for the third
//param. This changes it from arity of 3 to arity of 2
val defaultParamDTest = paramDTest(_:Double,_:Double,61.0)
