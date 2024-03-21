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

}

class Vector(private var size: Int = 2){
    private var vector = IntArray(size)
    private var currentLength = 0

    private fun capacityIncrease(){
        currentLength++
        if (currentLength>size){
            size*=2
            vector = vector.copyOf(size)
        }
    }

    private fun indexValidation(index: Int){
        if (index>currentLength || index<0)
            throw IndexOutOfBoundsException()
    }

    fun plus(value: Int){
        capacityIncrease()
        vector[currentLength-1] = value
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
        for (i in index..currentLength-2){
            val el1 = vector[i+1]
            vector[i+1] = el
            el = el1
        }
        vector[index] = value
    }

    fun removeLast(){
        currentLength--
        if (currentLength>0)
            vector[currentLength-1] = vector[currentLength]
    }

    fun remove(index: Int){
        indexValidation(index)
        currentLength--
        var el: Int = vector[currentLength]
        for (i in currentLength downTo index+1){
            val el1 = vector[i-1]
            vector[i-1] = el
            el = el1
        }

    }

    override fun toString(): String {
        //вывод относительно логичского размера массива
        //return vector.slice(0..<currentLength).joinToString()

    //вывод относительно физического размера массива
        return vector.contentToString()
    }
}