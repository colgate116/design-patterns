fun main() {
    val array = Vector(2)
    for (i in 0..10){
        array.plus(i)
    }
    println(array)
    array.remove(0)
    println(array)
    for (i in 10..15) {
        array.put(10, 3)
        println(array)
    }

    for (i in 0..15)
        array.removeLast()
    array.plus(4)
    println(array)
    println(array.size)

}

class Vector(private var capacity: Int = 2){
    private var vector = IntArray(capacity)
    var size = 0

    private fun capacityIncrease(){
        size++
        if (size>capacity){
            capacity*=2
            vector = vector.copyOf(capacity)
        }
    }

    private fun indexValidation(index: Int){
        if (index>size || index<0)
            throw IndexOutOfBoundsException()
    }

    fun plus(value: Int){
        capacityIncrease()
        vector[size-1] = value
    }

    fun get(index: Int): Int{
        indexValidation(index)
        return vector[index]
    }

    fun set(index: Int, value: Int){
        indexValidation(index)
        capacityIncrease()
        vector[index] = value
    }

    fun put(index: Int, value: Int){
        indexValidation(index)
        capacityIncrease()
        var el: Int = vector[index]
        for (i in index..size-2){
            val el1 = vector[i+1]
            vector[i+1] = el
            el = el1
        }
        vector[index] = value
    }

    fun removeLast(){
        size--
        if (size>0)
            vector[size-1] = vector[size]
    }

    fun remove(index: Int){
        indexValidation(index)
        size--
        var el: Int = vector[size]
        for (i in size downTo index+1){
            val el1 = vector[i-1]
            vector[i-1] = el
            el = el1
        }

    }

    override fun toString(): String {
        //вывод относительно логичского размера массива
        return vector.slice(0..<size).joinToString()

    //вывод относительно физического размера массива
        //return vector.contentToString()
    }
}