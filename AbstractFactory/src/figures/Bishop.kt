package figures

import AbstractChessBoard
import Side

abstract class Bishop(abstractChessBoard: AbstractChessBoard) : Figure(abstractChessBoard) {
    override var position: Pair<Char, Int> = getFigurePosition()

    override fun move(newPosition: Pair<Char, Int>) {
        if (beAbleToMove(newPosition)){
            println()
        }
        else
            throw Exception("Данная клетка недоступна для хода")
    }

    override fun attack(newPosition: Pair<Char, Int>) {
        TODO("Not yet implemented")
    }

    override fun beAbleToMove(position: Pair<Char, Int>): Boolean {
        return true
    }

    override fun beAbleToAttack(position: Pair<Char, Int>): Boolean {
        return true
    }
}

class AttackBishop(abstractChessBoard: AbstractChessBoard): Bishop(abstractChessBoard) {
    override val side: Side = Side.ATTACK
    override val skin: Char = '♝'
}

class ProtectionBishop(abstractChessBoard: AbstractChessBoard): Bishop(abstractChessBoard) {
    override val side: Side = Side.PROTECTION
    override val skin: Char = '♗'
}
