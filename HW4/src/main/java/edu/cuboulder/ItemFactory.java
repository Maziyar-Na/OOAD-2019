package edu.cuboulder;

public class ItemFactory {
    public static ItemInterFace getPerson(ItemType itemType){
        if (itemType == ItemType.AUDIOPROGRAM){
            return new AudioProgram();
        } else if(itemType == ItemType.PUBLICATION){
            return new Publication();
        } else if(itemType == ItemType.VISUALPROGRAM){
            return new VisualProgram();
        }else{
            return null;
        }
    }
}
