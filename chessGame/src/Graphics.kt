import figures.Figure

class ChessBoardCanvas {
    private val rows = ChessBoardLogic.getRows()
    private val columns = ChessBoardLogic.getColumns()
    private val chessMatrix = ChessBoardLogic.getChessPositionMatrix()
    fun drawBoard(){
        var cell:String
        for (rowIndex in rows.indices){
            println()
            print(rows[rowIndex])
            for (columnIndex in columns.indices) {
                val cellCondition = chessMatrix[rowIndex][columnIndex].invoke().second
                cell = if ((rowIndex + columnIndex) % 2 != 0)
                    "   "//black
                else
                    "[⬜]"//white
                if (cellCondition!=null)
                    cell = SetFigureSkinController(cellCondition).setFigureSkin(cell)
                print(cell)
            }
            print('|')
        }
        println("\n ${ChessBoardLogic.getColumns().contentToString()}")
    }
}

class SetFigureSkinController(private val figure: Figure){
    fun setFigureSkin(cell: String): String {
        return if (cell == "   ")
            " ${figure.getFigureSkin()} "
        else
            "[${figure.getFigureSkin()}]"
    }
}

