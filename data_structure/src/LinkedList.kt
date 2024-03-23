/**
 * Односвязный список
Добавление в конец - O(1)
Добавление в начало - O(1)
Удаление с конца - O(n)
Удаление с начала - O(1)
Вставка элемента - O(n)
Удаление в промежутке - O(n)
Доступ к элементу - O(n)
Замена элемента - O(n)
 **/
open class SingleLinkedList: DataStructure{
     protected open inner class Node(var value: Int){
        var next: Node? = null
        var prev: Node? = null
    }

    protected fun indexValidation(index: Int){
        if (index>=size || index<0)
            throw IndexOutOfBoundsException()
    }

    protected open var head: Node? = null

    protected open var tail: Node? = null

    override var size: Int = 0

    protected fun getNode(index: Int):Node{
        indexValidation(index)
        var node  = head
        for (i in 0..<index)
            node = node?.next
        return node?: throw NullPointerException()
    }

    //O(n)
    override fun set(index: Int, value: Int) {
        getNode(index).value = value
    }

    //O(n)
    override fun get(index: Int): Int {
        return getNode(index).value
    }

    //O(1)
    override fun putFirst(value: Int) {
        size++
        val node = Node(value)
        node.next = head
        head = node
        if (tail==null)
            tail = node
    }

    //O(1)
    override fun plus(value: Int) {
        size++
        val node = Node(value)
        if (head == null)
            head = node
        if (tail != null)
            tail?.next = node
        tail = node
    }

    //O(n)
    override fun put(index: Int, value: Int) {
        size++
        indexValidation(index)
        val nodePushed = Node(value)
        when (index){
            0->putFirst(value)
            size-1->plus(value)
            else->{
                size++
                val node = getNode(index-1)
                nodePushed.next = node.next
                node.next = nodePushed
            }
        }
        size--
    }

    //O(n)
    override fun remove(index: Int) {
        indexValidation(index)
        when (index) {
            0 -> removeFirst()
            size-1 -> removeLast()
            else -> {
                size--
                val node = getNode(index-1)
                node.next = node.next?.next
            }
        }
    }

    //O(n)
    override fun removeLast() {
        if (tail==null)
            throw IndexOutOfBoundsException()
        size--
        if (head==tail){
            head = null
            tail = null
        }
        else{
            var node = head
            while (node?.next !=tail)
               node = node?.next
            node?.next = null
            tail = node
        }
    }

    //O(1)
    override fun removeFirst() {
        if (head == null)
            throw IndexOutOfBoundsException()
        size--
        if (head==tail){
            head = null
            tail = null
        }
        else{
            val node = head
            head = node?.next
        }
    }

    override fun toString(): String {
        val array = mutableListOf<Int>()
        var currentNode = head
        while (currentNode!=null){
            array+=currentNode.value
            currentNode = currentNode.next
        }
        return array.toString()
    }
}

/**
 * Двухcвязный список
Добавление в конец - O(1)
Добавление в начало - O(1)
Удаление с конца - O(1)
Удаление с начала - O(1)
Вставка элемента - O(n)
Удаление в промежутке - O(n)
Доступ к элементу - O(n)
Замена элемента - O(n)
 **/

class LinkedList: SingleLinkedList(){
    //O(1)
    override fun plus(value: Int) {
        size++
        val node = Node(value)
        if (head == null)
            head = node
        if (tail != null){
            node.prev = tail
            tail?.next = node
        }
        tail = node
    }

    //O(1)
    override fun putFirst(value: Int) {
        super.putFirst(value)
        head?.next?.prev = head
    }

    //O(n)
    override fun put(index: Int, value: Int) {
        size++
        indexValidation(index)
        val nodePushed = Node(value)
        when (index){
            0->putFirst(value)
            size-1->plus(value)
            else->{
                size++
                val node = getNode(index-1)
                nodePushed.next = node.next
                nodePushed.prev = node
                node.next?.prev = nodePushed
                node.next = nodePushed
            }
        }
        size--
    }

    //O(n)
    override fun remove(index: Int) {
        indexValidation(index)
        when (index) {
            0 -> removeFirst()
            size-1 -> removeLast()
            else -> {
                size--
                val node = getNode(index-1)
                node.next = node.next?.next
                node.next?.prev = node
            }
        }
    }

    //O(1)
    override fun removeLast() {
        if (tail==null)
            throw IndexOutOfBoundsException()
        size--
        if (head==tail){
            head = null
            tail = null
        }
        else{
            val node = tail?.prev
            node?.next = null
            tail = node
        }
    }

    //O(1)
    override fun removeFirst() {
        super.removeFirst()
        head?.prev = null
    }
}