package com.ibteisaih.society.controllers;

import com.ibteisaih.society.actors.BaseActor;
import com.ibteisaih.society.actors.DynamicActor;
import com.ibteisaih.society.actors.models.Model;
import com.ibteisaih.society.actors.models.Person;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AIController {

    private ArrayList<BaseActor> control; //objects that the AI controls

    ManageBaseActors manageBaseActors; //allows the modification of baseActors in the world

    //Allows the creation of an AI with the provided list
    public AIController(@Nullable  List<DynamicActor> control){
        this.control = new ArrayList<BaseActor>();
        if(control != null)
            this.control.addAll(control);

        World.ENTITIES.addAll(this.control);

        manageBaseActors = createActorManager();
    }

    public static List<DynamicActor> defaultStart(){
        List<DynamicActor> def = new ArrayList<DynamicActor>();

        //list of all the basic things a AI starts with
        def.add(new Person(100, 100));

        return def;

    }

    int count = 0;

    //allows the AI to perform Actions
    public void update(float dt){
        
    }


    private ManageBaseActors createActorManager(){
        return new ManageBaseActors() {
            @Override
            public void addEntitiy(BaseActor actor) {
                if(actor != null){

                    if(actor.getType() == BaseActor.ActorType.DYNAMIC)
                        ((DynamicActor) actor).setBaseActorManager(manageBaseActors);

                    control.add(actor);
                    World.addEntity(actor);
                }
            }

            @Override
            public void removeEntitiy(BaseActor actor) {
                if(actor != null){
                    control.remove(actor);
                    World.removeEntitiy(actor);
                }
            }

            @Override
            public BaseActor getEntity(Model model, float x, float y) {
                List<BaseActor> modelSpecific = getAllModel(model);
                for(BaseActor actor : modelSpecific){
                    //sort the actors y their deltas and return the main one
                }
                return modelSpecific.get(0);
            }

            @Override
            public List<BaseActor> getAllModel(Model model) {
                List<BaseActor> list = new ArrayList<BaseActor>();

                for(BaseActor actor : control){
                    if(actor.getModel() == model)
                        list.add(actor);
                }

                return list;
            }
        };
    }


}
