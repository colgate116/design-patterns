class ChessGameController {
    private val isPlaying = true
    fun game(){
        FiguresCreator().createFigure(Side.ATTACK)
        FiguresCreator().createFigure(Side.PROTECTION)
        try {
            while (isPlaying) {
                //ChessLog().printBoardLog()
                ChessBoardCanvas().drawBoard()
                PlayerActionController().runAction()
                SideController().sideControl()
            }
        } catch (_: NullPointerException) {
            throw Exception("Figures was created without starting positions, create figures using class FigureCreator")
        }
    }
}

enum class Side{
    ATTACK, PROTECTION
}
