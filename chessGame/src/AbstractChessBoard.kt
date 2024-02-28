import figures.Figure

interface AbstractChessBoard{
    fun isCellEmpty(position: Pair<Char, Int>): Boolean
    fun setFigure(figure: Figure)
    fun getCellCondition(position: Pair<Char, Int>): Figure?
    fun setCellCondition(position: Pair<Char, Int>, condition: Figure?)
}
