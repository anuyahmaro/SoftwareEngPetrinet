package gui;

import logic.PlaceInterface;

import java.awt.*;
import java.util.Random;

public class Place2DObject implements  Petrinet2DObjectInterface{
    private Point point;
    private PlaceInterface place;
    private final int PLACE_RADIUS =40;
    private final int TOKEN_RADIUS =5;
    private SelectObject objectType;

    private final int TEXTPADDING =40;
    private final Color TRANSITIONCOLOR = Color.black;
    private final Color TEXTCOLOR = Color.BLACK;
    private final Color TOKENCOLOR = Color.black;
    private String Id;

    //TODO change this name back to the back end's
    private String Name;

    public Place2DObject(PlaceInterface place){
        this.place = place;
    }



    @Override
    public Point getPoint() {
        return point;
    }

    @Override
    public SelectObject getObjectType() {
        return objectType;
    }

    @Override
    public void setObjectType(SelectObject selectObject) {
        this.objectType = selectObject;
    }

    @Override
    public void draw(Graphics graphics) {
        Random ran = new Random();
        graphics.setColor(TRANSITIONCOLOR);
        graphics.drawOval((int)point.getX(),(int)point.getY(),PLACE_RADIUS,PLACE_RADIUS);
        graphics.setColor(TEXTCOLOR);

        graphics.drawString(getName() +" <"+place.getNumTokens()+">",(int)point.getX(),(int)point.getY()+PLACE_RADIUS+TEXTPADDING);
        // This simple logic is to draw tokens within
        // the circle
        int randX = 0;
        int randY = 0;

        int randPadding=9;
        graphics.setColor(TOKENCOLOR);
        for(int i = 0; i <place.getNumTokens();i++){
             randX = ran.nextInt(PLACE_RADIUS-randPadding)+(int)point.getX() +(i==0?randPadding:0);
             randY = ran.nextInt(PLACE_RADIUS-randPadding)+(int)point.getY()+(i==0?randPadding:0);

            graphics.fillOval(randX,randY,TOKEN_RADIUS,TOKEN_RADIUS);
        }

    }

    @Override
    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public void setID(String Id) {
        this.Id = Id;
    }

    @Override
    public String getID() {
        return Id;
    }

    @Override
    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String getName() {
        return Name;
    }


    public PlaceInterface getPlace() {
        return place;
    }
}