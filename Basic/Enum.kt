enum class Direction {
    NORTH,SOUTH,EAST,WEST
}

fun main(args:Array<String>) {
    var userDirect=Direction.SOUTH

    if(userDirect==Direction.SOUTH) {
        println("South")
    }
    else if(userDirect==Direction.NORTH) {
        println("North")
    }
    else if(userDirect==Direction.EAST) {
        println("East")
    }
    else if(userDirect==Direction.WEST) {
        println("West")
    }
    else {
        println("Nothing")
    }
}