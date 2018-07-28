fun main(args : Array<String>) {
    var arrayList=ArrayList<String>()

    arrayList.add("C++")
    arrayList.add("C")
    arrayList.add("C#")
    arrayList.add("Kotlin")

    println("arrayList size = ${arrayList.size}")

    println("print all items of arrayList")
    for(idx in 0..arrayList.size-1) {
        println(arrayList.get(idx))
    }

    var isIncluded=arrayList.contains("Java")
    println("is Java included? $isIncluded")
}