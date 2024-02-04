import figures.Figure

interface AbstractChessBoard{
    fun isCellEmpty(position: Pair<Char, Int>): Boolean
    fun setCell(figure: Figure)
    fun getCellCondition(position: Pair<Char, Int>): Figure?
}
