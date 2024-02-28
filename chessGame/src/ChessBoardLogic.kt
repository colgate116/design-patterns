import figures.Figure

object ChessBoardLogic: AbstractChessBoard {
    private val boardRows = arrayOf(8, 7, 6, 5, 4, 3, 2, 1)
    private val boardColumns = arrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')
    private val chessBoardMatrix: Array<Array<() -> Pair<Pair<Char, Int>, Figure?>>> =
        Array(8) { i -> Array(8) { j -> { Pair(boardColumns[j] to boardRows[i], null) } } }
    fun getRows() = boardRows
    fun getColumns() = boardColumns
    fun getChessPositionMatrix() = chessBoardMatrix
    override fun isCellEmpty(position: Pair<Char, Int>): Boolean {
        val coordinates = findCellByPosition(position)
        return chessBoardMatrix[coordinates.first][coordinates.second].invoke().second==null
    }
    override fun setFigure(figure: Figure) {
        if (figure.getFigurePosition()!=null) {
            val coordinate = findCellByPosition(figure.getFigurePosition()!!)
            chessBoardMatrix[coordinate.first][coordinate.second] = { (figure.getFigurePosition()!! to figure) }
        }
        else
            throw Exception("Figures was created without starting positions, create figures using class FigureCreator")
    }
    override fun getCellCondition(position: Pair<Char, Int>): Figure? {
        val coordinate = findCellByPosition(position)
        return chessBoardMatrix[coordinate.first][coordinate.second].invoke().second
    }
    override fun setCellCondition(position: Pair<Char, Int>, condition: Figure?) {
        val coordinates = findCellByPosition(position)
        chessBoardMatrix[coordinates.first][coordinates.second] = {position to condition}
    }
    //todo отрефакторить эту функцию и систему хранения данных
    private fun findCellByPosition(position: Pair<Char, Int>): Pair<Int, Int> {
        for (rowIndex in chessBoardMatrix.indices)
            for (columnIndex in chessBoardMatrix[rowIndex].indices)
                if ((chessBoardMatrix[rowIndex][columnIndex].invoke().first == position))
                    return rowIndex to columnIndex
        throw Exception("Такой клетки не существует")
    }

    fun interactionWithFigure(oldPosition: Pair<Char, Int>, newPosition: Pair<Char, Int>, action: Action){
        object {
            fun interactionWithFigure(oldPosition: Pair<Char, Int>, newPosition: Pair<Char, Int>, action: Action) {
                val figure = getCellCondition(oldPosition)
                if (figure != null) {
                    actionRunning(figure, action, newPosition)
                } else
                    throw Exception("На клетке нет фигур для перемещения")
            }

            private fun actionRunning(figure: Figure, action: Action, newPosition: Pair<Char, Int>) {
                when (action) {
                    Action.MOVE -> figure.move(newPosition)
                    Action.ATTACK -> figure.attack(newPosition)
                }
            }
        }.interactionWithFigure(oldPosition, newPosition, action)
    }
}
