package sokoban.models;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GameEngine {

    private GridPane gameGrid;
    private ListGrid selectedLevel;

    public ListGrid getCurrentLevel() {
        return currentLevel;
    }
    private ListGrid currentLevel;
    private char characterFacing='D';
    private String stylePart1="-fx-background-image:url('textures/";
    private String stylePart2=".png'); -fx-background-size:cover;";
    private int characterX;
    private int characterY;
            
    public GameEngine() {
    }
    
    public void loadSelectedLevel(int lvlSelected) {
        selectedLevel = new ListGrid(11,11, FileTextReader.getLevelsList().get(lvlSelected-1));
        currentLevel = new ListGrid(11,11, FileTextReader.getLevelsList().get(lvlSelected-1));
        this.saveCharacterPosition();
        this.refreshLevel();
    }
    public void loadSavedLevel() {
        selectedLevel = new ListGrid(11,11,FileTextReader.getLevelsList().get(Character.getNumericValue(FileTextReader.getSavedLevel()[121]-1)) );
        currentLevel = new ListGrid(11,11, FileTextReader.getSavedLevel());
        this.saveCharacterPosition();
        this.refreshLevel();
    }
    
    public void refreshLevel() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(currentLevel.getElement(i, j).getCharacter()=='$'){
                    paintBox(i, j);
                }else{
                    paint(currentLevel.getElement(i, j).getCharacter(),i,j);
                }
            }
        }
    }

    private void paint(char character,int i,int j){
        //j*11+1 = La posicion del panel i,j en el gameGrid
        gameGrid.getChildren().get((j*11)+i).setStyle(stylePart1+charToTexture(character)+stylePart2);
    }
    
    private String charToTexture(char character){
        switch(character){
            case'*':return"transparent";
            case'#':return"brickWall";
            case'.':return"sandX";
            case'$':return"box";
            case' ':return"sand";
            case'-':return"greenBox";
            case'@':switch(this.characterFacing){
                    case'D':return "characterFront";
                    case'U':return "characterBack";
                    case'L':return "characterLeft";
                    case'R':return "characterRight";
                    default:return "characterFront";}
            default:return"";
        }
    }
    
    public void initializeGameGrid(GridPane gameGrid) {
            for (int i = 0; i <11; i++) {
                for (int j = 0; j <11; j++) {
                    gameGrid.add(new Pane(), i, j);
                }
            }
            this.gameGrid=gameGrid;
    }

    public void keyPressed(String key) {
        switch(key){
        case"W":this.moveCharacterUp();
            break;
        case"w":this.moveCharacterUp();
            break;
        case"S":this.moveCharacterDown();
            break;
        case"s":this.moveCharacterDown();
            break;
        case"A":this.moveCharacterLeft();
            break;
        case"a":this.moveCharacterLeft();
            break;
        case"D":this.moveCharacterRight();
            break;
        case"d":this.moveCharacterRight();
            break;
        default:break;
        }
    }

    private void moveCharacterUp() {
        if(this.isBox(characterX-1, characterY)&&this.isFree(characterX-2, characterY)){
            this.paintBox(characterX-2, characterY);
            this.eraseBox(characterX-1, characterY);
        }
        if(this.isFree(characterX-1, characterY)){
            this.eraseCharacter();
            characterX--;
        }
        this.characterFacing='U';
        this.paintCharacter();
    }

    private void moveCharacterDown() {
        if(this.isBox(characterX+1, characterY)&&this.isFree(characterX+2, characterY)){
            this.paintBox(characterX+2, characterY);
            this.eraseBox(characterX+1, characterY);
        }
        if(this.isFree(characterX+1, characterY)){
            this.eraseCharacter();
            characterX++;
        }
        this.characterFacing='D';
        this.paintCharacter();
    }

    private void moveCharacterLeft() {
        if(this.isBox(characterX, characterY-1)&&this.isFree(characterX, characterY-2)){
            this.paintBox(characterX, characterY-2);
            this.eraseBox(characterX, characterY-1);
        }
        if(this.isFree(characterX, characterY-1)){
            this.eraseCharacter();
            characterY--;
        }
        this.characterFacing='L';
        this.paintCharacter();
    }

    private void moveCharacterRight() {
        if(this.isBox(characterX, characterY+1)&&this.isFree(characterX, characterY+2)){
            this.paintBox(characterX, characterY+2);
            this.eraseBox(characterX, characterY+1);
        }
        if(this.isFree(characterX, characterY+1)){
            this.eraseCharacter();
            characterY++;
        }
        this.characterFacing='R';
        this.paintCharacter();
    }
    
    private boolean isBox(int x,int y){
        return this.currentLevel.getElement(x, y).getCharacter()=='$';
    }
    private boolean isWall(int x,int y){
        return this.currentLevel.getElement(x, y).getCharacter()=='#';
    }
    private boolean isFree(int x, int y){
        return this.currentLevel.getElement(x, y).getCharacter()==' '||this.currentLevel.getElement(x, y).getCharacter()=='.';
    }
    
    private void saveCharacterPosition() {
        for (int k = 0; k < 11; k++) {
            for (int l = 0; l < 11; l++) {
                if(currentLevel.getElement(l, k).getCharacter()=='@'){
                this.characterX=l;
                this.characterY=k;
                return;
                }
            }
        }
    }
    
    private boolean standingOnX(){
        return (this.selectedLevel.getElement(characterX, characterY).getCharacter()=='.');
    }
    
    private void eraseCharacter() {
        if(this.standingOnX()){
            paint('.', characterX, characterY);
            this.currentLevel.getElement(characterX, characterY).setCharacter('.');
        }else{
            paint(' ', characterX, characterY);
            this.currentLevel.getElement(characterX, characterY).setCharacter(' ');
        }
    }
    
    private void paintCharacter() {
        paint('@', characterX, characterY);
        this.currentLevel.getElement(characterX, characterY).setCharacter('@');
    }
    
    private void eraseBox(int x,int y) {
        this.currentLevel.getElement(x, y).setCharacter(' ');
    }
    
    private void paintBox(int x,int y) {
        if(this.selectedLevel.getElement(x, y).getCharacter()=='.'){
            paint('-', x, y);
        }else{
            paint('$', x, y);
        }
        this.currentLevel.getElement(x, y).setCharacter('$');
    }

}