package com.example.state.Service;

import com.example.state.Model.State;
import com.example.state.Repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    private final StateRepository stateRepository;

   public  StateService(StateRepository stateRepository){
   this.stateRepository = stateRepository;
   }

   public State addState(State state){
       return stateRepository.save(state);
   }

   public List<State> getState(){
       return stateRepository.findAll();
   }
   public State editState(State state){
       return  stateRepository.save(state);
   }
   public boolean deleteState(int id){
   Optional<State> state = stateRepository.findById(id);
   if(state.isPresent()){
       stateRepository.delete(state.get());
       return true;
   }
      return false;
   }

}
