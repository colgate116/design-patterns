interface DataStructure {
    var size: Int
    fun set(index: Int, value: Int)//замена элеиента
    fun get(index:Int): Int//чтение элемента
    fun putFirst(value:Int)//добавление в начало
    fun plus(value: Int)//добавление в конец
    fun put(index: Int, value: Int)//добавление элемента в произвольном месте
    fun remove(index: Int)//удаление в произвольном месте
    fun removeLast()//удаление последнего элемента
    fun removeFirst()//удаление первого элемента
    override fun toString(): String
}