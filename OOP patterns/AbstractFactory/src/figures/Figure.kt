package figures

import AbstractChessBoard
import Side

abstract class Figure(val abstractChessBoard: AbstractChessBoard) {
    protected abstract val side: Side
    protected abstract val skin: Char
    protected abstract var position: Pair<Char, Int>
    private var alive: Boolean = true

    abstract fun move(newPosition: Pair<Char, Int>)
    abstract fun attack(newPosition: Pair<Char, Int>)
    fun setFigurePosition(position: Pair<Char, Int>){
        this.position = position
    }

    abstract fun beAbleToMove(position: Pair<Char, Int>): Boolean
    abstract fun beAbleToAttack(position: Pair<Char, Int>):Boolean

    fun getFigureSide(): Side{
        return side
    }

    fun getFigurePosition(): Pair<Char, Int>{
        return position
    }

    fun killed(){
        alive = false
    }

    fun isAlive(): Boolean{
        return alive
    }

    fun getFigureSkin():Char{
        return skin
    }
}
