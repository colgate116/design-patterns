package figures

import AbstractChessBoard
import Side

abstract class Pawn(abstractChessBoard: AbstractChessBoard): Figure(abstractChessBoard) {
    var firstMove = true
    abstract val mainFigureSwitchPoint: Int
    abstract fun convertToMainFigure(figure: Figure)
    override var position: Pair<Char, Int>? = getFigurePosition()

    override fun beAbleToMove(position: Pair<Char, Int>): Boolean {
        return abstractChessBoard.isCellEmpty(position)
    }
}

class AttackPawn(abstractChessBoard: AbstractChessBoard) : Pawn(abstractChessBoard) {
    override val skin: Char = '♟'
    override val side: Side = Side.ATTACK
    override val mainFigureSwitchPoint: Int = 8

    override fun convertToMainFigure(figure: Figure) {
        figure.setFigurePosition(position!!.first to mainFigureSwitchPoint)
        abstractChessBoard.setCellCondition(this.position!!, null)
        this.setFigurePosition(null)
        abstractChessBoard.setCell(figure)
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
                if (newPosition.second != mainFigureSwitchPoint){
                    abstractChessBoard.setCellCondition(position!!, null)
                    setFigurePosition(newPosition)
                    abstractChessBoard.setCellCondition(position!!, this)
                }
                else convertToMainFigure(AttackKnight(abstractChessBoard))
            }
            (newPosition.second == (position!!.second + 2)) && firstMove ->
            {
                abstractChessBoard.setCellCondition(position!!, null)
                setFigurePosition(newPosition)
                abstractChessBoard.setCellCondition(position!!, this)
            }
            else -> throw Exception("Пешка не может так ходить")
        }
        if (firstMove){
            firstMove = false
        }
    }
    override fun attack(newPosition: Pair<Char, Int>) {
//        if (getFigurePosition()==null){
//            throw Exception("Пешка находится вне шахматной доски")
//        }
//        if (!beAbleToAttack(newPosition)){
//            throw Exception("Данная клетка недоступна для атаки")
//        }
//        if ((position!!.second+1!=newPosition.second)&&(position?.first==newPosition.first)){
//            throw Exception("Пешка не может так атаковать")
//        }
//        when (newPosition.first.toInt()){
//            position!!.first.toInt() +1 -> {
//                abstractChessBoard.getCellCondition(newPosition)?.killed()
//                setFigurePosition(newPosition)
//            }
//            position!!.first.toInt() -1 -> {
//                abstractChessBoard.getCellCondition(newPosition)?.killed()
//                setFigurePosition(newPosition)
//            }
//            else -> throw Exception("Пешка не может так атаковать ")
//        }
//        if (firstMove){
//            firstMove = false
//        }
//        convertToMainFigure(AttackKnight(abstractChessBoard))
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

    override val mainFigureSwitchPoint: Int
        get() = TODO("Not yet implemented")

    override fun convertToMainFigure(figure: Figure) {
        TODO("Not yet implemented")
    }

    override val side: Side = Side.PROTECTION

}