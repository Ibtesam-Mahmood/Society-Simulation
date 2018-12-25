package com.ibteisaih.society.controllers;

import com.badlogic.gdx.utils.compression.lzma.Base;
import com.ibteisaih.society.actors.BaseActor;
import com.ibteisaih.society.actors.DynamicActor;
import com.ibteisaih.society.actors.models.Model;
import com.ibteisaih.society.actors.models.Person;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AIController {


    private ArrayList<BaseActor> control; //objects that the AI controls

    private HashMap<Params, Integer> AIParams; // The parameters that create the AI

    ManageAI manageAI; //allows the modification of baseActors in the world

    //Allows the creation of an AI with the provided list
    public AIController(@Nullable  List<DynamicActor> control){
        this.control = new ArrayList<BaseActor>();
        if(control != null)
            this.control.addAll(control);

        World.NEXTENTITIES.addAll(this.control);

        createParams(); //adds the AI parameters

        manageAI = createActorManager();
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
        count++;
        if(count == 1){
            manageAI.addEntitiy(new Person((float) Math.random() * 100, (float) Math.random() * 100));
        }
    }

    //Checks and modifies the paramets based off thr adding or removing of a base actor
    private boolean checkParams(BaseActor actor, boolean remove){
        if(remove){ //removing the base actor

            //Person
            if(actor.getModel() == Model.PERSON) modifyParameter(Params.POPULATION, -1);

        }
        else{ //adding the base actor

            if(actor.getModel() == Model.PERSON){ //Person
                if(AIParams.get(Params.POPULATIONMAX) == AIParams.get(Params.POPULATION)) return false; //If the population max is reached
                else{ //Population max not reached
                    modifyParameter(Params.POPULATION, 1); //add one to population
                    return true;
                }
            }

        }

        return true; //allows the process to be carries on
    }

    //Modifies a parameter based on a mod value
    private void modifyParameter(Params parameter, int mod){
        if(AIParams.containsKey(parameter)){
            int newValue = AIParams.get(parameter) + mod;
            if(newValue <= 0) //if the value is negative clamp to zero
                AIParams.put(parameter, 0);
            else //if the value is positive update
                AIParams.put(parameter, newValue);
        }
    }


    private ManageAI createActorManager(){
        return new ManageAI() {
            @Override
            public void addEntitiy(BaseActor actor) {
                if(actor != null){

                    if(!checkParams(actor, false)) return; //check the parameters before modifying the AI

                    if(actor.getType() == BaseActor.ActorType.DYNAMIC)
                        ((DynamicActor) actor).setAIResponder(manageAI);

                    control.add(actor);
                    World.addEntity(actor);
                }
            }

            @Override
            public void removeEntitiy(BaseActor actor) {
                if(actor != null){
                    if(!checkParams(actor, true)) return; //check the parameters before modifying the AI

                    control.remove(actor);
                    World.removeEntity(actor);
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

    private void createParams(){
        AIParams = new HashMap<Params, Integer>();

        AIParams.put(Params.POPULATION, 0);
        AIParams.put(Params.POPULATIONMAX, 2);
    }


}
