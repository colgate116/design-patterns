class ChessLog() {
    fun printBoardLog(){
        val board = ChessBoardLogic.getChessPositionMatrix()
        for (row in board){
            println(row.forEach { println(it.invoke()) })
        }
    }
}