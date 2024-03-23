/**
Добавление в конец - O(1)*, O(n) при нехватке емкости массива
Добавление в начало - O(n)
Удаление с конца - O(1)
Удаление с начала - O(n)
Вставка элемента - O(n)
Удаление в промежутке - O(n)
Доступ к элементу - O(1)
Замена элемента - O(1)
**/

class Vector(private var capacity: Int = 10): DataStructure{
    private var vector = IntArray(capacity)
    override var size = 0

    private fun emptyArrayCheck(){
        if (capacity==0){
            vector = IntArray(1)
            capacity++
            size=capacity
        }
    }

    private fun capacityIncrease(){
        emptyArrayCheck()
        if (size>=capacity){
            capacity*=2
            vector = vector.copyOf(capacity)
        }
    }

    private fun indexValidation(index: Int){
        if (index>=size || index<0)
            throw IndexOutOfBoundsException()
    }

    //O(1)*
    override fun plus(value: Int){
        capacityIncrease()
        size++
        vector[size-1] = value
    }

    //O(1)
    override fun get(index: Int): Int{
        indexValidation(index)
        return vector[index]
    }

    //O(n)
    override fun putFirst(value: Int) {
        capacityIncrease()
        size++
        var el: Int = vector[0]
        for (i in 0..size-2){
            val el1 = vector[i+1]
            vector[i+1] = el
            el = el1
        }
        vector[0] = value
    }

    //O(1)
    override fun set(index: Int, value: Int){
        indexValidation(index)
        vector[index] = value
    }

    //O(n)
    override fun put(index: Int, value: Int){
        indexValidation(index)
        capacityIncrease()
        size++
        var el: Int = vector[index]
        for (i in index..size-2){
            val el1 = vector[i+1]
            vector[i+1] = el
            el = el1
        }
        vector[index] = value
    }

    //O(1)
    override fun removeLast(){
        if (size>0)
            size--
        else
            throw IndexOutOfBoundsException()
    }

    //O(n)
    override fun removeFirst() {
        if (size>0){
            size--
            var el: Int = vector[size]
            for (i in size downTo 1){
                val el1 = vector[i-1]
                vector[i-1] = el
                el = el1
            }
        }
        else
            throw IndexOutOfBoundsException()
    }

    //O(n)
    override fun remove(index: Int){
        indexValidation(index)
        size--
        var el: Int = vector[size]
        for (i in size downTo index+1){
            val el1 = vector[i-1]
            vector[i-1] = el
            el = el1
        }

    }

    fun ensureCapacity(cap: Int){
        capacity = cap
        vector = vector.copyOf(cap)
    }

    fun trimToSize(){
        capacity = size
        vector = vector.copyOf(size)
    }

    override fun toString(): String {
        //вывод относительно логичского размера массива +
        // относительно физического размера массива
        return vector.slice(0..<size).joinToString() + "\n" +
                vector.contentToString()+"\n"
    }
}