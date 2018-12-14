package com.ibteisaih.society.controllers;

import com.ibteisaih.society.GameActor;
import com.ibteisaih.society.actors.GameObject;

import java.util.ArrayList;
import java.util.List;

public class AIController {

    ArrayList<GameObject> control; //objects that the AI controls
    ArrayList<GameActor> noncontrol; //objects that the player controls

    public AIController(List<GameObject> control, List<GameActor> noncontrol){
        this.control = new ArrayList<GameObject>();
        this.noncontrol = new ArrayList<GameActor>();

        this.control.addAll(control);
        this.noncontrol.addAll(noncontrol);
    }

    public static List<GameObject> defaultStart(){
        List<GameObject> defualt = new ArrayList<GameObject>();

        //list of all the basic things a AI starts with

        return defualt;

    }


}
