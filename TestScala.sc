134 * 7
var a = 21
val testString: String = "Hello Wordl"
var test2String = "Hello Two"
test2String = "Hellow Three"
val abs = "No Type Declaration Needed"
val firstVector = Vector(1, 2, 3, 4, 5, 6, 7)
val x = Seq(1, 2, 3, 4)
val y =  Seq(4, 5, 6)
val secondVector = firstVector.reverse
val third = firstVector.size
val q = firstVector.slice(0, 5)
val w = firstVector.tail
val e = Set(1, 2, 3, 4, 4, 4)
val l = List(1, 2, 3, 4)
e.take(2)
//These two are the same
e contains 1
e(1)
//Adding two sequences together
val z = x++y
//Set is not ordered and does not allow duplicates
z.toSet
val something = Seq(1, 2, 3, 4)
//adds to start of seq
44 +: something
//add to the end of a sequence
something :+ 12
//Tuples
val myT = Tuple2(1, "test")
val otherU = (1, 1.4, "Test")
val anotherT = (myT, 1.2, 40192)

anotherT._2
anotherT._1._2

//maps
val testMap = Map(1 -> "12", 2 -> "Hello", 31 ->"Check")
print(testMap.get(31))
print(testMap.getOrElse(4, "Failed\n"))

//fuctions
val testVec = Vector(1,2,3,4)
//applies transformation of +1 to each elemet, a, in the vector
//uses the .map method which acts on a collection to perform some action
//on each element in it
testVec.map(a => a + 1)
//Can be written as testVec.map((a: Int) => a + 1)
//the _ card can only be used if only one parameter is taken
//or testVec(_ + 1)

//This does the same as above
val b = (b: Int) => b + 1
testVec.map(b)

//flat map flattens the result to the underlying data strucutre. E.g. with this example it
//creates one list of characters rather than 2 arrays of the characters, as a map would do
val initSeq = Seq("First Second", "Third Fourth").flatMap(s => s.split(""))
val initSeq2 = Seq("First Second", "Third Fourth").map(s => s.split(""))

print(initSeq2(1)(3) + "\n")

//predacate
//returns any values to the new list that meet the condition given with the filter
val g = Seq(1,2,3,4,5)
g.filter(a => a < 3)






def sum(f: Int => Int, a: Int, b: Int): Int = {
  def loop(x: Int, acc: Int): Int = {
    if (x > b) acc
    else loop(x + 1, acc + f(x))
  }
  loop(a,0)
}

sum(x => x, 1, 10)






















