fun main(args : Array<String>) {
    var str = "String "
    println(str)

    str = str + "Example"
    println(str)

    println(str.length)

    str.toUpperCase()
    println(str)

    str.toLowerCase()
    println(str)

    var splitResult = str.split(" ")
    println(splitResult)

    println(str.equals("String Example"))
}