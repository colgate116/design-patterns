package figures

import AbstractChessBoard

abstract class FigureFactory(val abstractChessBoard: AbstractChessBoard) {
    protected abstract val pawnsStartingPos: Array<Pair<Char, Int>>
    protected abstract val knightsStartingPos: Array<Pair<Char, Int>>
    protected abstract val bishopsStartingPos: Array<Pair<Char, Int>>

    protected abstract fun createPawn(position: Pair<Char,Int>): Pawn
    abstract fun createKnight(position: Pair<Char, Int>): Knight
    abstract fun createBishop(position: Pair<Char, Int>): Bishop

    fun setFigureOnBoard(){
        for (position in pawnsStartingPos)
            abstractChessBoard.setFigure(createPawn(position))
        for (position in knightsStartingPos)
            abstractChessBoard.setFigure(createKnight(position))
        for (position in bishopsStartingPos)
            abstractChessBoard.setFigure(createBishop(position))
    }

}

class AttackFigureFactory(abstractChessBoard: AbstractChessBoard) : FigureFactory(abstractChessBoard) {
    override val pawnsStartingPos: Array<Pair<Char, Int>>
        get() = arrayOf('a' to 2, 'b' to 2, 'c' to 2, 'd' to 2, 'e' to 2, 'f' to 2, 'g' to 2, 'h' to 2)
    override val knightsStartingPos: Array<Pair<Char, Int>>
        get() = arrayOf('b' to 1, 'g' to 1)
    override val bishopsStartingPos: Array<Pair<Char, Int>>
        get() = arrayOf('c' to 1, 'f' to 1)

    override fun createPawn(position: Pair<Char, Int>): Pawn {
        val pawn = AttackPawn(abstractChessBoard)
        pawn.setFigurePosition(position)
        return pawn
    }

    override fun createKnight(position: Pair<Char, Int>): Knight {
        val knight = AttackKnight(abstractChessBoard)
        knight.setFigurePosition(position)
        return knight
    }

    override fun createBishop(position: Pair<Char, Int>): Bishop {
        val bishop = AttackBishop(abstractChessBoard)
        bishop.setFigurePosition(position)
        return bishop
    }
}

class ProtectionFactory(abstractChessBoard: AbstractChessBoard) : FigureFactory(abstractChessBoard) {
    override val pawnsStartingPos: Array<Pair<Char, Int>>
        get() = arrayOf('a' to 7, 'b' to 7, 'c' to 7, 'd' to 7, 'e' to 7, 'f' to 7, 'g' to 7, 'h' to 7)
        //get() = arrayOf('a' to 3, 'b' to 3, 'c' to 3, 'd' to 3, 'e' to 3, 'f' to 3, 'g' to 3, 'h' to 3)
    override val knightsStartingPos: Array<Pair<Char, Int>>
        get() = arrayOf('b' to 8, 'g' to 8)
    override val bishopsStartingPos: Array<Pair<Char, Int>>
        get() = arrayOf('c' to 8, 'f' to 8)

    override fun createPawn(position: Pair<Char, Int>): Pawn {
        val pawn = ProtectionPawn(abstractChessBoard)
        pawn.setFigurePosition(position)
        return pawn
    }

    override fun createKnight(position: Pair<Char, Int>): Knight {
        val knight = ProtectionKnight(abstractChessBoard)
        knight.setFigurePosition(position)
        return knight
    }

    override fun createBishop(position: Pair<Char, Int>): Bishop {
        val bishop = ProtectionBishop(abstractChessBoard)
        bishop.setFigurePosition(position)
        return bishop
    }
}