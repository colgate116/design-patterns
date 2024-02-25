package figures

import AbstractChessBoard
import Side

abstract class Pawn(abstractChessBoard: AbstractChessBoard): Figure(abstractChessBoard) {
    var firstMove = true
    abstract fun convertToMainFigure(figure: Figure)
    override var position: Pair<Char, Int>? = getFigurePosition()

    override fun beAbleToMove(position: Pair<Char, Int>): Boolean {
        return abstractChessBoard.isCellEmpty(position)
    }
}

class AttackPawn(abstractChessBoard: AbstractChessBoard) : Pawn(abstractChessBoard) {
    override val skin: Char = '♟'
    override val side: Side = Side.ATTACK

    override fun convertToMainFigure(figure: Figure) {
        this.setFigurePosition(null)
    }
    override fun beAbleToAttack(position: Pair<Char, Int>): Boolean {
        return !abstractChessBoard.isCellEmpty(position) &&
                abstractChessBoard.getCellCondition(position)?.getFigureSide()==Side.PROTECTION
    }
    override fun move(newPosition: Pair<Char, Int>){
        if (getFigurePosition()==null){
            throw Exception("Пешка находится вне шахматной доски")
        }
        if (!beAbleToMove(newPosition)) {
            throw Exception("Данная клетка недоступна для хода")
        }
        if ((position?.first != newPosition.first)||(position?.second!!>=newPosition.second)) {
            throw Exception("Пешка не может так ходить")
        }
        when{
            newPosition.second == (position!!.second + 1) -> {
                setFigurePosition(newPosition)
            }
            (newPosition.second == (position!!.second + 2)) && firstMove -> setFigurePosition(newPosition)
            else -> throw Exception("Пешка не может так ходить")
        }
        if (firstMove){
            firstMove = false
        }
        convertToMainFigure(AttackKnight(abstractChessBoard))
    }
    override fun attack(newPosition: Pair<Char, Int>) {
        if (getFigurePosition()==null){
            throw Exception("Пешка находится вне шахматной доски")
        }
        if (!beAbleToAttack(newPosition)){
            throw Exception("Данная клетка недоступна для атаки")
        }
        if ((position!!.second+1!=newPosition.second)&&(position?.first==newPosition.first)){
            throw Exception("Пешка не может так атаковать")
        }
        when (newPosition.first.toInt()){
            position!!.first.toInt() +1 -> {
                abstractChessBoard.getCellCondition(newPosition)?.killed()
                setFigurePosition(newPosition)
            }
            position!!.first.toInt() -1 -> {
                abstractChessBoard.getCellCondition(newPosition)?.killed()
                setFigurePosition(newPosition)
            }
            else -> throw Exception("Пешка не может так атаковать ")
        }
        convertToMainFigure(AttackKnight(abstractChessBoard))
    }
}

class ProtectionPawn(abstractChessBoard: AbstractChessBoard) : Pawn(abstractChessBoard) {
    override val skin: Char = '♙'
    override fun move(newPosition: Pair<Char, Int>) {
        TODO("Not yet implemented")
    }

    override fun attack(newPosition: Pair<Char, Int>) {
        TODO("Not yet implemented")
    }

    override fun beAbleToAttack(position: Pair<Char, Int>): Boolean {
        TODO("Not yet implemented")
    }

    override fun convertToMainFigure(figure: Figure) {
        TODO("Not yet implemented")
    }

    override val side: Side = Side.PROTECTION

}