fun main(args : Array<String>) {
    var arrayInt = Array<Int>(5){0}

    for(element in arrayInt) {
        println(element)
    }

    for(idx in 0..4) {
        arrayInt[idx]=idx+1
    }

    for(element in arrayInt) {
        println(element)
    }
}