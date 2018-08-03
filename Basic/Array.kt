fun PrintArray(arr:Array<Int>) {
    for(element in arr) {
        println(element)
    }
}
fun PrintArrayUsingGet(arr:Array<Int>) {
    for (idx in 0..arr.size-1) {
        println(arr.get(idx))
    }
}

fun main(args : Array<String>) {
    var arrayInt = Array<Int>(5){0}
    PrintArray(arrayInt)

    for(idx in 0..arrayInt.size-1) {
        arrayInt[idx]=idx+1
    }
    PrintArray(arrayInt)

    for(idx in 0..arrayInt.size-1) {
        arrayInt.set(idx,10)
    }
    PrintArrayUsingGet(arrayInt)
}