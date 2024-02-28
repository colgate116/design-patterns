package figures

import AbstractChessBoard
import Side
//todo взятие пешки на проходе
abstract class Pawn(abstractChessBoard: AbstractChessBoard): Figure(abstractChessBoard) {
    var firstMove = true
    abstract val mainFigureSwitchPoint: Int
    override var position: Pair<Char, Int>? = getFigurePosition()

    override fun beAbleToMove(position: Pair<Char, Int>): Boolean {
        return abstractChessBoard.isCellEmpty(position)
    }
    fun convertToMainFigure(figure: Figure) {
        if (position?.second==mainFigureSwitchPoint) {
            figure.setFigurePosition(position)
            abstractChessBoard.setCellCondition(position!!, null)
            setFigurePosition(null)
            abstractChessBoard.setFigure(figure)
        }
    }
}

class AttackPawn(abstractChessBoard: AbstractChessBoard) : Pawn(abstractChessBoard) {
    override val skin: Char = '♟'
    override val side: Side = Side.ATTACK
    override val mainFigureSwitchPoint: Int = 8
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
        if ((newPosition.second == (position!!.second + 1) )||
        ((newPosition.second == (position!!.second + 2)) && firstMove
        && abstractChessBoard.isCellEmpty(newPosition.first to newPosition.second-1))){
            abstractChessBoard.setCellCondition(position!!, null)
            setFigurePosition(newPosition)
            abstractChessBoard.setCellCondition(position!!, this)
        }
        else
            throw Exception("Пешка не может так ходить")
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
        if ((position!!.second+1!=newPosition.second)||(position?.first==newPosition.first)){
            throw Exception("Пешка не может так атаковать")
        }
        if (firstMove){
            firstMove = false
        }
        if ((newPosition.first.toInt()==position!!.first.toInt() +1)||
        (newPosition.first.toInt()==position!!.first.toInt()-1)){
            val enemyFigure =  abstractChessBoard.getCellCondition(newPosition)
            abstractChessBoard.setCellCondition(position!!, null)
            setFigurePosition(newPosition)
            abstractChessBoard.setCellCondition(position!!, this)
            enemyFigure?.killed()
        }
        else
            throw Exception("Пешка не может так атаковать ")
        convertToMainFigure(AttackKnight(abstractChessBoard))
    }
}

class ProtectionPawn(abstractChessBoard: AbstractChessBoard) : Pawn(abstractChessBoard) {
    override val skin: Char = '♙'
    override val mainFigureSwitchPoint: Int = 1
    override val side: Side = Side.PROTECTION

    override fun move(newPosition: Pair<Char, Int>) {
        if (getFigurePosition()==null){
            throw Exception("Пешка находится вне шахматной доски")
        }
        if (!beAbleToMove(newPosition)) {
            throw Exception("Данная клетка недоступна для хода")
        }
        if ((position?.first != newPosition.first)||(position?.second!!<=newPosition.second)) {
            throw Exception("Пешка не может так ходить")
        }
        if ((newPosition.second == (position!!.second - 1) )||
        ((newPosition.second == (position!!.second - 2)) && firstMove
        && abstractChessBoard.isCellEmpty(newPosition.first to newPosition.second+1))){
            abstractChessBoard.setCellCondition(position!!, null)
            setFigurePosition(newPosition)
            abstractChessBoard.setCellCondition(position!!, this)
        }
        else
            throw Exception("Пешка не может так ходить")
        if (firstMove){
            firstMove = false
        }
        convertToMainFigure(AttackKnight(abstractChessBoard))
    }

    override fun attack(newPosition: Pair<Char, Int>) {
        TODO("Not yet implemented")
    }

    override fun beAbleToAttack(position: Pair<Char, Int>): Boolean {
        TODO("Not yet implemented")
    }

}