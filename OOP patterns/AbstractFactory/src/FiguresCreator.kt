import figures.AttackFigureFactory
import figures.FigureFactory
import figures.ProtectionFactory

class FiguresCreator{

    fun createFigure(side: Side){
        val figureFactory: FigureFactory = createFactory(side)
        figureFactory.setFigureOnBoard()
    }

    private fun createFactory(side: Side): FigureFactory {
        return when(side){
            Side.ATTACK -> AttackFigureFactory(ChessBoardLogic())
            Side.PROTECTION -> ProtectionFactory(ChessBoardLogic())
        }
    }
}