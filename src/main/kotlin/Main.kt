fun main(args: Array<String>) {
    var j:Int=10
    for (i in 1..j step 2){
        println(i)
    }
    for (i in j downTo 1 step 2 ){
        println(i)
    }

    val array = arrayOf("a","b","c")
    for (i in 0 until array.size){    //а не (i in 0 .. array.size)  чтобы не выходить за рамки
                                            //т.е. брать исключительно, а не включительно
        print(array[i])
    }
    for (element in array){
        print(element)
    }

    //Хорошо, а что если вам нужен как элемент, так и индекс? Можно написать цикл с индексом и
    //брать элемент, но в котлин продумали более элегантный способ
    for ((index,value) in array.withIndex()){
        println("индекс $index значение $value")
    }
    breakFromLoop(2,2)
    doSome(4)
    println("end")
    doSomeArrayForEach(2, arrayOf(1,2,3,4,5,6))
    testWhile(2)
    printArray()
}

fun breakFromLoop(I:Int,J:Int){
    loop@for (i in 0..I){
        println("i:$i")
        for (j in 0..J){
            println("j:$j")
            if (j==1)
                break@loop
        }
    }
}

fun doSome(max:Int){
    for (i in 0..max){
        if (i==3)
            return
    }
    println("done")
}

fun doSomeArrayForEach(max: Int, array: Array<Int>){
    array.forEach {
        if (it ==max)
            return@forEach
    }
    print("done")
}

fun testWhile(varForBreak:Int){
    var x=0
    loop@while(true){
        println("main")
        while (true){
            println("Inner")
            if (x==varForBreak)
                break@loop
            x++
        }
    }
}

fun printArray(){
    val array = Array(5){i->i*i}
    val arrayZero =Array(5){ 0 }
    val arrayOfAnyTypes = arrayOf(1,"2","3",4)
    arrayOfAnyTypes.forEach {
        if (it is String)
            println(it)
    }
    arrayOfAnyTypes.plus("new").forEach {
        if (it is String)
            println(it)
    }
    arrayOfAnyTypes.forEachIndexed{
        index, data ->
        if (data is String)
            println(index)
        if (index==2) println(20)
    }
    arrayZero[2]=1
    array.forEach { print(it) }
    arrayZero.forEach { print(it) }
}