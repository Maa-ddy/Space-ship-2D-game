
package gamesemproject.worlds;

import gamesemproject.Handler;
import gamesemproject.entities.EntityManager;
import gamesemproject.entities.staticEntities.Base;
import gamesemproject.entities.creatures.Player;
import gamesemproject.entities.staticEntities.BonusBase;
import gamesemproject.entities.staticEntities.FireBase;
import gamesemproject.gfx.Assets;
import gamesemproject.tiles.Tile;
import gamesemproject.utils.Utils;
import java.awt.Graphics;


public class World {
    
    private int[][] map;
    private int terrain;
    private int mapWidth, mapHeight;
    private int spawnX,spawnY;
    private Handler handler;
    private EntityManager entityManager;
    
    public World(Handler handler,String path){
        //we create a world in the GameState class
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler,300,300));
        loadWorld(path);
    }
    
    private void loadWorld(String path){
        String[] file = Utils.loadFileAsString(path).split("[ ]+");
        mapWidth = Integer.parseInt(file[0]);
        mapHeight = Integer.parseInt(file[1]);
        spawnX = Integer.parseInt(file[2]);
        spawnY = Integer.parseInt(file[3]);
        terrain = Integer.parseInt(file[4]);
        map = new int[mapWidth][mapHeight];
        for (int row = 0; row<mapWidth; row++){
            for (int col = 0; col<mapHeight; col++){
                map[row][col] = Integer.parseInt(file[row*mapWidth + col + 5]);
            }            
        }
        entityManager.addStaticEntity(new Base(handler,100,100));
        entityManager.addStaticEntity(new Base(handler,555,135));
        entityManager.addStaticEntity(new Base(handler,450,450));
        entityManager.addStaticEntity(new Base(handler,770,60));
        entityManager.addStaticEntity(new Base(handler,1200,1500));
        entityManager.addStaticEntity(new Base(handler,1215,400));
        entityManager.addStaticEntity(new Base(handler,1265,780));
        entityManager.addStaticEntity(new Base(handler,85,795));
        entityManager.addStaticEntity(new Base(handler,205,1515));
        entityManager.addStaticEntity(new Base(handler,365,1155));
        entityManager.addStaticEntity(new Base(handler,1520,1370));
        entityManager.addStaticEntity(new Base(handler,975,1370));
        entityManager.addStaticEntity(new Base(handler,955,1510));
        entityManager.addStaticEntity(new Base(handler,50,1505));
        entityManager.addStaticEntity(new Base(handler,875,485));
        entityManager.addStaticEntity(new Base(handler,1275,1025));
        entityManager.addStaticEntity(new Base(handler,1320,695));
        
        
        entityManager.addStaticEntity(new FireBase(handler,150,200));
        entityManager.addStaticEntity(new FireBase(handler,305,365));
        entityManager.addStaticEntity(new FireBase(handler,700,330));
        entityManager.addStaticEntity(new FireBase(handler,435,695));
        entityManager.addStaticEntity(new FireBase(handler,745,665));
        entityManager.addStaticEntity(new FireBase(handler,1280,200));
        entityManager.addStaticEntity(new FireBase(handler,1425,435));
        entityManager.addStaticEntity(new FireBase(handler,1465,890));
        entityManager.addStaticEntity(new FireBase(handler,705,1260));
        entityManager.addStaticEntity(new FireBase(handler,1135,1140));
        entityManager.addStaticEntity(new FireBase(handler,260,1210));
        entityManager.addStaticEntity(new FireBase(handler,480,1455));
        entityManager.addStaticEntity(new FireBase(handler,320,935));
        //entityManager.addStaticEntity(new FireBase(handler,1400,1000));
        entityManager.addStaticEntity(new FireBase(handler,1255,1025));
        entityManager.addStaticEntity(new FireBase(handler,635,1160));
       //
        
        
        entityManager.addStaticEntity(new BonusBase(handler,980,610));
        entityManager.addStaticEntity(new BonusBase(handler,600,1000));
        entityManager.addStaticEntity(new BonusBase(handler,250,545));
     //   entityManager.addStaticEntity(new BonusBase(handler,1,555));
        entityManager.addStaticEntity(new BonusBase(handler,400,545));
        entityManager.addStaticEntity(new BonusBase(handler,60,480));
        entityManager.addStaticEntity(new BonusBase(handler,1500,540));
        entityManager.addStaticEntity(new BonusBase(handler,1220,550));
        entityManager.addStaticEntity(new BonusBase(handler,850,855));
        entityManager.addStaticEntity(new BonusBase(handler,645,855));
        entityManager.addStaticEntity(new BonusBase(handler,70,660));
        entityManager.addStaticEntity(new BonusBase(handler,805,1040));
        entityManager.addStaticEntity(new BonusBase(handler,130,1378));
        entityManager.addStaticEntity(new BonusBase(handler,70,1260));
        entityManager.addStaticEntity(new BonusBase(handler,1500,60));
        entityManager.addStaticEntity(new BonusBase(handler,1495,230));
        entityManager.addStaticEntity(new BonusBase(handler,1090,545));
        entityManager.addStaticEntity(new BonusBase(handler,90,1080));
        entityManager.addStaticEntity(new BonusBase(handler,1410,1225));
        entityManager.addStaticEntity(new BonusBase(handler,1285,1365));
        entityManager.addStaticEntity(new BonusBase(handler,995,1210));
        entityManager.addStaticEntity(new BonusBase(handler,580,1420));
        entityManager.addStaticEntity(new BonusBase(handler,1075,720));
        entityManager.addStaticEntity(new BonusBase(handler,960,270));
     
    }
    
    private void createLevel(){
        
    }
    
    public void tick(){
        entityManager.tick();
    }
    
    public void render(Graphics g){
        int rowStart, rowEnd,colStart, colEnd;
        colStart = (int) Math.max(0,handler.getCamera().getXOffset()/Tile.DEFAULT_TILE_WIDTH);
        rowStart = (int) Math.max(0,handler.getCamera().getYOffset()/Tile.DEFAULT_TILE_HEIGHT);
        colEnd = (int) Math.min(mapWidth-1, (handler.getCamera().getXOffset() + handler.getWindowWidth())/Tile.DEFAULT_TILE_WIDTH);
        rowEnd = (int) Math.min(mapHeight-1,(handler.getCamera().getYOffset() + handler.getWindowHeight())/Tile.DEFAULT_TILE_HEIGHT);
        
        //System.out.println("camera x = "+handler.getCamera().getXOffset());
        //System.out.println("camera y = "+handler.getCamera().getYOffset());
        
        renderTerrain(g);
        for (int row = rowStart; row<=rowEnd; row++){
            for (int col = colStart; col<=colEnd; col++){
                getTile(row, col).render(g, (int)-handler.getCamera().getXOffset() + col*Tile.DEFAULT_TILE_WIDTH, 
                                            (int)-handler.getCamera().getYOffset() + row*Tile.DEFAULT_TILE_HEIGHT);
            //note the (row,col) inverted inside render(g,col,row)
            }
        }
        entityManager.render(g);
    }
    
    private void renderTerrain(Graphics g){
        int rowStart,rowEnd, colStart, colEnd;
        colStart = (((int) Math.max(0,handler.getCamera().getXOffset()/Tile.DEFAULT_TILE_WIDTH))/3)*3; //3 is the ratio of widths between the terrain tile and a regular tile
        rowStart = (((int) Math.max(0,handler.getCamera().getYOffset()/Tile.DEFAULT_TILE_HEIGHT))/3)*3;
        colEnd = (int) Math.min(mapWidth, (handler.getCamera().getXOffset() + handler.getWindowWidth())/Tile.DEFAULT_TILE_WIDTH);
        rowEnd = (int) Math.min(mapHeight,(handler.getCamera().getYOffset() + handler.getWindowHeight())/Tile.DEFAULT_TILE_HEIGHT);
        
        for (int row = rowStart; row<=rowEnd; row+=Assets.terrainWidth/Tile.DEFAULT_TILE_WIDTH){
            for (int col = colStart; col<=colEnd; col+=Assets.terrainHeight/Tile.DEFAULT_TILE_HEIGHT){
                Tile.tiles[terrain].render(g, (int)-handler.getCamera().getXOffset() + col*Tile.DEFAULT_TILE_WIDTH, 
                                              (int)-handler.getCamera().getYOffset() + row*Tile.DEFAULT_TILE_HEIGHT);
                //note the (row,col) inverted inside render(g,col,row)
            }
        }
    }
    
    public Tile getTile(int x,int y){
        Tile temp = Tile.tiles[map[x][y]];
        if (temp == null){
            return Tile.tiles[0]; // by default, render an empty image
        }
        return temp;
    }
    
    
    
    //getters & setters:
    public EntityManager getEntityManager(){ return entityManager; }
    public int getMapWidth(){ return mapWidth; }
    public int getMapHeight(){ return mapHeight; }
    
}
