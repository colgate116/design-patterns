package figures

import AbstractChessBoard
import Side

abstract class Pawn(abstractChessBoard: AbstractChessBoard): Figure(abstractChessBoard) {
    var firstMove = true
    abstract fun convertToMainFigure(figure: Figure)
    override var position: Pair<Char, Int> = getFigurePosition()

    // правильно ли через DIP
    override fun beAbleToMove(position: Pair<Char, Int>): Boolean {
        return abstractChessBoard.isCellEmpty(position)
    }

    override fun beAbleToAttack(position: Pair<Char, Int>): Boolean {
        return !abstractChessBoard.isCellEmpty(position)
    }
}

class AttackPawn(abstractChessBoard: AbstractChessBoard) : Pawn(abstractChessBoard) {
    override val skin: Char = '♟'
    override val side: Side = Side.ATTACK

    //todo 
    override fun convertToMainFigure(figure: Figure) {

    }

    override fun move(newPosition: Pair<Char, Int>){
        if (beAbleToMove(newPosition)){
            if ((position.first == newPosition.first)&&(position.second<newPosition.second)) {
                when (newPosition.second) {
                    position.second + 1 -> setFigurePosition(newPosition)
                    position.second + 2 -> if (firstMove) {
                        firstMove = false
                        setFigurePosition(newPosition)
                    }
                    else -> throw Exception("Пешка не может так ходить")
                }
                convertToMainFigure(AttackBishop(abstractChessBoard))
            }
            else throw Exception("Пешка не может так ходить")
        }
        else
            throw Exception("Данная клетка недоступна для хода")
    }

    override fun attack(newPosition: Pair<Char, Int>) {
        if (beAbleToAttack(newPosition)){
            if ((position.second+1==newPosition.second)&&(position.first!=newPosition.first)){
                when (newPosition.first.toInt()){
                    position.first.toInt() +1 -> {
                        abstractChessBoard.getCellCondition(newPosition)?.killed()
                        setFigurePosition(newPosition)
                    }
                    position.first.toInt() -1 -> {
                        abstractChessBoard.getCellCondition(newPosition)?.killed()
                        setFigurePosition(newPosition)
                    }
                    else -> throw Exception("Пешка не может так ходить ")
                }
                convertToMainFigure(AttackBishop(abstractChessBoard))
            }
            else throw Exception("Пешка не может так ходить")
        }
        else throw Exception("Данная клетка недоступна для хода")
    }
}

class ProtectionPawn(abstractChessBoard: AbstractChessBoard) : Pawn(abstractChessBoard) {
    override val skin: Char = '♙'
    override val side: Side = Side.PROTECTION

    override fun convertToMainFigure(figure: Figure){
    }

    override fun move(newPosition: Pair<Char, Int>) {
        if (beAbleToMove(newPosition)){
            if ((position.first == newPosition.first)&&(position.second>newPosition.second)) {
                when (newPosition.second) {
                    position.second - 1 -> setFigurePosition(newPosition)
                    position.second - 2 -> if (firstMove) {
                        firstMove = false
                        setFigurePosition(newPosition)
                    }
                    else -> throw Exception("Пешка не может так ходить")
                }
                convertToMainFigure(ProtectionBishop(abstractChessBoard))
            }
            else throw Exception("Пешка не может так ходить")
        }
        else
            throw Exception("Данная клетка недоступна для хода")
    }

    override fun attack(newPosition: Pair<Char, Int>) {
        if (beAbleToAttack(newPosition)){
            if ((position.second-1==newPosition.second)&&(position.first!=newPosition.first)){
                when (newPosition.first.toInt()){
                    position.first.toInt() +1 -> {
                        abstractChessBoard.getCellCondition(newPosition)?.killed()
                        setFigurePosition(newPosition)
                    }
                    position.first.toInt() -1 -> {
                        abstractChessBoard.getCellCondition(newPosition)?.killed()
                        setFigurePosition(newPosition)
                    }
                    else -> throw Exception("Пешка не может так ходить ")
                }
                convertToMainFigure(ProtectionBishop(abstractChessBoard))
            }
            else throw Exception("Пешка не может так ходить")
        }
        else throw Exception("Данная клетка недоступна для хода")
    }
}