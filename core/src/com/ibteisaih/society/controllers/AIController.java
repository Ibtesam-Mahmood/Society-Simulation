package com.ibteisaih.society.controllers;

import com.ibteisaih.society.actors.BaseActor;
import com.ibteisaih.society.actors.DynamicActor;

import java.util.ArrayList;
import java.util.List;

public class AIController {

    ArrayList<DynamicActor> control; //objects that the AI controls
    ArrayList<BaseActor> noncontrol; //objects that the player controls

    public AIController(List<DynamicActor> control, List<BaseActor> noncontrol){
        this.control = new ArrayList<DynamicActor>();
        this.noncontrol = new ArrayList<BaseActor>();

        this.control.addAll(control);
        this.noncontrol.addAll(noncontrol);
    }

    public static List<DynamicActor> defaultStart(){
        List<DynamicActor> defualt = new ArrayList<DynamicActor>();

        //list of all the basic things a AI starts with

        return defualt;

    }


}
