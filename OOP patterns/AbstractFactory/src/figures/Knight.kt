package figures

import AbstractChessBoard
import Side

abstract class Knight(abstractChessBoard: AbstractChessBoard) : Figure(abstractChessBoard) {
    override var position: Pair<Char, Int> = getFigurePosition()

    override fun move(newPosition: Pair<Char, Int>) {
        TODO("Not yet implemented")
    }

    override fun beAbleToMove(position: Pair<Char, Int>): Boolean {
        TODO("Not yet implemented")
    }

    override fun beAbleToAttack(position: Pair<Char, Int>): Boolean {
        TODO("Not yet implemented")
    }
}

class AttackKnight(abstractChessBoard: AbstractChessBoard) : Knight(abstractChessBoard) {
    override val skin: Char = '♞'
    override val side: Side = Side.ATTACK

    override fun attack(newPosition: Pair<Char, Int>) {
        TODO("Not yet implemented")
    }
}

class ProtectionKnight(abstractChessBoard: AbstractChessBoard) : Knight(abstractChessBoard){
    override val skin: Char = '♘'
    override val side: Side = Side.PROTECTION

    override fun attack(newPosition: Pair<Char, Int>) {
        TODO("Not yet implemented")
    }
}